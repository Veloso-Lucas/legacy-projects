package com.lvs.project.mscards.dto;

import com.lvs.project.mscards.entity.CardBrand;
import com.lvs.project.mscards.entity.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsByCustomerResponse {

    private String name;
    private CardBrand brand;
    private BigDecimal limit;

    public static CardsByCustomerResponse fromModel(final CustomerCard customerCard) {

        return new CardsByCustomerResponse(customerCard.getCard().getName(),
                customerCard.getCard().getBrand(),
                customerCard.getCard().getBasicLimit()
        );

    }
}
