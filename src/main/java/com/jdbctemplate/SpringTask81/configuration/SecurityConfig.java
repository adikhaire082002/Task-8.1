package com.jdbctemplate.SpringTask81.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()  // Allow Swagger UI and API docs without authentication
                        .anyRequest().authenticated()  // Secure all other endpoints
                )
                .httpBasic(Customizer.withDefaults())  // Correctly using the Customizer with Defaults for httpBasic
                .csrf(csrf -> csrf.disable());  // Disable CSRF for APIs

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("aditya")
                        .password("{noop}aditya123")  // Password without encryption (for testing purposes)
                        .roles("USER")
                        .build()
        );
    }
}