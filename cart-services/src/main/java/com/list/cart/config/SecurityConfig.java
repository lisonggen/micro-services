package com.list.cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-16 16:32
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String SECRET_KEY = "v9zKt!Q@C$kV!bY8fTz3Nd7LuPmX1aG4";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .decoder(jwtDecoder()) // 指定 JwtDecoder
                        )
                );
        return http.build();
    }

    // 替代 JwtAccessTokenConverter：定义 JwtDecoder
    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(key).build();
    }
}
