package com.ipze.self_assessment.domains.educationalComponent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProgramEducationalComponentsInformationDto {
	private List<ProgramEducationalComponentDto> educationalComponents;
}

