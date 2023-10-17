package com.ipze.self_assessment.domains.educationProgramDocument.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.core.io.InputStreamResource;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DocumentToDownload {
	private InputStreamResource resource;
	private Long length;
	private String documentName;
}
