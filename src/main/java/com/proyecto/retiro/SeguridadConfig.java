package com.proyecto.retiro.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

@EnableWebSecurity

public class SeguridadConfig {

  
@Bean

public UserDetailsService usuarios() {
  
UserDetails admin = User.builder()
    .username("admin")
    .password(cifrador().encode("retirosbethlemitas2026"))
    .roles("ADMIN")
    .build();


  
UserDetails docente = User.builder()
    .username("docente")
    .password(cifrador().encode("docente123"))
    .roles("USER")
    .build();


  return new InMemoryUserDetailsManager(admin, docente);
}

@Bean

public PasswordEncoder cifrador() {
  return new BCryptPasswordEncoder();
}
}