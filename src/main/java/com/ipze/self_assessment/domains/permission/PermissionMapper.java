package com.ipze.self_assessment.domains.permission;

import com.ipze.self_assessment.domains.permission.dto.PermissionDto;
import com.ipze.self_assessment.model.entity.AuthPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionMapper {

    PermissionMapper MAPPER = Mappers.getMapper(PermissionMapper.class);

    PermissionDto permissionToPermissionDto(AuthPermission permission);

}
