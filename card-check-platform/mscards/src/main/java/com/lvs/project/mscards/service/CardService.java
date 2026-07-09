package com.lvs.project.mscards.service;


import com.lvs.project.mscards.entity.Card;
import com.lvs.project.mscards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(final Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getCardsByEqualLowerIncome(final Long income) {
        var salaryIncome = BigDecimal.valueOf(income);
        return cardRepository.findBySalaryIncomeLessThanEqual(salaryIncome);
    }
}
