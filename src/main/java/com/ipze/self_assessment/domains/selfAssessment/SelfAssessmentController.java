package com.ipze.self_assessment.domains.selfAssessment;

import com.ipze.self_assessment.domains.educationProgramDocument.dto.DocumentToDownload;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoRequestBody;
import com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase.AccreditationCaseDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase.AccreditationCaseRequestBodyDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.general.UploadFileDto;
import com.ipze.self_assessment.model.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accreditation")
public class SelfAssessmentController {

	@Autowired
	private SelfAssessmentService selfAssessmentService;

	@GetMapping("/all")
	public ResponseEntity<ApiResponse> getAllAccreditationCases(@RequestParam(defaultValue = "0") Integer from,
																@RequestParam(defaultValue = "10") Integer count) {
		final ApiResponse response = selfAssessmentService.getAllSelfAssessmentInfo(from, count);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public SelfAssessmentInfoDto getSelfAssessmentInfo(@PathVariable UUID id) {
		return selfAssessmentService.getSelfAssessmentInfo(id);
	}

	@PostMapping("/new")
	public AccreditationCaseDto createAccreditationCase(@RequestBody AccreditationCaseRequestBodyDto body) {
		return selfAssessmentService.createAccreditationCase(body);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> editSelfAssessmentInfo(@PathVariable UUID id, @RequestBody SelfAssessmentInfoRequestBody requestBody) {
		return selfAssessmentService.editSelfAssessmentInfo(id, requestBody);
	}

	@DeleteMapping("")
	public List<UUID> deleteSelfAssessmentInfo(@RequestParam List<UUID> IDs) {
		return selfAssessmentService.deleteSelfAssessmentInfo(IDs);
	}

	@GetMapping("/generate")
	public ResponseEntity<InputStreamResource> generate(@RequestParam UUID id) {
		final DocumentToDownload documentToDownload = selfAssessmentService.generate(id);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + documentToDownload.getDocumentName()).contentLength(documentToDownload.getLength()).body(documentToDownload.getResource());
	}

	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> download(@RequestParam UUID id) {
		final DocumentToDownload documentToDownload = selfAssessmentService.download(id);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + documentToDownload.getDocumentName()).contentLength(documentToDownload.getLength()).body(documentToDownload.getResource());
	}

	@PostMapping("/upload/{selfAssessmentId}")
	public ResponseEntity<ApiResponse> uploadGeneralDocument(@PathVariable UUID selfAssessmentId, @ModelAttribute UploadFileDto requestBody) throws IOException {
		final ApiResponse response = selfAssessmentService.uploadGeneralDocument(selfAssessmentId, requestBody);
		return ResponseEntity.ok(response);
	}

}
