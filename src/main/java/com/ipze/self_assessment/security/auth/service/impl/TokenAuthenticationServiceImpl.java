package com.ipze.self_assessment.security.auth.service.impl;

import com.ipze.self_assessment.security.auth.JwtUser;
import com.ipze.self_assessment.security.auth.UserAuthentication;
import com.ipze.self_assessment.security.auth.service.TokenAuthenticationService;
import com.ipze.self_assessment.security.auth.service.TokenHandler;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private final TokenHandler tokenHandler;

    /**
     * {@inheritDoc}.
     */
    public Authentication getAuthentication(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        String jwt = authHeader.replaceAll("Bearer ", "");
        if (jwt.isEmpty()) {
            return null;
        }
        JwtUser userDetails = (JwtUser) this.tokenHandler.parseUserFromToken(jwt);
        if (userDetails == null) {
            return null;
        }
        return new UserAuthentication(userDetails);
    }
}

