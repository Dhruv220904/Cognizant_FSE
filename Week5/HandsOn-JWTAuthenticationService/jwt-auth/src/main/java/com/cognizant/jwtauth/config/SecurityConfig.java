package com.cognizant.jwtauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

 // In-memory users "admin" and "user", both with password "pwd", per the hands-on spec
 @Bean
 public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder){
  UserDetails user=User.withUsername("user").password(encoder.encode("pwd")).roles("USER").build();
  UserDetails admin=User.withUsername("admin").password(encoder.encode("pwd")).roles("ADMIN").build();
  return new InMemoryUserDetailsManager(user, admin);
 }

 @Bean
 public PasswordEncoder passwordEncoder(){
  return new BCryptPasswordEncoder();
 }

 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
  http.csrf(csrf -> csrf.disable())
      .httpBasic(withDefaults())
      .authorizeHttpRequests(auth -> auth
          .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
          .anyRequest().authenticated()
      );
  return http.build();
 }

 @Bean
 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
  return config.getAuthenticationManager();
 }
}
