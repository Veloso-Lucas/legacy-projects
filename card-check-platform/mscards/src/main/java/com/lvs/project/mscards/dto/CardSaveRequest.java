package com.lvs.project.mscards.dto;

import com.lvs.project.mscards.entity.Card;
import com.lvs.project.mscards.entity.CardBrand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;

    private CardBrand brand;

    private BigDecimal salaryIncome;

    private BigDecimal basicLimit;


    public Card toModel() {
        return new Card(name, brand, salaryIncome, basicLimit);
    }


}
