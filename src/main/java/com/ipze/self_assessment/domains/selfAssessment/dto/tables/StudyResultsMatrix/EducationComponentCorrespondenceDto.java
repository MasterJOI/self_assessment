package com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix;

import com.ipze.self_assessment.domains.teacherInformation.dto.Discipline;
import lombok.Data;

@Data
public class EducationComponentCorrespondenceDto {
	private Discipline discipline;
	private String teachingMethod;
	private String assessmentForm;
}
