package com.ipze.self_assessment.domains.studyResult;

import com.ipze.self_assessment.domains.studyResult.dto.StudyResultRequestBodyDto;
import com.ipze.self_assessment.model.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/study-result")
public class StudyResultController {

	private final StudyResultService studyResultService;

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updateStudyResult(@PathVariable UUID id, @RequestBody StudyResultRequestBodyDto requestBody) {
		final ApiResponse response = studyResultService.updateStudyResult(id, requestBody);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/new/{selfAssessmentId}")
	public ResponseEntity<ApiResponse> createStudyResult(@PathVariable UUID selfAssessmentId, @RequestBody StudyResultRequestBodyDto requestBody) {
		final ApiResponse response = studyResultService.createStudyResult(selfAssessmentId, requestBody);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteStudyResult(@PathVariable UUID id) {
		final ApiResponse response = studyResultService.deleteStudyResult(id);
		return ResponseEntity.ok(response);
	}
}
