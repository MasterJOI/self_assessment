package com.ipze.self_assessment.security.auth.service.impl;

import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.domains.user.repo.UserRepository;
import com.ipze.self_assessment.security.auth.service.SecurityContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

/**
 * {@inheritDoc}.
 */
@Service("securityContextService")
@RequiredArgsConstructor
public class SecurityContextServiceImpl implements SecurityContextService {
    private final UserRepository userRepository;

    /**
     * {@inheritDoc}.
     */
    @Override
    public User currentUser() {
        return potentialCurrentUser()
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    @Override
    public Optional<User> potentialCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(authentication)
                .map(Principal::getName)
                .flatMap(userRepository::findByUsername);
    }
}
