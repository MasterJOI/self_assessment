package com.ipze.self_assessment.domains.educationProgramDocument.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.InputStreamResource;

@Getter
@Setter
@AllArgsConstructor
public class DocumentToDownload {
	private InputStreamResource resource;
	private Long length;
	private String documentName;
}
