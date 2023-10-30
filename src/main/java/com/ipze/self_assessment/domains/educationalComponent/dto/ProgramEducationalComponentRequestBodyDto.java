package com.ipze.self_assessment.domains.educationalComponent.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProgramEducationalComponentRequestBodyDto {
	private MultipartFile file;
	private String componentName;
	private String componentType;
	private String documentName;
	private String specialEquipmentInfo;
}
