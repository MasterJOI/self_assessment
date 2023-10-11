package com.ipze.self_assessment.domains.selfAssessment;

import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.sections.*;
import com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix.EducationComponentCorrespondenceDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix.StudyResultDto;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationDto;
import com.ipze.self_assessment.model.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface SelfAssessmentInfoMapper {
	SelfAssessmentInfoMapper MAPPER = Mappers.getMapper(SelfAssessmentInfoMapper.class);

	//1
	EducationProgramDesignDto educationProgramDesignToDto(EducationProgramDesign programDesign);

	void updateFromMap(@MappingTarget EducationProgramDesignDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget EducationProgramDesign entity, EducationProgramDesignDto dto);

	//2
	EducationalProgramStructureAndContentDto educationalProgramStructureAndContentToDto(EducationalProgramStructureAndContent structureAndContent);

	void updateFromMap(@MappingTarget EducationalProgramStructureAndContentDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget EducationalProgramStructureAndContent entity, EducationalProgramStructureAndContentDto dto);

	//3
	EducationalProgramAccessDto educationalProgramAccessToDto(EducationalProgramAccess programAccess);

	void updateFromMap(@MappingTarget EducationalProgramAccessDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget EducationalProgramAccess entity, EducationalProgramAccessDto dto);

	//4
	EducationalProgramLearningAndTeachingDto educationalProgramLearningAndTeachingToDto(EducationalProgramLearningAndTeaching programLearningAndTeaching);

	void updateFromMap(@MappingTarget EducationalProgramLearningAndTeachingDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget EducationalProgramLearningAndTeaching entity, EducationalProgramLearningAndTeachingDto dto);

	//5
	ControlMeasuresAndAcademicIntegrityDto controlMeasuresAndAcademicIntegrityToDto(ControlMeasuresAndAcademicIntegrity measuresAndAcademicIntegrity);

	void updateFromMap(@MappingTarget ControlMeasuresAndAcademicIntegrityDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget ControlMeasuresAndAcademicIntegrity entity, ControlMeasuresAndAcademicIntegrityDto dto);

	//6
	HumanResourceDto humanResourceToDto(HumanResource humanResource);

	void updateFromMap(@MappingTarget HumanResourceDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget HumanResource entity, HumanResourceDto dto);

	//7
	EducationalEnvironmentAndMaterialResourceDto educationalEnvironmentAndMaterialResourceToDto(EducationalEnvironmentAndMaterialResource educationalEnvironmentAndMaterialResource);

	void updateFromMap(@MappingTarget EducationalEnvironmentAndMaterialResourceDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget EducationalEnvironmentAndMaterialResource entity, EducationalEnvironmentAndMaterialResourceDto dto);

	//8
	QualityAssuranceDto qualityAssuranceToDto(QualityAssurance qualityAssurance);

	void updateFromMap(@MappingTarget QualityAssuranceDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget QualityAssurance entity, QualityAssuranceDto dto);

	//9
	EducationalTransparencyAndPublicityDto educationalTransparencyAndPublicityToDto(EducationalTransparencyAndPublicity educationalTransparencyAndPublicity);

	void updateFromMap(@MappingTarget EducationalTransparencyAndPublicityDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget EducationalTransparencyAndPublicity entity, EducationalTransparencyAndPublicityDto dto);

	//10
	EducationalProgramDto educationalProgramToDto(EducationalProgram educationalProgram);

	void updateFromMap(@MappingTarget EducationalProgramDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget EducationalProgram entity, EducationalProgramDto dto);

	//11
	OpDevelopmentPerspectiveDto opDevelopmentPerspectiveToDto(OpDevelopmentPerspective opDevelopmentPerspective);

	void updateFromMap(@MappingTarget OpDevelopmentPerspectiveDto dto, Map<String, Object> map);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(@MappingTarget OpDevelopmentPerspective entity, OpDevelopmentPerspectiveDto dto);

	@Mapping(target = "componentType", ignore = true)
	ProgramEducationalComponentDto programEducationalComponentsInformationToDto(ProgramEducationalComponentsInformation programEducationalComponentsInformation);

	@Mapping(target = "subdivision", ignore = true)
	@Mapping(target = "disciplines", ignore = true)
	TeacherInformationDto teacherToDto(Teacher teacher);

	StudyResultDto studyResultToDto(StudyResult studyResult);

	EducationComponentCorrespondenceDto educationComponentCorrespondenceToDto(EducationComponentCorrespondence componentCorrespondence);

	default String map(Object value) {
		return value != null ? value.toString() : null;
	}
}
