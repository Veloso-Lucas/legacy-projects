package com.lvs.project.mscards.service;

import com.lvs.project.mscards.entity.CustomerCard;
import com.lvs.project.mscards.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCardService {

    private final CustomerCardRepository cardRepository;


    public List<CustomerCard> findByCpf(final String cpf) {
        return cardRepository.findByCpf(cpf);
    }
}
