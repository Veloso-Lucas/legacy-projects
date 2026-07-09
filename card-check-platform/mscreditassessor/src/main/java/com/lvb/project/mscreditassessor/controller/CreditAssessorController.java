package com.lvb.project.mscreditassessor.controller;

import com.lvb.project.mscreditassessor.dto.AssessmentData;
import com.lvb.project.mscreditassessor.dto.CustomerSituation;
import com.lvb.project.mscreditassessor.dto.ResponseAssessmentCustomer;
import com.lvb.project.mscreditassessor.exception.CustomerDataNotFoundException;
import com.lvb.project.mscreditassessor.service.CreditAssessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit-evaluations")
public class CreditAssessorController {

    private final CreditAssessorService creditAssessorService;

    @GetMapping(value = "/customer-situation", params = "cpf")
    public ResponseEntity<CustomerSituation> consultCustomerSituation(@RequestParam("cpf") final String cpf) {
        try {
            var customerSituation = creditAssessorService.getCustomerSituation(cpf);
            return ResponseEntity.ok(customerSituation);
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<ResponseAssessmentCustomer> doAssessment(@RequestBody AssessmentData data) {
        try {
            var response = creditAssessorService.doAssessment(data.getCpf(), data.getIncome());
            return ResponseEntity.ok(response);
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
