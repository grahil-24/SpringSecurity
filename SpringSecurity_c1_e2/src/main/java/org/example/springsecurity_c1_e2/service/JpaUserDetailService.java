package org.example.springsecurity_c1_e2.service;

import lombok.AllArgsConstructor;
import org.example.springsecurity_c1_e2.repository.UserRepository;
import org.example.springsecurity_c1_e2.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = userRepository.findUserByUsername(username);
        return u.map(SecurityUser::new).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }
}
