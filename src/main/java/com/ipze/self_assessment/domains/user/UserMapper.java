package com.ipze.self_assessment.domains.user;

import com.ipze.self_assessment.domains.user.dto.UserDto;
import com.ipze.self_assessment.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
}
