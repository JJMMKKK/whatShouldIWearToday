package org.member.springSecurity.system;

import lombok.RequiredArgsConstructor;
import org.member.springSecurity.jjwt.JJWTFilter;
import org.member.springSecurity.jjwt.JJWTUtil;
import org.member.springSecurity.login.LoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JJWTUtil jjwtUtil;

    //기간 만료 설정
    @Value("${jwt.expiredMs}") String expiredMs;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //httpBasic 및 csrf 사용 중지
        http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable);

        //로그인 처리
        http
                .formLogin(formLogin -> formLogin.loginPage("/login"))
                .addFilterBefore(new JJWTFilter(jjwtUtil), LogoutFilter.class)
                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jjwtUtil, Long.parseLong(expiredMs)), UsernamePasswordAuthenticationFilter.class);

        /**
         * 소셜 로그인 위치
         *
         *
         *
         */

        // 권한에 따른 인가 설정
        http
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests.anyRequest().permitAll());


        // 세션 설정
        http
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 로그아웃
        http
                .logout(logout -> logout.logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("AuthToken")
                .logoutSuccessUrl("/LogoutPage")
                .permitAll());

        return http.build();
    }
}
