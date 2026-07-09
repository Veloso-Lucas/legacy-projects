package com.lvb.project.mscreditassessor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSituation {

    private CustomerData customer;
    private List<CustomerCard> cards;
}
