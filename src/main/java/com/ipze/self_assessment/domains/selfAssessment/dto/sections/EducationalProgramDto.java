package com.ipze.self_assessment.domains.selfAssessment.dto.sections;

import lombok.Data;

@Data
public class EducationalProgramDto {
	private String description;
	private String researchPreparation;
	private String teachingPreparation;
	private String supervisorRelevance;
	private String researchSupport;
	private String internationalParticipation;
	private String researchProjectsSupervisorsParticipation;
	private String academicIntegrityPractices;
	private String academicIntegrityPreventingViolations;
}
