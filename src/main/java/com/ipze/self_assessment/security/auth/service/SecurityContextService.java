package com.ipze.self_assessment.security.auth.service;


import com.ipze.self_assessment.model.entity.User;

import java.util.Optional;

/**
 * The <code>SecurityContextService</code> provides means for obtaining
 * currently authenticated {@link User} entity.
 */
public interface SecurityContextService {

    /**
     * Returns {@link User} entity, who's {@link org.springframework.security.core.Authentication}
     * token is present in {@link org.springframework.security.core.context.SecurityContextHolder}.
     *
     * @return {@link User} entity.
     */
    User currentUser();

    Optional<User> potentialCurrentUser();
}
