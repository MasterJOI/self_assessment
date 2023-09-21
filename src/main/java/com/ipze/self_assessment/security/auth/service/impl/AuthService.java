package com.ipze.self_assessment.security.auth.service.impl;

import com.ipze.self_assessment.exceptions.custom.UserAlreadyExistException;
import com.ipze.self_assessment.model.dto.auth.AuthRequest;
import com.ipze.self_assessment.model.dto.auth.RegistrationRequest;
import com.ipze.self_assessment.model.dto.user.AuthResponse;
import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.repo.UserRepository;
import com.ipze.self_assessment.security.auth.service.SecurityContextService;
import com.ipze.self_assessment.security.auth.service.TokenHandler;
import com.ipze.self_assessment.service.UserService;
import com.ipze.self_assessment.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final SecurityContextService securityContextService;
    private final TokenHandler tokenHandler;
    private final UserService userService;
    private final UserRepository userRepository;

    public ResponseEntity<ApiResponse> performLogin(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken loginToken = authRequest.toAuthenticationToken();
        Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = securityContextService.currentUser();
        String token = tokenHandler.createTokenForUser(user);

        user.setLastLogin(new Date());
        userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse(new AuthResponse(token), "You successfully signed in"));
    }

    public ResponseEntity<ApiResponse> performRegister(RegistrationRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new UserAlreadyExistException(
                    "User with email '" + registrationRequest.getEmail() + "' is already registered.");
        }
        if (userRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new UserAlreadyExistException(
                    "User with username '" + registrationRequest.getUsername() + "' is already registered.");
        }
        userService.registerNewUserAccount(registrationRequest);

        return performLogin(new AuthRequest(registrationRequest.getUsername(), registrationRequest.getPassword()));
    }
}
