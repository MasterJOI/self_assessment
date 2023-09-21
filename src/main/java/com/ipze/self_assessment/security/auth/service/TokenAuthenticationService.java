package com.ipze.self_assessment.security.auth.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

/**
 * The <code>TokenAuthenticationService</code> obtains {@link Authentication} token
 * from an authentication request {@link HttpServletRequest}.
 */
public interface TokenAuthenticationService {

    /**
     * Returns the {@link Authentication} token according to the request
     * {@link HttpServletRequest} authorisation header.
     *
     * @param request client's request to the server.
     * @return {@link Authentication} token or {@literal null} if authorization header validation failed.
     */
    Authentication getAuthentication(HttpServletRequest request);
}
