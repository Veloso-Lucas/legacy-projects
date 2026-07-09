package com.lvb.project.mscreditassessor.clients;

import com.lvb.project.mscreditassessor.dto.Card;
import com.lvb.project.mscreditassessor.dto.CustomerCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CustomerCard>> getCardsByCpf(@RequestParam final String cpf);

    @GetMapping(params = "salaryIncome")
    ResponseEntity<List<Card>> getCardsByEqualLowerIncome(@RequestParam final Long salaryIncome);
}
