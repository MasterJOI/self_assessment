package com.ipze.self_assessment.security.auth;

import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Represents service for entity-specific data loading.
 */
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
        AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
        JwtUser jwtUser = JwtUserFactory.create(user);
        detailsChecker.check(jwtUser);

        return jwtUser;
    }
}
