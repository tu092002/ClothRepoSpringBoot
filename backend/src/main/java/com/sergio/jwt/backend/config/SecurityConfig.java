package com.sergio.jwt.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .exceptionHandling(customizer -> customizer.authenticationEntryPoint(userAuthenticationEntryPoint))
                .addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(antMatcher("/assets/**")).permitAll()

                        .requestMatchers(HttpMethod.POST, "/login","/","/index","/admin",
                                "/register",
                                "api/v1/images",
                                "/category").permitAll()
                        .requestMatchers(HttpMethod.GET, "/login","/", "/index","/admin","/admin/category",
                                "/register",
                                "/current-user",
                                "api/v1/images",
                                "/category/{id}",
                                "/category").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/category/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/category/{id}").permitAll()
                        //=============== admin định nghĩa ===================================
                        .requestMatchers(HttpMethod.POST, "/admin/**/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/admin/**/").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/admin/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/admin/**").permitAll()

                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
        ;
        return http.build();
    }

}
