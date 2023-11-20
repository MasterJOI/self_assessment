package com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase;

import lombok.Data;

@Data
public class AccreditationCaseRequestBodyDto {
	private String heiId;
	private Long educationProgramId;
	private String cycle;
	private String name;
	private String programType;
	private String specialtyId;
	private String guaranteeId;
}
