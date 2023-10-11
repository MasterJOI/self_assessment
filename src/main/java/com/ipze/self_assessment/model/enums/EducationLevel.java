package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationLevel {
	ENTRY("Початковий рівень (короткий цикл) вищої освіти"),
	FIRST("Перший (бакалаврський) рівень"),
	SECOND("Другий (магістерський) рівень"),
	THIRD( "Третій (освітньонауковий/освітньотворчий) рівень");

	private final String value;
}
