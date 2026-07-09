package com.lvb.project.mscreditassessor.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Card {

    private String name;

    private String brand;

    private BigDecimal basicLimit;

}
