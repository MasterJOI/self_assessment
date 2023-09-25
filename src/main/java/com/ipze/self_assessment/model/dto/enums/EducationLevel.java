package com.ipze.self_assessment.model.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationLevel {
	ENTRY("entry", "Початковий рівень (короткий цикл) вищої освіти"),
	FIRST("first", "Перший (бакалаврський) рівень"),
	SECOND("second", "Другий (магістерський) рівень"),
	THIRD("third", "Третій (освітньонауковий/освітньотворчий) рівень");

	private final String value;
	private final String label;
}
