package com.ipze.self_assessment.domains.studyResult.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StudyResultRequestBodyDto {
	private String name;
	private Boolean isCorresponds;
	private Set<CorrespondenceRequestBodyDto> componentCorrespondences;
}
