package com.lvb.challenge.picpay.PicpayBackendChallengeNotification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountBaseDTO {

    //For Seller documentNumber is CNPJ
    private String userDocument;

    private String firstname;

    private String lastName;

    private String email;

    private Boolean emailValidated = false;

    private String phoneNumber;

    private Boolean phoneNumberValidated = false;

    private String userIdKeycloak;
}
