package org.hse.med.recommendation_service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    PasswordEncoder bCryptPasswordEncoder() {
         return new BCryptPasswordEncoder();
    }

    @Bean
    JpaUserDetailsService jpaUserDetailsService() {
         return new JpaUserDetailsService();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.formLogin(Customizer.withDefaults());
        //TODO: resolve csrf problem
        http.csrf(AbstractHttpConfigurer::disable);

         return http
                 .authorizeHttpRequests((authorize) ->
                         authorize.anyRequest().authenticated())
                 .build();
    }


}
