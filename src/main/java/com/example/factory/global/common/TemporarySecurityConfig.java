package com.example.factory.global.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


// TODO: 인증 붙기 전 임시 설정, 제거 필요
@Configuration
@EnableWebSecurity
public class TemporarySecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. CSRF 보안 기능을 끕니다 (포스트맨으로 POST/PUT 요청을 날리기 위함)
                .csrf(AbstractHttpConfigurer::disable)

                // 2. HTTP 기본 인증과 폼 로그인을 비활성화합니다
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)

                // 3. ⭐ 핵심: 모든 API 경로(`/api/**`)를 인증 없이(permitAll) 허용합니다.
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
