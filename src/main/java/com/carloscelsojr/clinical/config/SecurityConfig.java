package com.carloscelsojr.clinical.config;

import com.carloscelsojr.clinical.model.ClientModel;
import com.carloscelsojr.clinical.repository.ClientRepository;
import com.carloscelsojr.clinical.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ClientService clientService;
    private final Logger logger = Logger.getLogger("UserDetailsService");

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(req -> {
                    req.requestMatchers("webapp/resources/**").permitAll();
                    req.anyRequest().authenticated();
                })
                .formLogin(form -> form.loginPage("/login")
                        .defaultSuccessUrl("/view/HomePage.html").permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/view/Login.html?logout").permitAll())
                .build();
    }
}
