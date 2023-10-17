package com.ipze.self_assessment.domains.studyResult.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class CorrespondenceRequestBodyDto {
	private Optional<String> id = Optional.empty();
	private String disciplineId;
	private String teachingMethod;
	private String assessmentForm;
}
