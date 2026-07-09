package com.lvb.challenge.picpay.PicpayBackendChallenge.dto.user;

import com.lvb.challenge.picpay.PicpayBackendChallenge.dto.account.AccountDto;
import com.lvb.challenge.picpay.PicpayBackendChallenge.entity.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends AccountDto implements Serializable {

    public UserDto() {
        super();
        this.setUserType(UserType.USER);
    }
}

