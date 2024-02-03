package org.example.springsecurity_c1_e2.security;

import lombok.AllArgsConstructor;
import org.example.springsecurity_c1_e2.entity.Authority;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
