package com.lvb.project.msclients.controller;

import com.lvb.project.msclients.dto.CustomerSaveDTO;
import com.lvb.project.msclients.entity.Customer;
import com.lvb.project.msclients.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerSaveDTO> save(@RequestBody final CustomerSaveDTO request) {
        var customer = request.toModel();

        customerService.save(customer);

        var headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(customer.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).body(request);
    }


    @GetMapping(params = "cpf")
    public ResponseEntity<Customer> getCustomerByCpf(@RequestParam("cpf") final String cpf) {
        var customer = customerService.getByCPF(cpf);

        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());

    }

}
