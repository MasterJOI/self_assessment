package com.ipze.self_assessment.security.auth;

import com.ipze.self_assessment.model.entity.User;

/**
 * Factory for creating {@link JwtUser} from {@link User} entity.
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    /**
     * Creates {@link JwtUser} entity from {@link User} entity.
     *
     * @param user {@link User} entity.
     * @return {@link JwtUser} entity.
     */
    public static JwtUser create(User user) {
        return new JwtUser(user);
    }
}
