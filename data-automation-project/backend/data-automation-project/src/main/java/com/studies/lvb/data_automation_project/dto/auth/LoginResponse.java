package com.studies.lvb.data_automation_project.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse implements Serializable {
    private String token;
    private String refreshToken;
}
