package com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix;

import lombok.Data;

import java.util.List;

@Data
public class StudyResultDto {
	private String id;
	private String name;
	private Boolean isCorresponds;
	private List<EducationComponentCorrespondenceDto> componentCorrespondences;
}
