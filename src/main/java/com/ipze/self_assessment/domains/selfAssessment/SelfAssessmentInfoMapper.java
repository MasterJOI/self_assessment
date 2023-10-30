package com.ipze.self_assessment.domains.selfAssessment;

import com.ipze.self_assessment.domains.educationProgramDocument.dto.EducationProgramDocumentRequestDto;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.EducationProgramFormDto;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.GeneralInformationRequestBodyDto;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentDto;
import com.ipze.self_assessment.domains.language.dto.LanguageDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.general.*;
import com.ipze.self_assessment.domains.selfAssessment.dto.sections.*;
import com.ipze.self_assessment.domains.studyResult.dto.EducationComponentCorrespondenceDto;
import com.ipze.self_assessment.domains.subdivision.dto.SubdivisionDto;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationDto;
import com.ipze.self_assessment.model.entity.*;
import com.ipze.self_assessment.model.enums.StudyCourseYear;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper
public interface SelfAssessmentInfoMapper {
	SelfAssessmentInfoMapper MAPPER = Mappers.getMapper(SelfAssessmentInfoMapper.class);

	//general

	@Mapping(target = "cycle", ignore = true)
	@Mapping(target = "specialtyLicensingInfo", ignore = true)
	@Mapping(target = "admissionDegree", ignore = true)
	@Mapping(target = "specialization", ignore = true)
	@Mapping(target = "programType", ignore = true)
	@Mapping(target = "specialty", ignore = true)
	@Mapping(target = "fieldOfStudy", ignore = true)
	@Mapping(target = "duration", ignore = true)
	@Mapping(target = "educationProgramForms", ignore = true)
	EducationProgramAccreditationInformationDto educationProgramAccreditationInformationToDto(EducationProgramAccreditationInformation information);

	default Integer map(StudyCourseYear studyCourseYear) {
		return studyCourseYear.ordinal() + 1;
	}
	EducationStatisticDto educationStatisticToDto(EducationStatistic educationStatistic);
	HigherEducationInstitutionAreaDto higherEducationInstitutionAreaToDto(HigherEducationInstitutionArea higherEducationInstitutionArea);

	HigherEducationInstitutionInformationDto higherEducationalInstitutionInformationToDto(HigherEducationInstitutionInformation higherEducationalInstitution);
	SelfAssessmentEducationalProgramRestrictedInfoDto selfAssessmentEducationalProgramRestrictedInfoToDto(SelfAssessmentEducationalProgramRestrictedInfo restrictedInfo);

	//general

	@Mapping(target = "educationProgramDocuments", ignore = true)
	@Mapping(target = "educationProgramForms", ignore = true)
	@Mapping(target = "otherSubdivisionsIds", ignore = true)
	@Mapping(target = "languagesIds", ignore = true)
	GeneralInformationRequestBodyDto fromMap(Map<String, Object> fieldData);

	@AfterMapping
	default void mapListSubdivisionDto(Map<String, Object> source, @MappingTarget GeneralInformationRequestBodyDto target) {
		if (source.containsKey("otherSubdivisionsIds")) {
			List<String> subdivisionStrings = (List<String>) source.get("otherSubdivisionsIds");
			List<UUID> uuids = convertStringListToUUIDList(subdivisionStrings);
			target.setOtherSubdivisionsIds(uuids);
		}
	}

	@AfterMapping
	default void mapListLanguageDto(Map<String, Object> source, @MappingTarget GeneralInformationRequestBodyDto target) {
		if (source.containsKey("languagesIds")) {
			List<String> languageStrings = (List<String>) source.get("languagesIds");
			List<UUID> uuids = convertStringListToUUIDList(languageStrings);
			target.setLanguagesIds(uuids);
		}
	}

	@AfterMapping
	default void mapListEducationProgramFormDto(Map<String, Object> source, @MappingTarget GeneralInformationRequestBodyDto target) {
		mapListToDto(source, target::setEducationProgramForms, this::mapToEducationProgramFormDto, "educationProgramForms");
	}

	@AfterMapping
	default void mapListEducationProgramDocumentRequestDto(Map<String, Object> source, @MappingTarget GeneralInformationRequestBodyDto target) {
		mapListToDto(source, target::setEducationProgramDocuments, this::mapToEducationProgramDocumentRequestDto, "educationProgramDocuments");
	}

	private <T> void mapListToDto(Map<String, Object> source, Consumer<List<T>> targetSetter, Function<Map<String, Object>, T> mapper, String targetFieldName) {
		if (source.containsKey(targetFieldName)) {
			List<Map<String, Object>> listSource = (List<Map<String, Object>>) source.get(targetFieldName);
			List<T> listTarget = listSource.stream()
				.map(mapper)
				.collect(Collectors.toList());
			targetSetter.accept(listTarget);
		}
	}

	private List<UUID> convertStringListToUUIDList(List<String> stringList) {
		return stringList.stream()
			.map(UUID::fromString)
			.collect(Collectors.toList());
	}

	EducationProgramFormDto mapToEducationProgramFormDto(Map<String, Object> source);
	EducationProgramDocumentRequestDto mapToEducationProgramDocumentRequestDto(Map<String, Object> source);

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

	EducationComponentCorrespondenceDto educationComponentCorrespondenceToDto(EducationComponentCorrespondence componentCorrespondence);

	default String map(Object value) {
		return value != null ? value.toString() : null;
	}
}
