package com.ipze.self_assessment.domains.teacherInformation.dto;

import com.ipze.self_assessment.security.config.validators.NullOrNotBlank;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Valid
public class TeacherInformationRequestBodyDto {
	private String teacherId;
	@NullOrNotBlank(message = "Teacher qualification cannot be empty.")
	private String teacherQualification;
	@NotNull
	private Integer teacherExperience;
	@NullOrNotBlank(message = "Rationale cannot be empty.")
	private String rationale;
	@NotEmpty
	private List<UUID> disciplinesIDs;
}
