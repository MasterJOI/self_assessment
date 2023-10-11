package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GrantsProfessionalQualification  {
    UNKNOWN( "(Невідомо)"),
    NO("Ні"),
    YES("Так");

    private final String value;
}
