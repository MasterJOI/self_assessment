package com.ipze.self_assessment.model.dto.user;

import com.ipze.self_assessment.model.dto.permission.PermissionDto;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;

    private String username;

    private String name;

    private String email;

    private List<PermissionDto> permissions;
}
