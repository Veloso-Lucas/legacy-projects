package com.studies.lvb.data_automation_project.service;

import com.studies.lvb.data_automation_project.auth.JwtUtil;
import com.studies.lvb.data_automation_project.dto.auth.LoginResponse;
import com.studies.lvb.data_automation_project.model.User;
import com.studies.lvb.data_automation_project.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(final String email, final String password) {
        final User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(password, user.getEncryptedPassword())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        final String token = jwtUtil.generateToken(user);
        final String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

        return new LoginResponse(token, refreshToken);
    }
}
