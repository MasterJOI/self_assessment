package com.ipze.self_assessment.model.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StudentType {
    BACHELOR(1, "Бакалавр"),
    MASTER(2, "Магістр"),
    DOCTORATE(3, "Аспірант");

    private final int value;
    private final String label;
}
