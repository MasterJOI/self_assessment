package com.ipze.self_assessment.mapper.permission;

import com.ipze.self_assessment.model.dto.permission.PermissionDto;
import com.ipze.self_assessment.model.entity.AuthPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionMapper {

    PermissionMapper MAPPER = Mappers.getMapper(PermissionMapper.class);

    PermissionDto permissionToPermissionDto(AuthPermission permission);

}
