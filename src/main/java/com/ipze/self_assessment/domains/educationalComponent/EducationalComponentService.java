package com.ipze.self_assessment.domains.educationalComponent;

import com.ipze.self_assessment.domains.educationProgramDocument.EducationProgramDocumentRepository;
import com.ipze.self_assessment.domains.educationProgramDocument.EducationProgramDocumentService;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.DocumentToDownload;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentDto;
import com.ipze.self_assessment.domains.educationalComponent.dto.ProgramEducationalComponentRequestBodyDto;
import com.ipze.self_assessment.domains.selfAssessment.SelfAssessmentRepository;
import com.ipze.self_assessment.domains.tableAnnex.TableAnnexRepository;
import com.ipze.self_assessment.exceptions.custom.IdNotFoundException;
import com.ipze.self_assessment.exceptions.custom.NoSuchEntityException;
import com.ipze.self_assessment.model.dto.ApiResponse;
import com.ipze.self_assessment.model.entity.EducationProgramDocument;
import com.ipze.self_assessment.model.entity.ProgramEducationalComponentsInformation;
import com.ipze.self_assessment.model.enums.EducationComponentType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@AllArgsConstructor
@PropertySource("classpath:storage.properties")
public class EducationalComponentService {

	private final EducationalComponentRepository educationalComponentRepository;
	private final EducationProgramDocumentRepository programDocumentRepository;
	private final SelfAssessmentRepository selfAssessmentRepository;
	private final TableAnnexRepository tableAnnexRepository;
	private final EducationProgramDocumentService documentService;

	public ApiResponse updateComponentInformation(UUID id, ProgramEducationalComponentRequestBodyDto requestBody) throws IOException {
		var educationComponentInfo = educationalComponentRepository.findById(id)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));

		educationComponentInfo.setComponentName(requestBody.getComponentName());
		setComponentTypeFromInteger(educationComponentInfo, requestBody.getComponentType());
		educationComponentInfo.setSpecialEquipmentInfo(requestBody.getSpecialEquipmentInfo());

		MultipartFile file = requestBody.getFile();

		if (file != null) {
			var entity = educationComponentInfo.getEducationProgramDocument();
			final Path oldPath = Paths.get(entity.getPath());

			var document = documentService.saveDocument(file, entity);
			educationComponentInfo.setEducationProgramDocument(document);

			//delete old file
			Files.deleteIfExists(oldPath);
		}

		var entity = educationalComponentRepository.save(educationComponentInfo);

		ProgramEducationalComponentDto dto = ProgramEducationalComponentDto.fromEntity(entity);
		return new ApiResponse(dto, "Освітній компонент збережено");
	}

	public void setComponentTypeFromInteger(ProgramEducationalComponentsInformation information, Integer componentType) {
		EducationComponentType type = switch (componentType) {
			case 0 -> EducationComponentType.DISCIPLINE;
			case 1 -> EducationComponentType.PRACTICE;
			case 2 -> EducationComponentType.FINAL_CERTIFICATION;
			case 3 -> EducationComponentType.COURSE_PROJECT;
			default ->
				throw new IllegalArgumentException("Непідтримуване значення для componentType: " + componentType);
		};
		information.setComponentType(type);
	}

	public ApiResponse createComponentInformation(UUID selfAssessmentId, ProgramEducationalComponentRequestBodyDto requestBody) throws IOException {
		var tableAnnex = selfAssessmentRepository.findById(selfAssessmentId)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + selfAssessmentId + " не знайдено.")).getTablesAnnex();
		var educationComponentInfo = new ProgramEducationalComponentsInformation();

		educationComponentInfo.setComponentName(requestBody.getComponentName());
		setComponentTypeFromInteger(educationComponentInfo, requestBody.getComponentType());
		educationComponentInfo.setSpecialEquipmentInfo(requestBody.getSpecialEquipmentInfo());

		MultipartFile file = requestBody.getFile();

		var document = documentService.saveDocument(file, new EducationProgramDocument());
		educationComponentInfo.setEducationProgramDocument(document);

		var entity = educationalComponentRepository.save(educationComponentInfo);
		tableAnnex.getProgramEducationalComponentsInformations().add(educationComponentInfo);

		tableAnnexRepository.save(tableAnnex);

		ProgramEducationalComponentDto dto = ProgramEducationalComponentDto.fromEntity(entity);
		return new ApiResponse(dto, "Освітній компонент збережено");
	}

	public DocumentToDownload download(UUID id) {
		final EducationProgramDocument document = educationalComponentRepository.findById(id)
			.orElseThrow(() -> new NoSuchEntityException("Файл з таким id не знайдено")).getEducationProgramDocument();
		try {
			final File file = new File(document.getPath());
			final InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			return new DocumentToDownload(resource, file.length(), file.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Файл не знайдено в файловій системі");
		}
	}

	public ApiResponse deleteComponentInformation(UUID id) {

		var componentsInformation = educationalComponentRepository.findById(id)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));

		componentsInformation.setDeleted(true);
		educationalComponentRepository.save(componentsInformation);
		return new ApiResponse(id, "Освітній компонент видалено");
	}
}
