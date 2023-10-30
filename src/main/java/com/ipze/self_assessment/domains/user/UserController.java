package com.ipze.self_assessment.domains.user;

import com.ipze.self_assessment.domains.permission.PermissionMapper;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherDto;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationDto;
import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.security.auth.service.SecurityContextService;
import com.ipze.self_assessment.model.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Validated
public class UserController {

    private UserService userService;
    private SecurityContextService securityContextService;

    @GetMapping("/find")
    public User getUserByEmail(@RequestParam("email") String email) {
        return null;
    }

	@GetMapping("/teacher")
	public TeacherInformationDto searchTeacherByFullName(@RequestParam String name) {
		return userService.searchTeacherByFullName(name);
	}

	@GetMapping("/teacher/all")
	public List<TeacherDto> getTeachers() {
		return userService.getTeachers();
	}

    @GetMapping("/me")
    public ResponseEntity<ApiResponse> getCurrentUser() {
        User user = securityContextService.currentUser();
        var permissions = user.getAuthPermissions().stream().map(PermissionMapper.MAPPER::permissionToPermissionDto)
                .toList();
        var userDto = UserMapper.MAPPER.userToUserDto(user);
        userDto.setPermissions(permissions);

        return ResponseEntity.ok(new ApiResponse(userDto, "Ви успішно отримали поточного користувача"));
    }

}
