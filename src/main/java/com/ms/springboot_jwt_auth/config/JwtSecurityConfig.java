package com.ms.springboot_jwt_auth.config;

import com.ms.springboot_jwt_auth.jwtsecurity.JwtAuthenticationEntryPoint;
import com.ms.springboot_jwt_auth.jwtsecurity.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class JwtSecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf->csrf.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers("/home/**")
                        //.hasRole("ADMIN") we can specify any specific role
                        .authenticated()
                        .requestMatchers("/auth/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                ).exceptionHandling(ex-> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
