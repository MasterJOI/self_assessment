package com.ipze.self_assessment.domains.selfAssessment;

import com.ipze.self_assessment.domains.educationProgramDocument.dto.DocumentToDownload;
import com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase.AccreditationCaseDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoRequestBody;
import com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase.AccreditationCaseRequestBodyDto;
import com.ipze.self_assessment.model.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accreditation")
public class SelfAssessmentController {

	@Autowired
	private SelfAssessmentService selfAssessmentService;

	@GetMapping("/all")
	public List<AccreditationCaseDto> getAllAccreditationCases(@RequestParam(defaultValue = "0") Integer from,
															   @RequestParam(defaultValue = "10") Integer count) {
		return selfAssessmentService.getAllSelfAssessmentInfo(from, count);
	}

	@GetMapping("/{programId}")
	public SelfAssessmentInfoDto getSelfAssessmentInfo(@PathVariable Long programId) {
		return selfAssessmentService.getSelfAssessmentInfo(programId);
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
	public Long[] deleteSelfAssessmentInfo(@RequestParam Long[] IDs) {
		return selfAssessmentService.deleteSelfAssessmentInfo(IDs);
	}

	@GetMapping("/generate")
	public ResponseEntity<InputStreamResource> generate(@RequestParam Long programId) {
		final DocumentToDownload documentToDownload = selfAssessmentService.generate(programId);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + documentToDownload.getDocumentName()).contentLength(documentToDownload.getLength()).body(documentToDownload.getResource());
	}

}
