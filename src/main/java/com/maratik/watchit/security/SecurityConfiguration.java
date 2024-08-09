package com.maratik.watchit.security;

import com.maratik.watchit.constants.Urls;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final SuccessAuthHandler successAuthHandler;

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService,
                                 SuccessAuthHandler successAuthHandler) {
        this.userDetailsService = userDetailsService;
        this.successAuthHandler = successAuthHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests((requests) -> requests
                        .requestMatchers(Urls.INDEX).permitAll()
                        .requestMatchers(Urls.MOVIES + "/**").authenticated()
                        .requestMatchers(Urls.SEARCH + "/**").authenticated()
                )
                .formLogin((form) -> form
                        .successHandler(successAuthHandler)
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
