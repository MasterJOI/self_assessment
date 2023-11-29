package com.ipze.self_assessment.domains.teacherInformation.dto;

import com.ipze.self_assessment.model.entity.TeacherSummaryInformation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeacherInformationDto {
	private String id;
	private String teacherId;
	private String name;
	private String teacherPosition;
	private String subdivision;
	private String teacherQualification;
	private Integer teacherExperience;
	private List<Discipline> disciplines;
	private String rationale;

	public static TeacherInformationDto fromEntity(TeacherSummaryInformation information) {
		var teacher = information.getTeacher();
		List<Discipline> disciplines = information.getProgramEducationalComponentsInformations()
			.stream()
			.map(component -> new Discipline(component.getId().toString(), component.getComponentName()))
			.toList();
		return builder()
			.id(String.valueOf(information.getId()))
			.teacherId(teacher.getTeacherId())
			.name(teacher.getUser().getName())
			.teacherPosition(teacher.getTeacherPosition())
			.subdivision(teacher.getSubdivision().getResponsibleDepartment())
			.teacherQualification(information.getTeacherQualification())
			.teacherExperience(information.getTeacherExperience())
			.disciplines(disciplines)
			.rationale(information.getRationale())
			.build();
	}
}

