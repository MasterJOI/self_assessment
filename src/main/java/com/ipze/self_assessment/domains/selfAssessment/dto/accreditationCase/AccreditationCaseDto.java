package com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase;

import lombok.Data;

@Data
public class AccreditationCaseDto {
    private Long educationProgramId;
    private String cycle;
    private String specialty;
    private Integer specialtyCode;
    private String name;
    private String programType;
    private String status;
}
