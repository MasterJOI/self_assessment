package com.ipze.self_assessment.domains.studyResult.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudyResultsMatrixDto {
	private List<StudyResultDto> studyResults;
}

