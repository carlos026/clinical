package com.carloscelsojr.clinical.service;

import com.carloscelsojr.clinical.model.ClientModel;
import com.carloscelsojr.clinical.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findAllByEmail(username)
                .stream()
                .findFirst()
                .map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    private UserDetails toUserDetails(ClientModel client) {
        // Password with no PasswordEncoder should be prefixed with `{noop}`.
        return User.withUsername(client.getEmail())
                .password("{noop}" + client.getPassword())
                .authorities("ADMIN")
                .build();
    }
}
