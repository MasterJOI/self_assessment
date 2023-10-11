package com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudyResultsMatrixDto {
	private List<StudyResultDto> studyResults;
}

