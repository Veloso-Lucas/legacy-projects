package com.lvb.project.msclients.service;

import com.lvb.project.msclients.entity.Customer;
import com.lvb.project.msclients.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Transactional
    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }


    public Optional<Customer> getByCPF(final String cpf) {
        return customerRepository.findByCpf(cpf);

    }
}
