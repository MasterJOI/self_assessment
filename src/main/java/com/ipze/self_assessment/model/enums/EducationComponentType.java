package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationComponentType {
	DISCIPLINE("Навчальна дисципліна"),
	PRACTICE("Практика"),
	FINAL_CERTIFICATION("Підсумкова атестація"),
	COURSE_PROJECT("Курсова робота (практика)");

	private final String value;
}
