package com.ipze.self_assessment.domains.studyResult.dto;

import com.ipze.self_assessment.domains.selfAssessment.SelfAssessmentInfoMapper;
import com.ipze.self_assessment.domains.teacherInformation.dto.Discipline;
import com.ipze.self_assessment.model.entity.StudyResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudyResultDto {
	private String id;
	private String name;
	private Boolean isCorresponds;
	private List<EducationComponentCorrespondenceDto> componentCorrespondences;

	public static StudyResultDto fromEntity(StudyResult studyResult) {
		var componentCorrespondences = studyResult.getEducationComponentCorrespondences()
			.stream()
			.map(correspondence -> {
				Discipline discipline = new Discipline(
					correspondence.getEducationalComponent().getId().toString(),
					correspondence.getEducationalComponent().getComponentName());
				EducationComponentCorrespondenceDto dto = SelfAssessmentInfoMapper.MAPPER.educationComponentCorrespondenceToDto(correspondence);
				dto.setDiscipline(discipline);
				return dto;
			}).toList();
		return builder()
			.id(studyResult.getId().toString())
			.name(studyResult.getName())
			.isCorresponds(studyResult.getIsCorresponds())
			.componentCorrespondences(componentCorrespondences)
			.build();
	}
}
