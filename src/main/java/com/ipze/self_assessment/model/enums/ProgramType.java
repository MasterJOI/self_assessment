package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProgramType {
    ON("Освітньо-наукова"),
    OP("Освітньо-професійна");

	final String value;
}
