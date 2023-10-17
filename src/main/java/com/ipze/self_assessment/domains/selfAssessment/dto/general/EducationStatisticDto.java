package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import lombok.Data;

@Data
public class EducationStatisticDto {
	private Integer studyCourseYear;
	private String academicYear;
	private Integer enrollment;
	private Integer fullTime;
	private Integer evening;
	private Integer partTime;
	private Integer foreignFullTime;
	private Integer foreignEvening;
	private Integer foreignPartTime;
}
