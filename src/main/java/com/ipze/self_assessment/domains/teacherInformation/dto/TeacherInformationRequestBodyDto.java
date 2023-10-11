package com.ipze.self_assessment.domains.teacherInformation.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TeacherInformationRequestBodyDto {
	private String teacherId;
	private List<UUID> disciplinesIDs;
}
