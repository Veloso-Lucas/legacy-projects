package com.lvb.challenge.picpay.PicpayBackendChallenge.entity;

import com.lvb.challenge.picpay.PicpayBackendChallenge.entity.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class User extends AccountBase {

    public User () {
        super();
        this.setUserType(UserType.USER);
    }

}
