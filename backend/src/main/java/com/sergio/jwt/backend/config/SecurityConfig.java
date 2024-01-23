package com.sergio.jwt.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((auth) -> auth

                .requestMatchers("/*").permitAll()
                .requestMatchers(antMatcher("/assets/**")).permitAll()
                .requestMatchers("/admin/**").permitAll()

//                .requestMatchers(HttpMethod.POST, "/login", "/", "/index", "/admin",
//                        "/register",
//                        "api/v1/images",
//                        "/category").permitAll()
//                .requestMatchers(HttpMethod.GET, "/login", "/", "/index", "/admin/",
//                        "/register",
//                        "/current-user",
//                        "api/v1/images",
//                        "/category/{id}",
//                        "/category").permitAll()
//                .requestMatchers(HttpMethod.DELETE, "/category/{id}").permitAll()
//                .requestMatchers(HttpMethod.PUT, "/category/{id}").permitAll()
//                //=============== admin định nghĩa ===================================
//                .requestMatchers(HttpMethod.POST, "/admin/*").permitAll()
//                .requestMatchers(HttpMethod.GET, "/admin/*").permitAll()
//                .requestMatchers(HttpMethod.DELETE, "/admin/*").permitAll()
//                .requestMatchers(HttpMethod.PUT, "/admin/*").permitAll()

//                .anyRequest().authenticated()).formLogin(login -> login.loginPage("/logon").loginProcessingUrl("/logon")
//                .usernameParameter("username").passwordParameter("password")
//                .defaultSuccessUrl("/admin", true))
//                .logout(logout -> logout.logoutUrl("/admin-logout").logoutSuccessUrl("/logon")
                );




        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return(web) ->web.ignoring().requestMatchers("/static/**", "/assets/**");
    }



}
