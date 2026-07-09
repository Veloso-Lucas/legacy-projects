package com.studies.lvb.data_automation_project.controller;

import com.studies.lvb.data_automation_project.dto.auth.LoginRequest;
import com.studies.lvb.data_automation_project.dto.auth.LoginResponse;
import com.studies.lvb.data_automation_project.model.User;
import com.studies.lvb.data_automation_project.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        final var response = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    //TODO add filter to this endpoint specific to validate if the refresh token stil valid
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody LoginResponse request) {
        User user = refreshTokenService.validateAndGetUser(request.getRefreshToken());
        String newAccessToken = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new LoginResponse(request.getRefreshToken(), newAccessToken));
    }
}
