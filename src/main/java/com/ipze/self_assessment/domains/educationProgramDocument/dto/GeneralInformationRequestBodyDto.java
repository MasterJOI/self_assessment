package com.ipze.self_assessment.domains.educationProgramDocument.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class GeneralInformationRequestBodyDto {
	private Long heiId;
	private Long educationProgramId;
	private List<EducationProgramFormDto> educationProgramForms;
	private Boolean grantsProfessionalQualification;
	private String professionalQualification;
	private UUID subdivisionId;
	private List<UUID> otherSubdivisionsIds;
	private String partnerHei;
	private Long guaranteeId;
	private List<UUID> languagesIds;
	private String location;
	private String historyAndDevelopment;
	private List<EducationProgramDocumentRequestDto> educationProgramDocuments;
}
