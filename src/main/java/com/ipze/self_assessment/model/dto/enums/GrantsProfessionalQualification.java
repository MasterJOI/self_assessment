package com.ipze.self_assessment.model.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GrantsProfessionalQualification  {
    UNKNOWN(0, "(Невідомо)"),
    NO(1, "Ні"),
    YES(2, "Так");

    private final int value;
    private final String label;
}
