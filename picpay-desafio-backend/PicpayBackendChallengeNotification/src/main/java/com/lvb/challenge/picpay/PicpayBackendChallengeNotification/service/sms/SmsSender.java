package com.lvb.challenge.picpay.PicpayBackendChallengeNotification.service.sms;

import com.lvb.challenge.picpay.PicpayBackendChallengeNotification.dto.sms.SmsRequest;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
    // or maybe void sendSms(String phoneNumber, String message);
}
