package com.lvb.project.mscreditassessor.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApprovedCard {

    private String card;
    private String brand;
    private BigDecimal approvedLimit;
}
