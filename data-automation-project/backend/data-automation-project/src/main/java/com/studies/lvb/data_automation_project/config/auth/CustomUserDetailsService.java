package com.studies.lvb.data_automation_project.config.auth;

import com.studies.lvb.data_automation_project.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Long userId = Long.parseLong(username);

        //TODO use query in a UserService Class
        com.studies.lvb.data_automation_project.model.User userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(
                userEntity.getId().toString(),
                userEntity.getEncryptedPassword(),
                getAuthorities(userEntity)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(com.studies.lvb.data_automation_project.model.User userEntity) {
        return Collections.emptyList();
    }
}
