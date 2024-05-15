package org.member.springSecurity.jjwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.member.MemberDTO;
import org.member.springSecurity.system.SpringSecurityUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class JJWTFilter extends OncePerRequestFilter {

    private final JJWTUtil jjwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("AuthToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token != null && jjwtUtil.validateToken(token)) {
            String username = jjwtUtil.getUsername(token);
            String country = jjwtUtil.getPassword(token);
            String area = jjwtUtil.getRole(token);

            MemberDTO memberDTO = new MemberDTO();
                memberDTO.setUsername(username);
                memberDTO.setCountry(country);
                memberDTO.setArea(area);

            SpringSecurityUser springSecurityUser = new SpringSecurityUser(memberDTO);
            Authentication authentication = new UsernamePasswordAuthenticationToken(springSecurityUser, null, springSecurityUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
