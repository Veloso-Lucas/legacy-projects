package com.lvs.project.mscards.controller;

import com.lvs.project.mscards.dto.CardSaveRequest;
import com.lvs.project.mscards.dto.CardsByCustomerResponse;
import com.lvs.project.mscards.entity.Card;
import com.lvs.project.mscards.service.CardService;
import com.lvs.project.mscards.service.CustomerCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CustomerCardService customerCardService;


    @PostMapping
    public ResponseEntity<CardSaveRequest> save(@RequestBody final CardSaveRequest request) {
        var card = request.toModel();
        cardService.save(card);
        return ResponseEntity.ok(request);
    }

    @GetMapping(params = "salaryIncome")
    public ResponseEntity<List<Card>> getCardsByEqualLowerIncome(@RequestParam final Long salaryIncome) {
        var cardList = cardService.getCardsByEqualLowerIncome(salaryIncome);
        return ResponseEntity.ok(cardList);
    }


    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByCustomerResponse>> getCardsByCpf(@RequestParam final String cpf) {
        var cardsByCustomer = customerCardService.findByCpf(cpf);
        var cardsByCustomerResponse = cardsByCustomer.stream().map(CardsByCustomerResponse::fromModel).toList();
        return ResponseEntity.ok(cardsByCustomerResponse);
    }


}
