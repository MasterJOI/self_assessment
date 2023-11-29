package com.ipze.self_assessment.domains.teacherInformation;

import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationRequestBodyDto;
import com.ipze.self_assessment.model.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teacher-information")
public class TeacherInformationController {

	private final TeacherInformationService teacherInformationService;

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updateTeacherInformation(@PathVariable UUID id, @Valid @RequestBody TeacherInformationRequestBodyDto requestBody) {
		final ApiResponse response = teacherInformationService.updateTeacherInformation(id, requestBody);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/new/{selfAssessmentId}")
	public ResponseEntity<ApiResponse> createTeacherInformation(@PathVariable UUID selfAssessmentId, @Valid @RequestBody TeacherInformationRequestBodyDto requestBody) {
		final ApiResponse response = teacherInformationService.createTeacherInformation(selfAssessmentId, requestBody);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteTeacherInformation(@PathVariable UUID id) {
		final ApiResponse response = teacherInformationService.deleteTeacherInformation(id);
		return ResponseEntity.ok(response);
	}
}
