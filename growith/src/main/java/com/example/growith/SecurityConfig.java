package com.example.growith;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails manager = User.withUsername("test@email")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(manager);
    }

//    @Bean
//    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }

//    @Bean
//    public AuthenticationManager authenticationManager() {
//        DaoAuthenticationProvider inMemoryProvider = new DaoAuthenticationProvider();
//        inMemoryProvider.setUserDetailsService(inMemoryUserDetailsManager());
//        inMemoryProvider.setPasswordEncoder(passwordEncoder());
//
//        DaoAuthenticationProvider customProvider = new DaoAuthenticationProvider();
//        customProvider.setUserDetailsService(customUserDetailService);
//        customProvider.setPasswordEncoder(passwordEncoder());
//
//        return new ProviderManager(Arrays.asList(inMemoryProvider, customProvider));
//    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(inMemoryUserDetailsManager()).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> {
                            log.debug("Configuring CSRF protection");
                            csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                        }
                )
                .authorizeHttpRequests(authorizeRequests -> {
                            log.debug("Configuring authorizeRequests");
                            authorizeRequests
                                    .requestMatchers("/admin/login").permitAll()
                                    .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                                    .anyRequest().permitAll();
                        }
                )
                .formLogin(formLogin -> {
                            log.debug("Configuring form Login");
                            formLogin.loginPage("/admin/login")
                                    .defaultSuccessUrl("/admin/notice", true)
                                    .usernameParameter("email") //로그인 폼의 username 파라미터를 email로 변경
                                    .failureHandler(customAuthenticationFailureHandler) // 로그인 실패 로그 핸들러
                                    .permitAll();
                        }
                )
                .logout(logout -> {
                            log.debug("Configuring Logout");
                            logout.logoutUrl("/admin/logout")
                                    .logoutSuccessUrl("/")
                                    .permitAll();
                        }
                )
                .exceptionHandling(exceptionHandling -> {
                    log.debug("Configuring exceptionHandling");
                    exceptionHandling.accessDeniedHandler(customAccessDeniedHandler);
                });
        return http.build();
    }
}