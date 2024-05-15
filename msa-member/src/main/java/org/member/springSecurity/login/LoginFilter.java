package org.member.springSecurity.login;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.member.springSecurity.jjwt.JJWTUtil;
import org.member.springSecurity.system.SpringSecurityUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@Slf4j
@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JJWTUtil jjwtUtil;
    private final Long expiredMs;

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain, Authentication authResult) throws IOException, ServletException {

        SpringSecurityUser springSecurityUser = (SpringSecurityUser) authResult.getPrincipal();
        String username = springSecurityUser.getUsername();

        Collection<? extends GrantedAuthority> authorities = springSecurityUser.getAuthorities();
        Iterator<? extends GrantedAuthority> authoritiesIterator = authorities.iterator();
        GrantedAuthority grantedAuthority = authoritiesIterator.next();
        String role = grantedAuthority.getAuthority();

        String token = jjwtUtil.createJwt(username, role, expiredMs);

        String cookieValue = "AuthToken=" + token + "; Path=/; HttpOnly";
        if (request.isSecure()) {
            cookieValue += "; Secure";
        }
        response.addHeader("Set-Cookie", cookieValue);
        response.sendRedirect("/MemberPage");

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException failed) throws IOException {
        String message = failed.getMessage();
        log.error("Unsuccessful authentication: {}", message);
        response.sendRedirect("/LoginPage");
    }

}
