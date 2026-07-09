package com.lvb.challenge.picpay.PicpayBackendChallengeNotification.service.sms;

import com.lvb.challenge.picpay.PicpayBackendChallengeNotification.dto.AccountBaseDTO;
import com.lvb.challenge.picpay.PicpayBackendChallengeNotification.dto.sms.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private final SmsSender smsSender;

    @Autowired
    public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendCode(final AccountBaseDTO accountBase, final Long code) {
        final String message = "Obrigado por se registrar. Por favor, use o código abaixo para confirmar seu telefone \n " + code;
        sendSms(new SmsRequest(accountBase.getPhoneNumber(), message));
    }


    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
