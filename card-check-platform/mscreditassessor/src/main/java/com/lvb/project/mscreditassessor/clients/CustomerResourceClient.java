package com.lvb.project.mscreditassessor.clients;

import com.lvb.project.mscreditassessor.dto.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclients", path = "/customers")
public interface CustomerResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<CustomerData> getCustomerByCpf(@RequestParam("cpf") final String cpf);
}
