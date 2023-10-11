package com.ipze.self_assessment.domains.teacherInformation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TeacherSummaryInformationDto {
	private List<TeacherInformationDto> teachers;
}

