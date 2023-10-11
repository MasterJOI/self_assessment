package com.ipze.self_assessment.domains.selfAssessment;

import com.ipze.self_assessment.domains.educationProgramDocument.dto.DocumentToDownload;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentDto;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentsInformationDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.AccreditationCaseDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoRequestBody;
import com.ipze.self_assessment.domains.selfAssessment.dto.sections.*;
import com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix.EducationComponentCorrespondenceDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix.StudyResultDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.tables.StudyResultsMatrix.StudyResultsMatrixDto;
import com.ipze.self_assessment.domains.teacherInformation.dto.Discipline;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationDto;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherSummaryInformationDto;
import com.ipze.self_assessment.exceptions.custom.IdNotFoundException;
import com.ipze.self_assessment.model.dto.ApiResponse;
import com.ipze.self_assessment.model.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SelfAssessmentService {

	private final SelfAssessmentRepository selfAssessmentRepository;

	public List<AccreditationCaseDto> getAllSelfAssessmentInfo(Integer from, Integer count) {
		var pageable = PageRequest.of(from / count, count);
		return selfAssessmentRepository.getAllSelfAssessmentInfo(pageable).stream().map(this::mapCase).collect(Collectors.toList());
	}

	public AccreditationCaseDto mapCase(InformationOnSelfAssessmentOfEducationalProgram selfAssessmentInfo) {
		var accreditationCaseDto = new AccreditationCaseDto();
		var educationProgramInfo = selfAssessmentInfo.getGeneralInformation().getEducationProgramAccreditationInformation();

		accreditationCaseDto.setEducationProgramId(educationProgramInfo.getEducationProgram().getEducationProgramId());
		accreditationCaseDto.setCycle(educationProgramInfo.getCycle());
		accreditationCaseDto.setSpecialty(educationProgramInfo.getSpecialty().getSpecialty());
		accreditationCaseDto.setSpecialtyCode(educationProgramInfo.getSpecialty().getSpecialtyCode());
		accreditationCaseDto.setName(educationProgramInfo.getEducationProgram().getName());
		accreditationCaseDto.setProgramType(educationProgramInfo.getProgramType());
		accreditationCaseDto.setStatus(selfAssessmentInfo.getStatus().getValue());
		return accreditationCaseDto;
	}

	public SelfAssessmentInfoDto getSelfAssessmentInfo(Long programId) {
		var selfAssessmentInfo = selfAssessmentRepository.getSelfAssessmentInfoByProgramId(programId)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + programId + " не знайдено."));

		var generalQuestionAnswer = selfAssessmentInfo.getGeneralQuestionAnswer();

		//1
		var programDesignDto = SelfAssessmentInfoMapper.MAPPER.educationProgramDesignToDto(
			generalQuestionAnswer.getEducationalProgramDesign()
		);

		//2
		var structureAndContentDto = SelfAssessmentInfoMapper.MAPPER.educationalProgramStructureAndContentToDto(
			generalQuestionAnswer.getEducationalProgramStructureAndContent()
		);

		//3
		var programAccessDto = SelfAssessmentInfoMapper.MAPPER.educationalProgramAccessToDto(
			generalQuestionAnswer.getEducationalProgramAccess()
		);

		//4
		var learningAndTeachingDto = SelfAssessmentInfoMapper.MAPPER.educationalProgramLearningAndTeachingToDto(
			generalQuestionAnswer.getEducationalProgramLearningAndTeaching()
		);

		//5
		var controlMeasuresAndAcademicIntegrityDto = SelfAssessmentInfoMapper.MAPPER.controlMeasuresAndAcademicIntegrityToDto(
			generalQuestionAnswer.getControlMeasuresAndAcademicIntegrity()
		);

		//6
		var humanResourceDto = SelfAssessmentInfoMapper.MAPPER.humanResourceToDto(
			generalQuestionAnswer.getHumanResources()
		);

		//7
		var educationalEnvironmentAndMaterialResourceDto = SelfAssessmentInfoMapper.MAPPER.educationalEnvironmentAndMaterialResourceToDto(
			generalQuestionAnswer.getEducationalEnvironmentAndMaterialResources()
		);

		//8
		var qualityAssuranceDto = SelfAssessmentInfoMapper.MAPPER.qualityAssuranceToDto(
			generalQuestionAnswer.getQualityAssurance()
		);

		//9
		var transparencyAndPublicityDto = SelfAssessmentInfoMapper.MAPPER.educationalTransparencyAndPublicityToDto(
			generalQuestionAnswer.getEducationalTransparencyAndPublicity()
		);

		//10
		var educationalProgramDto = SelfAssessmentInfoMapper.MAPPER.educationalProgramToDto(
			generalQuestionAnswer.getEducationalProgram()
		);

		//11
		var developmentPerspectiveDto = SelfAssessmentInfoMapper.MAPPER.opDevelopmentPerspectiveToDto(
			generalQuestionAnswer.getEducationalProgramDevelopmentPerspectives()
		);

		//t1
		var educationalComponentsInformationDto = new ProgramEducationalComponentsInformationDto(
			selfAssessmentInfo.getTablesAnnex()
				.getProgramEducationalComponentsInformations()
				.stream()
				.filter(component -> !component.isDeleted())
				.map(ProgramEducationalComponentDto::fromEntity).collect(Collectors.toList()));

		//t2
		var teacherSummaryInformationDto = new TeacherSummaryInformationDto(
			selfAssessmentInfo.getTablesAnnex()
				.getTeacherSummaryInformations()
				.stream().map(TeacherInformationDto::fromEntity).collect(Collectors.toList()));

		//t3
		var studyResultsMatrixDto = new StudyResultsMatrixDto(
			selfAssessmentInfo.getTablesAnnex()
				.getStudyResults()
				.stream().map(this::mapStudyResult).collect(Collectors.toList()));

		var selfAssessmentInfoDto = new SelfAssessmentInfoDto();

		selfAssessmentInfoDto.setId(selfAssessmentInfo.getId().toString());
		selfAssessmentInfoDto.setProgramDesign(programDesignDto);
		selfAssessmentInfoDto.setStructureAndContent(structureAndContentDto);
		selfAssessmentInfoDto.setProgramAccess(programAccessDto);
		selfAssessmentInfoDto.setLearningAndTeaching(learningAndTeachingDto);
		selfAssessmentInfoDto.setControlMeasuresAndAcademicIntegrity(controlMeasuresAndAcademicIntegrityDto);
		selfAssessmentInfoDto.setHumanResource(humanResourceDto);
		selfAssessmentInfoDto.setEducationalEnvironmentAndMaterialResource(educationalEnvironmentAndMaterialResourceDto);
		selfAssessmentInfoDto.setQualityAssurance(qualityAssuranceDto);
		selfAssessmentInfoDto.setTransparencyAndPublicity(transparencyAndPublicityDto);
		selfAssessmentInfoDto.setEducationalProgram(educationalProgramDto);
		selfAssessmentInfoDto.setDevelopmentPerspective(developmentPerspectiveDto);

		selfAssessmentInfoDto.setProgramEducationalComponentsInformation(educationalComponentsInformationDto);
		selfAssessmentInfoDto.setTeacherSummaryInformation(teacherSummaryInformationDto);
		selfAssessmentInfoDto.setStudyResultsMatrix(studyResultsMatrixDto);

		return selfAssessmentInfoDto;
	}

	public StudyResultDto mapStudyResult(StudyResult studyResult) {
		var studyResultDto = SelfAssessmentInfoMapper.MAPPER.studyResultToDto(studyResult);
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

		studyResultDto.setComponentCorrespondences(componentCorrespondences);
		return studyResultDto;
	}

	public ResponseEntity<ApiResponse> editSelfAssessmentInfo(UUID id, SelfAssessmentInfoRequestBody requestBody) {
		var selfAssessmentInfo = selfAssessmentRepository.findById(id)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));

		Class<SelfAssessmentInfoRequestBody> clazz = SelfAssessmentInfoRequestBody.class;

		for (Field field : clazz.getDeclaredFields()) {
			String fieldName = field.getName();

			try {
				field.setAccessible(true);
				Map<String, Object> fieldData = (Map<String, Object>) field.get(requestBody);

				if (fieldData != null && !fieldData.isEmpty()) {
					if ("programDesign".equals(fieldName)) {
						EducationProgramDesign programDesign = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalProgramDesign();

						EducationProgramDesignDto dto = new EducationProgramDesignDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(programDesign, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalProgramDesign(programDesign);
					}

					if ("structureAndContent".equals(fieldName)) {
						EducationalProgramStructureAndContent structureAndContent = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalProgramStructureAndContent();

						EducationalProgramStructureAndContentDto dto = new EducationalProgramStructureAndContentDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(structureAndContent, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalProgramStructureAndContent(structureAndContent);
					}

					if ("programAccess".equals(fieldName)) {
						EducationalProgramAccess programAccess = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalProgramAccess();

						EducationalProgramAccessDto dto = new EducationalProgramAccessDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(programAccess, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalProgramAccess(programAccess);
					}

					if ("learningAndTeaching".equals(fieldName)) {
						EducationalProgramLearningAndTeaching learningAndTeaching = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalProgramLearningAndTeaching();

						EducationalProgramLearningAndTeachingDto dto = new EducationalProgramLearningAndTeachingDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(learningAndTeaching, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalProgramLearningAndTeaching(learningAndTeaching);
					}

					if ("controlMeasuresAndAcademicIntegrity".equals(fieldName)) {
						ControlMeasuresAndAcademicIntegrity controlMeasuresAndAcademicIntegrity = selfAssessmentInfo.getGeneralQuestionAnswer().getControlMeasuresAndAcademicIntegrity();

						ControlMeasuresAndAcademicIntegrityDto dto = new ControlMeasuresAndAcademicIntegrityDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(controlMeasuresAndAcademicIntegrity, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setControlMeasuresAndAcademicIntegrity(controlMeasuresAndAcademicIntegrity);
					}

					if ("humanResource".equals(fieldName)) {
						HumanResource humanResource = selfAssessmentInfo.getGeneralQuestionAnswer().getHumanResources();

						HumanResourceDto dto = new HumanResourceDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(humanResource, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setHumanResources(humanResource);
					}

					if ("educationalEnvironmentAndMaterialResource".equals(fieldName)) {
						EducationalEnvironmentAndMaterialResource educationalEnvironmentAndMaterialResource = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalEnvironmentAndMaterialResources();

						EducationalEnvironmentAndMaterialResourceDto dto = new EducationalEnvironmentAndMaterialResourceDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(educationalEnvironmentAndMaterialResource, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalEnvironmentAndMaterialResources(educationalEnvironmentAndMaterialResource);
					}

					if ("qualityAssurance".equals(fieldName)) {
						QualityAssurance qualityAssurance = selfAssessmentInfo.getGeneralQuestionAnswer().getQualityAssurance();

						QualityAssuranceDto dto = new QualityAssuranceDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(qualityAssurance, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setQualityAssurance(qualityAssurance);
					}

					if ("transparencyAndPublicity".equals(fieldName)) {
						EducationalTransparencyAndPublicity transparencyAndPublicity = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalTransparencyAndPublicity();

						EducationalTransparencyAndPublicityDto dto = new EducationalTransparencyAndPublicityDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(transparencyAndPublicity, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalTransparencyAndPublicity(transparencyAndPublicity);
					}

					if ("educationalProgram".equals(fieldName)) {
						EducationalProgram educationalProgram = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalProgram();

						EducationalProgramDto dto = new EducationalProgramDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(educationalProgram, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalProgram(educationalProgram);
					}

					if ("developmentPerspective".equals(fieldName)) {
						OpDevelopmentPerspective developmentPerspective = selfAssessmentInfo.getGeneralQuestionAnswer().getEducationalProgramDevelopmentPerspectives();

						OpDevelopmentPerspectiveDto dto = new OpDevelopmentPerspectiveDto();
						SelfAssessmentInfoMapper.MAPPER.updateFromMap(dto, fieldData);
						SelfAssessmentInfoMapper.MAPPER.updateFromDto(developmentPerspective, dto);

						selfAssessmentInfo.getGeneralQuestionAnswer().setEducationalProgramDevelopmentPerspectives(developmentPerspective);
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		selfAssessmentRepository.save(selfAssessmentInfo);
		return ResponseEntity.ok(new ApiResponse(null, "Дані успішно оновлено!"));
	}

	public Long[] deleteSelfAssessmentInfo(Long[] IDs) {
		for (Long id : IDs) {
			var selfAssessmentInfo = selfAssessmentRepository.getSelfAssessmentInfoByProgramId(id)
				.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));
			selfAssessmentInfo.setDeleted(true);
			selfAssessmentRepository.save(selfAssessmentInfo);
		}
		return IDs;
	}

	public DocumentToDownload generate(Long programId) {
		var selfAssessmentInfo = selfAssessmentRepository.getSelfAssessmentInfoByProgramId(programId)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + programId + " не знайдено."));


	}
}
