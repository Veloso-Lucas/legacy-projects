package com.studies.lvb.data_automation_project.service;

import com.studies.lvb.data_automation_project.dto.UserDTO;
import com.studies.lvb.data_automation_project.model.User;
import com.studies.lvb.data_automation_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO createUser(final UserDTO userDto) {

        //Encrypt password
        final String encryptedPassword = passwordEncoder.encode(userDto.getPassword());

        final User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .encryptedPassword(encryptedPassword)
                .build();

        // Save user
        userRepository.save(user);

        return userDto;
    }
}
