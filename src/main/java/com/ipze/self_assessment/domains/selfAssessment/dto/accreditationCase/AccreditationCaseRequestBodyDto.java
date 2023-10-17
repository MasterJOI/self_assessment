package com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AccreditationCaseRequestBodyDto {
	private String cycle;
	private Long educationProgramId;
	private String name;
	private String programType;
	private String specialtyId;
}
