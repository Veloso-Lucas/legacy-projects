package com.lvb.project.mscreditassessor.service;

import com.lvb.project.mscreditassessor.clients.CardResourceClient;
import com.lvb.project.mscreditassessor.clients.CustomerResourceClient;
import com.lvb.project.mscreditassessor.dto.*;
import com.lvb.project.mscreditassessor.exception.CustomerDataNotFoundException;
import com.lvb.project.mscreditassessor.exception.MsRequestErrorException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreditAssessorService {

    private final CustomerResourceClient customerResourceClient;
    private final CardResourceClient cardResourceClient;


    public CustomerSituation getCustomerSituation(final String cpf) {

        try {
            ResponseEntity<CustomerData> responseEntity = customerResourceClient.getCustomerByCpf(cpf);
            ResponseEntity<List<CustomerCard>> cardResponse = cardResourceClient.getCardsByCpf(cpf);

            return CustomerSituation.builder()
                    .customer(responseEntity.getBody())
                    .cards(cardResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
            var status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new CustomerDataNotFoundException();
            }

            throw new MsRequestErrorException(e.getMessage(), status);
        }
    }

    public ResponseAssessmentCustomer doAssessment(final String cpf, Long income) {
        try {
            ResponseEntity<CustomerData> customerResponse = customerResourceClient.getCustomerByCpf(cpf);
            ResponseEntity<List<Card>> cardResponse = cardResourceClient.getCardsByEqualLowerIncome(income);

            var cards = cardResponse.getBody();
            var customer = customerResponse.getBody();

            List<ApprovedCard> approvedCardList = cards != null ? cards.stream().map(card -> {
                var basicLimit = card.getBasicLimit();
                var ageBD = BigDecimal.valueOf(Objects.requireNonNull(customer).getAge());

                var factor = ageBD.divide(BigDecimal.TEN, RoundingMode.DOWN);
                var approvedLimit = factor.multiply(basicLimit);

                ApprovedCard approvedCard = new ApprovedCard();
                approvedCard.setCard(card.getName());
                approvedCard.setBrand(card.getBrand());
                approvedCard.setApprovedLimit(approvedLimit);

                return approvedCard;
            }).toList() : List.of();

            return new ResponseAssessmentCustomer(approvedCardList);

        } catch (FeignException.FeignClientException e) {
            var status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new CustomerDataNotFoundException();
            }

            throw new MsRequestErrorException(e.getMessage(), status);
        }
    }
}
