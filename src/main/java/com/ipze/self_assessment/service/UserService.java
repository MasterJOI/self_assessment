package com.ipze.self_assessment.service;

import com.ipze.self_assessment.exceptions.custom.EmailNotFoundException;
import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User with email : " + email + " not found."));
    }

}
