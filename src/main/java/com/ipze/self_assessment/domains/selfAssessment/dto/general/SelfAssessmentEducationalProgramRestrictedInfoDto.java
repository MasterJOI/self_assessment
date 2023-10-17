package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelfAssessmentEducationalProgramRestrictedInfoDto {
	private String infoDescription;
	private String infoAccessRestrictionType;
	private String restrictedInfoDescription;
	private String restrictingAccessGrounds;
}
