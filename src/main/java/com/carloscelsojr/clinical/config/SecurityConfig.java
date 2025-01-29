package com.carloscelsojr.clinical.config;

import com.carloscelsojr.clinical.model.ClientModel;
import com.carloscelsojr.clinical.repository.ClientRepository;
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

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ClientRepository clientRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> clientList = new ArrayList<>();
        for (ClientModel client : clientRepository.findAll()) {
            clientList.add(User.builder()
                    .username(client.getEmail())
                    .password(client.getPassword())
                    .roles("USER")
                    .build());
        }
        //UserDetails user1 = User.builder().username("abc@gmail.com").password("{noop}agh").roles("USER").build();
        return new InMemoryUserDetailsManager(clientList);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(req -> {
                    req.requestMatchers("/resources/**").permitAll();
                    req.anyRequest().permitAll();//.authenticated();
                })
                .formLogin(form -> form.loginPage("/view/Login.html")
                        .defaultSuccessUrl("/view/HomePage.html").permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/view/Login.html?logout").permitAll())
                .build();
    }
}
