package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import com.ipze.self_assessment.domains.language.dto.LanguageDto;
import com.ipze.self_assessment.domains.subdivision.dto.SubdivisionDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EducationProgramAccreditationInformationDto {
	private String specialtyLicensingInfo;
	private String cycle;
	private String specialization;
	private String programType;
	private String admissionDegree;
	private List<String> duration;
	private List<String> educationProgramForms;
	private String location;
	private Boolean grantsProfessionalQualification;
	private String professionalQualification;
	private String partnerHei;
	private GuaranteeDto guarantee;
	private Long educationProgramId;
	private String educationProgramName;
	private Integer fieldOfStudyCode;
	private String fieldOfStudy;
	private Integer specialtyCode;
	private String specialty;
	private String subdivisionId;
	private String subdivisionName;
	private List<LanguageDto> languages;
	private List<SubdivisionDto> otherSubdivisions;
	private String historyAndDevelopment;
}
