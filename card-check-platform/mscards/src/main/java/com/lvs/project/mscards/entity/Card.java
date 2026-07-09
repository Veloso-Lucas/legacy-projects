package com.lvs.project.mscards.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CardBrand brand;

    private BigDecimal salaryIncome;

    private BigDecimal basicLimit;

    public Card(String name, CardBrand brand, BigDecimal salaryIncome, BigDecimal basicLimit) {
        this.name = name;
        this.brand = brand;
        this.salaryIncome = salaryIncome;
        this.basicLimit = basicLimit;
    }
}
