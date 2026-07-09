package com.studies.lvb.data_automation_project.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Serializable {

    private String email;

    private String password;
}
