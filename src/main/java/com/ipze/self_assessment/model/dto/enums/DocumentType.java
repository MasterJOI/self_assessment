package com.ipze.self_assessment.model.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DocumentType {
	CURRICULUM("curriculum", "Навчальний план за ОП"),
	EDUCATION_PROGRAM("education_program", "Освітня програма"),
	REVIEW("review", "Рецензії та відгуки роботодавців"),
	SYLLABUS("syllabus", "Силабус");

	private final String value;
	private final String label;
}
