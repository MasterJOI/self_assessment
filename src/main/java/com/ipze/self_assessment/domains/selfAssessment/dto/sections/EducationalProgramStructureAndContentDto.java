package com.ipze.self_assessment.domains.selfAssessment.dto.sections;

import lombok.Data;

@Data
public class EducationalProgramStructureAndContentDto {
	private Integer epCreditsAmount;
	private Integer componentsCreditsAmount;
	private Integer studentElectivesCreditsAmount;
	private String contentCompliance;
	private String individualLearningPath;
	private String studentChoiceRight;
	private String studentPracticalTraining;
	private String studentSoftSkills;
	private String relevantProfessionalStandard;
	private String componentsScopeCorrelatingApproach;
	private String dualFormEducationStructure;
}
