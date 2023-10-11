package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DocumentType {
	CURRICULUM("Навчальний план за ОП"),
	EDUCATION_PROGRAM("Освітня програма"),
	REVIEW("Рецензії та відгуки роботодавців"),
	SYLLABUS("Силабус");

	private final String value;
}
