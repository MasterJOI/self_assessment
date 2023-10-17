package com.ipze.self_assessment.domains.studyResult.dto;

import com.ipze.self_assessment.domains.teacherInformation.dto.Discipline;
import lombok.Data;

@Data
public class EducationComponentCorrespondenceDto {
	private String id;
	private Discipline discipline;
	private String teachingMethod;
	private String assessmentForm;
}
