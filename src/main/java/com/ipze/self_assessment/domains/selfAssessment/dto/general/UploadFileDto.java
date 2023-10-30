package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileDto {
	private MultipartFile file;
	private String name;
	private String  type;
}
