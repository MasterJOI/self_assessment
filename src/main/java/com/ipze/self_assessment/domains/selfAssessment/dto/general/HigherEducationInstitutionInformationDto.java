package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HigherEducationInstitutionInformationDto {
	private Long heiId;
	private String higherEducationalInstitutionName;
	private Long institutionCode;
	private String website;
	private String headFullName;
}
