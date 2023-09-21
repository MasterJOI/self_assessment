package com.ipze.self_assessment.model.dto.auth;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class AuthRequest {
    @NotNull
    @NotEmpty(message = "Username cannot be empty.")
    @Pattern(regexp = "(?=\\S+$).+", message = "Username must contain no whitespace.")
    private String username;

    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
    @Size(min = 6, message = "Password length must be at least 6 symbols.")
    private String password;

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}

