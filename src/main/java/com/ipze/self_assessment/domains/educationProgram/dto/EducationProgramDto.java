package com.ipze.self_assessment.domains.educationProgram.dto;

import lombok.Data;

@Data
public class EducationProgramDto {
    private Long educationProgramId;
    private String cycle;
    private String specialty;
    private Integer specialtyCode;
    private String name;
    private String programType;
    private String status;
}
