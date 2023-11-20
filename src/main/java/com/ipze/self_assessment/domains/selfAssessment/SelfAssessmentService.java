package com.ipze.self_assessment.domains.selfAssessment;

import com.ipze.self_assessment.domains.educationProgram.EducationProgramRepository;
import com.ipze.self_assessment.domains.educationProgram.EducationProgramsInfoRepository;
import com.ipze.self_assessment.domains.educationProgramDocument.EducationProgramDocumentRepository;
import com.ipze.self_assessment.domains.educationProgramDocument.EducationProgramDocumentService;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.DocumentToDownload;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.EducationProgramDocumentRequestDto;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.EducationProgramFormDto;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.GeneralInformationRequestBodyDto;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentDto;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentsInformationDto;
import com.ipze.self_assessment.domains.generalInformation.GeneralInformationRepository;
import com.ipze.self_assessment.domains.generalInformation.ProgramRestrictedInfoRepository;
import com.ipze.self_assessment.domains.hei.HeiAreaRepository;
import com.ipze.self_assessment.domains.hei.HeiRepository;
import com.ipze.self_assessment.domains.language.LanguageRepository;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoRequestBody;
import com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase.AccreditationCaseDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.accreditationCase.AccreditationCaseRequestBodyDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.general.EducationProgramDocumentDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.general.GeneralInformationDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.general.UploadFileDto;
import com.ipze.self_assessment.domains.selfAssessment.dto.sections.*;
import com.ipze.self_assessment.domains.selfAssessment.repo.*;
import com.ipze.self_assessment.domains.speciality.SpecialityRepository;
import com.ipze.self_assessment.domains.studyResult.dto.StudyResultDto;
import com.ipze.self_assessment.domains.studyResult.dto.StudyResultsMatrixDto;
import com.ipze.self_assessment.domains.subdivision.SubdivisionRepository;
import com.ipze.self_assessment.domains.tableAnnex.TableAnnexRepository;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationDto;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherSummaryInformationDto;
import com.ipze.self_assessment.domains.user.repo.TeacherRepository;
import com.ipze.self_assessment.exceptions.custom.IdNotFoundException;
import com.ipze.self_assessment.exceptions.custom.NoSuchEntityException;
import com.ipze.self_assessment.model.dto.ApiResponse;
import com.ipze.self_assessment.model.entity.*;
import com.ipze.self_assessment.model.enums.Cycle;
import com.ipze.self_assessment.model.enums.DocumentType;
import com.ipze.self_assessment.model.enums.ProgramType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;

@Service
@AllArgsConstructor
@Transactional
public class SelfAssessmentService {

	private final SelfAssessmentRepository selfAssessmentRepository;
	private final EducationProgramDocumentService educationProgramDocumentService;
	private final EducationProgramDocumentService documentService;
	private final SubdivisionRepository subdivisionRepository;
	private final SpecialityRepository specialityRepository;
	private final HeiRepository heiRepository;
	private final TeacherRepository teacherRepository;
	private final LanguageRepository languageRepository;
	private final EducationProgramDocumentRepository programDocumentRepository;
	private final EducationProgramRepository educationProgramRepository;
	private final EducationProgramsInfoRepository programsInfoRepository;
	private final HeiAreaRepository heiAreaRepository;
	private final ProgramRestrictedInfoRepository programRestrictedInfoRepository;
	private final GeneralInformationRepository generalInformationRepository;
	private final EducationProgramDesignRepository programDesignRepository;
	private final EducationalProgramStructureAndContentRepository structureAndContentRepository;
	private final EducationalProgramAccessRepository programAccessRepository;
	private final EducationalProgramLearningAndTeachingRepository learningAndTeachingRepository;
	private final ControlMeasuresAndAcademicIntegrityRepository measuresAndAcademicIntegrityRepository;
	private final HumanResourceRepository humanResourceRepository;
	private final EducationalEnvironmentAndMaterialResourceRepository environmentAndMaterialResourceRepository;
	private final QualityAssuranceRepository qualityAssuranceRepository;
	private final EducationalTransparencyAndPublicityRepository transparencyAndPublicityRepository;
	private final EducationalProgramRepository educationalProgramRepository;
	private final OpDevelopmentPerspectiveRepository developmentPerspectiveRepository;
	private final GeneralQuestionAnswerRepository generalQuestionAnswerRepository;
	private final TableAnnexRepository tableAnnexRepository;

	public ApiResponse getAllSelfAssessmentInfo(Integer from, Integer count) {
		var pageable = PageRequest.of(from / count, count);
		Page<InformationOnSelfAssessmentOfEducationalProgram> page = selfAssessmentRepository.getAllSelfAssessmentInfo(pageable);

		List<AccreditationCaseDto> accreditationCaseDtos = page
			.getContent()
			.stream()
			.map(this::mapCase)
			.toList();

		Map<String, Object> response = new HashMap<>();
		response.put("data", accreditationCaseDtos);
		response.put("totalRecords", page.getTotalElements());

		return new ApiResponse(response, "Дані успішно отримано!");
	}

