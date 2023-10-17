package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StudentType {
    BACHELOR("Бакалавр"),
    MASTER("Магістр"),
    DOCTORATE("Доктор філософії");

	final String value;
}
