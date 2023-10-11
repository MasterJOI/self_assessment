package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationProgramStatus {
	ACCREDITED("Акредитована"),
	PROGRESS("В роботі"),
	CLOSED("Закрита");

	private final String value;
}
