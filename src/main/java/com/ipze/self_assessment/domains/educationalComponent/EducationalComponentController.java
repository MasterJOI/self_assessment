package com.ipze.self_assessment.domains.educationalComponent;

import com.ipze.self_assessment.domains.educationProgramDocument.dto.DocumentToDownload;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentRequestBodyDto;
import com.ipze.self_assessment.model.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/components")
public class EducationalComponentController {

	private final EducationalComponentService educationalComponentService;

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updateComponentInformation(@PathVariable UUID id, @ModelAttribute ProgramEducationalComponentRequestBodyDto requestBody) throws IOException {
		final ApiResponse response = educationalComponentService.updateComponentInformation(id, requestBody);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/new/{selfAssessmentId}")
	public ResponseEntity<ApiResponse> createComponentInformation(@PathVariable UUID selfAssessmentId, @ModelAttribute ProgramEducationalComponentRequestBodyDto requestBody) throws IOException {
		final ApiResponse response = educationalComponentService.createComponentInformation(selfAssessmentId, requestBody);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteComponentInformation(@PathVariable UUID id) {
		final ApiResponse response = educationalComponentService.deleteComponentInformation(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> download(@RequestParam UUID id) {
		final DocumentToDownload documentToDownload = educationalComponentService.download(id);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + documentToDownload.getDocumentName()).contentLength(documentToDownload.getLength()).body(documentToDownload.getResource());
	}
}
