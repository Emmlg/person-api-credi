package com.emmlg.persona_api.config;

import com.emmlg.persona_api.model.AuthEntity;
import com.emmlg.persona_api.repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {

        AuthEntity auth = authRepository.findByUsernameIgnoreCase((userName))
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetails(auth);
    }

}

