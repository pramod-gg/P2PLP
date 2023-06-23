package com.stackroute.p2plp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // UserDetails admin = User.withUsername("pramod")
        // .password(passwordEncoder.encode("root12"))
        // .roles("ADMIN")
        // .build();
        // UserDetails borrower = User.withUsername("john")
        // .password(passwordEncoder.encode("root34"))
        // .roles("BORROWER")
        // .build();
        // UserDetails lender = User.withUsername("tim")
        // .password(passwordEncoder.encode("root56"))
        // .roles("LENDER")
        // .build();
        // return new InMemoryUserDetailsManager(admin, borrower, lender);
        return new UserInfoUserDetailsService();
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/signup/**", "/signin/**").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/api/v1/**").authenticated().and().formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public AuthenticationManager
    // authenticationManager(AuthenticationConfiguration
    // authenticationConfiguration)
    // throws Exception {
    // return authenticationConfiguration.getAuthenticationManager();
    // }
}
