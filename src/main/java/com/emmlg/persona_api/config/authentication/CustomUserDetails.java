package com.emmlg.persona_api.config.authentication;


import com.emmlg.persona_api.model.AuthEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

public class CustomUserDetails implements UserDetails {

    private final AuthEntity auth;

    public CustomUserDetails(AuthEntity auth) {
        this.auth = auth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
            new SimpleGrantedAuthority("ROLE_" + auth.getRole().getDescription().toUpperCase())
        );
    }

    @Override
    public String getPassword() {
        return auth.getPasswordHashed();
    }

    @Override
    public String getUsername() {
        return auth.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return auth.getPerson().isActive();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }
}
