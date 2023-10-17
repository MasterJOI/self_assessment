package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import com.ipze.self_assessment.model.entity.EducationProgramAccreditationInformation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GuaranteeDto {
		private String id;
		private String teacherId;
		private String name;
		private String teacherPosition;
		private String guaranteeEmail;
		private String guaranteePhone;
		private String additionalPhone;

	public static GuaranteeDto fromEntity(EducationProgramAccreditationInformation information) {
		var teacher = information.getGuarantee();

		return builder()
			.id(String.valueOf(teacher.getId()))
			.teacherId(teacher.getTeacherId())
			.name(teacher.getUser().getName())
			.teacherPosition(teacher.getTeacherPosition())
			.guaranteeEmail(information.getGuaranteeEmail())
			.guaranteePhone(information.getGuaranteePhone())
			.additionalPhone(information.getAdditionalPhone())
			.build();
	}
}
