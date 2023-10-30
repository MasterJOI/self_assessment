package com.ipze.self_assessment.domains.teacherInformation.dto;

import com.ipze.self_assessment.model.entity.Teacher;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDto {

	String id;
	String name;

	public static TeacherDto fromEntity(Teacher teacher) {
		return TeacherDto.builder()
			.id(teacher.getId().toString())
			.name(teacher.getUser().getName())
			.build();
	}

}
