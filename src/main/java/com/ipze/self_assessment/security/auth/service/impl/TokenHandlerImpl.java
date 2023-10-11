package com.ipze.self_assessment.security.auth.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ipze.self_assessment.exceptions.custom.NoSuchEntityException;
import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.domains.user.repo.UserRepository;
import com.ipze.self_assessment.security.auth.JwtUserFactory;
import com.ipze.self_assessment.security.auth.service.TokenHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.Date;
import java.util.UUID;

/**
 * {@inheritDoc}.
 */
@Component("tokenHandler")
@PropertySource("classpath:security.properties")
@RequiredArgsConstructor
public class TokenHandlerImpl implements TokenHandler {

    @Value("${app.jwt.secret}")
    private String secret;
    private final UserRepository userRepository;

    /**
     * {@inheritDoc}.
     */
    @Override
    public UserDetails parseUserFromToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        try {
            final UUID id = UUID.fromString(verifier.verify(token).getClaim("id").asString());
            final User user = userRepository.findById(id)
                    .orElseThrow(() -> new NoSuchEntityException("Failed to retrieve user with id: " + id));
            return JwtUserFactory.create(user);
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String createTokenForUser(User user) {
        final LocalDateTime max = LocalDate.now().atTime(LocalTime.MAX);
        ZonedDateTime time = ZonedDateTime.of(max, ZoneId.systemDefault());

        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim("id", user.getId().toString())
                .withExpiresAt(Date.from(time.toInstant()))
                .sign(algorithm);
    }
}