	public AccreditationCaseDto mapCase(InformationOnSelfAssessmentOfEducationalProgram selfAssessmentInfo) {
		var accreditationCaseDto = new AccreditationCaseDto();
		var educationProgramInfo = selfAssessmentInfo.getGeneralInformation().getEducationProgramAccreditationInformation().getEducationProgram();

		accreditationCaseDto.setId(String.valueOf(selfAssessmentInfo.getId()));
		accreditationCaseDto.setEducationProgramId(educationProgramInfo.getEducationProgramId());
		accreditationCaseDto.setCycle(educationProgramInfo.getCycle().getValue());
		accreditationCaseDto.setSpecialty(educationProgramInfo.getSpecialty().getSpecialty());
		accreditationCaseDto.setSpecialtyCode(educationProgramInfo.getSpecialty().getSpecialtyCode());
		accreditationCaseDto.setName(educationProgramInfo.getName());
		accreditationCaseDto.setProgramType(educationProgramInfo.getProgramType().getValue());
		accreditationCaseDto.setStatus(selfAssessmentInfo.getStatus().getValue());
		return accreditationCaseDto;
	}

	public SelfAssessmentInfoDto getSelfAssessmentInfo(UUID id) {
		var selfAssessmentInfo = selfAssessmentRepository.getSelfAssessmentInfoById(id)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));

		return mapSelfAssessmentInfo(selfAssessmentInfo);
	}

	private SelfAssessmentInfoDto mapSelfAssessmentInfo(InformationOnSelfAssessmentOfEducationalProgram selfAssessmentInfo) {
		var generalQuestionAnswer = selfAssessmentInfo.getGeneralQuestionAnswer();

		//general
		var generalInformation = GeneralInformationDto.fromEntity(selfAssessmentInfo.getGeneralInformation());

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
				.stream().map(StudyResultDto::fromEntity).collect(Collectors.toList()));

		var selfAssessmentInfoDto = new SelfAssessmentInfoDto();

		selfAssessmentInfoDto.setId(selfAssessmentInfo.getId().toString());
		selfAssessmentInfoDto.setGeneralInformation(generalInformation);
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
					if ("general".equals(fieldName)) {
						GeneralInformation generalInformation = selfAssessmentInfo.getGeneralInformation();

						GeneralInformationRequestBodyDto dto = SelfAssessmentInfoMapper.MAPPER.fromMap(fieldData);
						mapGeneralInformation(generalInformation, dto);

						selfAssessmentInfo.setGeneralInformation(generalInformation);
					}
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

		var entity = selfAssessmentRepository.save(selfAssessmentInfo);
		var dto = mapSelfAssessmentInfo(entity);

		return ResponseEntity.ok(new ApiResponse(dto, "Дані успішно оновлено!"));
	}

	private void mapGeneralInformation(GeneralInformation generalInformation, GeneralInformationRequestBodyDto dto) {

		if (dto.getEducationProgramForms() != null) {
			generalInformation.getEducationProgramAccreditationInformation().setDuration(
				dto.getEducationProgramForms().stream().map(EducationProgramFormDto::getDuration)
					.collect(Collectors.joining(","))
			);
			generalInformation.getEducationProgramAccreditationInformation().setEducationProgramForms(
				dto.getEducationProgramForms().stream().map(EducationProgramFormDto::getEducationProgramForm)
					.collect(Collectors.joining(","))
			);
		}

		var subdivisionId = dto.getSubdivisionId();
		if (subdivisionId != null) {
			var subdivision = subdivisionRepository.findById(subdivisionId)
				.orElseThrow(() -> new IdNotFoundException("Структурний підрозділ з id : " + subdivisionId + " не знайдено."));
			generalInformation.getEducationProgramAccreditationInformation().setSubdivision(subdivision);
		}

		var otherSubdivisionsIds = dto.getOtherSubdivisionsIds();
		if (otherSubdivisionsIds != null && otherSubdivisionsIds.size() > 0) {
			var subdivisions = new HashSet<>(subdivisionRepository.findAllById(otherSubdivisionsIds));
			generalInformation.getEducationProgramAccreditationInformation().setOtherSubdivisions(subdivisions);
		}

		var grantsProfessionalQualification = dto.getGrantsProfessionalQualification();
		if (grantsProfessionalQualification != null) {
			generalInformation.getEducationProgramAccreditationInformation().setGrantsProfessionalQualification(grantsProfessionalQualification);
		}

		var professionalQualification = dto.getProfessionalQualification();
		if (professionalQualification != null) {
			generalInformation.getEducationProgramAccreditationInformation().setProfessionalQualification(professionalQualification);
		}


		var languagesIds = dto.getLanguagesIds();
		if (languagesIds != null && languagesIds.size() > 0) {
			var languages = new HashSet<>(languageRepository.findAllById(languagesIds));
			generalInformation.getEducationProgramAccreditationInformation().setLanguages(languages);
		}

		var partnerHei = dto.getPartnerHei();
		if (partnerHei != null) {
			generalInformation.getEducationProgramAccreditationInformation().setPartnerHei(partnerHei);
		}

		var historyAndDevelopment = dto.getHistoryAndDevelopment();
		if (historyAndDevelopment != null) {
			generalInformation.getEducationProgramAccreditationInformation().setHistoryAndDevelopment(historyAndDevelopment);
		}

		var educationProgramDocuments = dto.getEducationProgramDocuments();
		if (educationProgramDocuments != null && educationProgramDocuments.size() > 0) {
			Set<UUID> documentsIds = educationProgramDocuments
				.stream()
				.map(item -> UUID.fromString(item.getId()))
				.collect(Collectors.toSet());

			Map<UUID, EducationProgramDocument> items = programDocumentRepository.findAllById(documentsIds)
				.stream()
				.collect(Collectors.toMap(EducationProgramDocument::getId, item -> item));

			educationProgramDocuments
				.forEach(item -> {
					generalInformation.getEducationProgramDocuments().add(
						updateProgramDocument(item, items.get(UUID.fromString(item.getId()))));
				});

			generalInformation.getEducationProgramDocuments().removeIf(item -> {
				if (item.getId() != null && !documentsIds.contains(item.getId())) {
					String filePath = item.getPath();
					Path oldPath = Paths.get(filePath);

					try {
						Files.deleteIfExists(oldPath);
					} catch (IOException e) {
						e.printStackTrace();
					}

					return true;
				}
				return false;
			});
		}
	}

	public AccreditationCaseDto createAccreditationCase(AccreditationCaseRequestBodyDto body) {

		var speciality = specialityRepository.findById(UUID.fromString(body.getSpecialtyId()))
			.orElseThrow(() -> new IdNotFoundException("Спеціальність з id : " + body.getSpecialtyId() + " не знайдено."));

		var guarantee = teacherRepository.findById(UUID.fromString(body.getGuaranteeId()))
			.orElseThrow(() -> new IdNotFoundException("Викладача з id : " + body.getGuaranteeId() + " не знайдено."));

		var hei = heiRepository.findById(UUID.fromString(body.getHeiId()))
			.orElseThrow(() -> new IdNotFoundException("Заклад вищої освіти з id : " + body.getHeiId() + " не знайдено."));

		//create education program
		var educationProgram = new EducationProgram();
		educationProgram.setEducationProgramId(body.getEducationProgramId());
		educationProgram.setName(body.getName());
		educationProgram.setCycle(Cycle.valueOf(body.getCycle()));
		educationProgram.setProgramType(ProgramType.valueOf(body.getProgramType()));
		educationProgram.setSpecialty(speciality);

		educationProgramRepository.save(educationProgram);

		//create educationProgramAccreditationInformation
		var educationProgramAccreditationInformation = new EducationProgramAccreditationInformation();
		educationProgramAccreditationInformation.setEducationProgram(educationProgram);
		educationProgramAccreditationInformation.setGuarantee(guarantee);

		programsInfoRepository.save(educationProgramAccreditationInformation);

		//create HigherEducationInstitutionArea
		var higherEducationInstitutionArea = new HigherEducationInstitutionArea();

		heiAreaRepository.save(higherEducationInstitutionArea);

		//create selfAssessmentEducationalProgramRestrictedInfo
		var selfAssessmentEducationalProgramRestrictedInfo = new SelfAssessmentEducationalProgramRestrictedInfo();

		programRestrictedInfoRepository.save(selfAssessmentEducationalProgramRestrictedInfo);

		//create general information
		var generalInformation = new GeneralInformation();
		generalInformation.setEducationProgramAccreditationInformation(educationProgramAccreditationInformation);
		generalInformation.setHigherEducationInstitutionArea(higherEducationInstitutionArea);
		generalInformation.setHigherEducationInstitutionInformation(hei);
		generalInformation.setSelfAssessmentEducationalProgramRestrictedInfo(selfAssessmentEducationalProgramRestrictedInfo);

		generalInformationRepository.save(generalInformation);

		//create general question answer
		var programDesign = new EducationProgramDesign();
		programDesignRepository.save(programDesign);
		var programStructureAndContent = new EducationalProgramStructureAndContent();
		structureAndContentRepository.save(programStructureAndContent);
		var programAccess = new EducationalProgramAccess();
		programAccessRepository.save(programAccess);
		var learningAndTeaching = new EducationalProgramLearningAndTeaching();
		learningAndTeachingRepository.save(learningAndTeaching);
		var controlMeasuresAndAcademicIntegrity = new ControlMeasuresAndAcademicIntegrity();
		measuresAndAcademicIntegrityRepository.save(controlMeasuresAndAcademicIntegrity);
		var humanResource = new HumanResource();
		humanResourceRepository.save(humanResource);
		var environmentAndMaterialResource = new EducationalEnvironmentAndMaterialResource();
		environmentAndMaterialResourceRepository.save(environmentAndMaterialResource);
		var qualityAssurance = new QualityAssurance();
		qualityAssuranceRepository.save(qualityAssurance);
		var transparencyAndPublicity = new EducationalTransparencyAndPublicity();
		transparencyAndPublicityRepository.save(transparencyAndPublicity);
		var educationalProgram = new EducationalProgram();
		educationalProgramRepository.save(educationalProgram);
		var opDevelopmentPerspective = new OpDevelopmentPerspective();
		developmentPerspectiveRepository.save(opDevelopmentPerspective);

		var generalQuestionAnswer = new GeneralQuestionAnswer();
		generalQuestionAnswer.setEducationalProgramDesign(programDesign);
		generalQuestionAnswer.setEducationalProgramStructureAndContent(programStructureAndContent);
		generalQuestionAnswer.setEducationalProgramAccess(programAccess);
		generalQuestionAnswer.setEducationalProgramLearningAndTeaching(learningAndTeaching);
		generalQuestionAnswer.setControlMeasuresAndAcademicIntegrity(controlMeasuresAndAcademicIntegrity);
		generalQuestionAnswer.setHumanResources(humanResource);
		generalQuestionAnswer.setEducationalEnvironmentAndMaterialResources(environmentAndMaterialResource);
		generalQuestionAnswer.setQualityAssurance(qualityAssurance);
		generalQuestionAnswer.setEducationalTransparencyAndPublicity(transparencyAndPublicity);
		generalQuestionAnswer.setEducationalProgram(educationalProgram);
		generalQuestionAnswer.setEducationalProgramDevelopmentPerspectives(opDevelopmentPerspective);

		generalQuestionAnswerRepository.save(generalQuestionAnswer);

		//create table annex
		var tableAnnex = new TableAnnex();
		tableAnnexRepository.save(tableAnnex);

		//create self assessment information
		var selfAssessment = new InformationOnSelfAssessmentOfEducationalProgram();
		selfAssessment.setGeneralInformation(generalInformation);
		selfAssessment.setGeneralQuestionAnswer(generalQuestionAnswer);
		selfAssessment.setTablesAnnex(tableAnnex);

		var entity = selfAssessmentRepository.save(selfAssessment);

		return mapCase(entity);
	}

	public List<UUID> deleteSelfAssessmentInfo(List<UUID> IDs) {
		for (UUID id : IDs) {
			var selfAssessmentInfo = selfAssessmentRepository.getSelfAssessmentInfoById(id)
				.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));
			selfAssessmentInfo.setDeleted(true);
			selfAssessmentRepository.save(selfAssessmentInfo);
		}
		return IDs;
	}

	public DocumentToDownload generate(UUID id) {
		SelfAssessmentInfoDto info = getSelfAssessmentInfo(id);

		return educationProgramDocumentService.generateSelfAssessmentDocument(info);
	}

	public ApiResponse uploadGeneralDocument(UUID selfAssessmentId, UploadFileDto requestBody) throws IOException {
		var selfAssessmentInfo = selfAssessmentRepository.findById(selfAssessmentId)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + selfAssessmentId + " не знайдено."));

		MultipartFile file = requestBody.getFile();

		var document = new EducationProgramDocument();
		document.setType(DocumentType.valueOf(requestBody.getType()));
		documentService.saveDocument(file, document, DocumentType.valueOf(requestBody.getType()));
		selfAssessmentInfo.getGeneralInformation().getEducationProgramDocuments().add(document);

		var newDocuments = selfAssessmentRepository
			.save(selfAssessmentInfo)
			.getGeneralInformation()
			.getEducationProgramDocuments()
			.stream()
			.map(EducationProgramDocumentDto::fromEntity).toList();

		return new ApiResponse(newDocuments, "Дані успішно оновлено!");
	}

	private EducationProgramDocument updateProgramDocument(
		EducationProgramDocumentRequestDto item,
		EducationProgramDocument document) {

		document.setType(DocumentType.valueOf(item.getType()));

		return document;
	}

	public DocumentToDownload download(UUID id) {
		final EducationProgramDocument document = programDocumentRepository.findById(id)
			.orElseThrow(() -> new NoSuchEntityException("Файл з id : " + id + " не знайдено."));
		return documentService.download(document.getPath());
	}
}
