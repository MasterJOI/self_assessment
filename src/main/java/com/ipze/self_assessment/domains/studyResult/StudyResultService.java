package com.ipze.self_assessment.domains.studyResult;

import com.ipze.self_assessment.domains.educationalComponent.EducationalComponentRepository;
import com.ipze.self_assessment.domains.selfAssessment.SelfAssessmentRepository;
import com.ipze.self_assessment.domains.studyResult.dto.CorrespondenceRequestBodyDto;
import com.ipze.self_assessment.domains.studyResult.dto.StudyResultDto;
import com.ipze.self_assessment.domains.studyResult.dto.StudyResultRequestBodyDto;
import com.ipze.self_assessment.domains.tableAnnex.TableAnnexRepository;
import com.ipze.self_assessment.exceptions.custom.IdNotFoundException;
import com.ipze.self_assessment.model.dto.ApiResponse;
import com.ipze.self_assessment.model.entity.EducationComponentCorrespondence;
import com.ipze.self_assessment.model.entity.StudyResult;
import com.ipze.self_assessment.model.entity.TableAnnex;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@PropertySource("classpath:storage.properties")
public class StudyResultService {

	private final StudyResultRepository studyResultRepository;
	private final SelfAssessmentRepository selfAssessmentRepository;
	private final TableAnnexRepository tableAnnexRepository;
	private final EducationComponentCorrespondenceRepository componentCorrespondenceRepository;
	private final EducationalComponentRepository educationalComponentRepository;

	public ApiResponse updateStudyResult(UUID id, StudyResultRequestBodyDto requestBody) {
		var studyResult = studyResultRepository.findById(id)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));

		studyResult.setName(requestBody.getName());
		studyResult.setIsCorresponds(requestBody.getIsCorresponds());

		Set<UUID> correspondencesIds = requestBody.getComponentCorrespondences()
			.stream()
			.filter(item -> item.getId().isPresent())
			.map(item -> UUID.fromString(item.getId().get()))
			.collect(Collectors.toSet());

		Map<UUID, EducationComponentCorrespondence> items = componentCorrespondenceRepository.findAllById(correspondencesIds)
			.stream()
			.collect(Collectors.toMap(EducationComponentCorrespondence::getId, item -> item));

		requestBody.getComponentCorrespondences()
			.forEach(item -> {
				studyResult.addItem(
					buildComponentCorrespondence(item, studyResult, item.getId().isPresent() ? items.get(UUID.fromString(item.getId().get())) : new EducationComponentCorrespondence()));
			});

		studyResult.getEducationComponentCorrespondences()
			.removeIf(item -> item.getId() != null && !correspondencesIds.contains(item.getId()));

		var entity = studyResultRepository.save(studyResult);

		StudyResultDto dto = StudyResultDto.fromEntity(entity);
		return new ApiResponse(dto, "Результат навчання збережено");
	}

	private EducationComponentCorrespondence buildComponentCorrespondence(
		CorrespondenceRequestBodyDto item,
		StudyResult studyResult,
		EducationComponentCorrespondence correspondence) {

		var component = educationalComponentRepository.findById(UUID.fromString(item.getDisciplineId())).orElseThrow(
			() -> new IdNotFoundException("Освітній компонент з id : " + item.getDisciplineId() + " не знайдено.")
		);

		correspondence.setAssessmentForm(item.getAssessmentForm());
		correspondence.setTeachingMethod(item.getTeachingMethod());
		correspondence.setEducationalComponent(component);
		correspondence.setStudyResult(studyResult);
		return correspondence;
	}

	public ApiResponse createStudyResult(UUID selfAssessmentId, StudyResultRequestBodyDto requestBody) {
		var tableAnnex = selfAssessmentRepository.findById(selfAssessmentId)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + selfAssessmentId + " не знайдено.")).getTablesAnnex();

		var studyResult = new StudyResult();

		studyResult.setName(requestBody.getName());
		studyResult.setIsCorresponds(requestBody.getIsCorresponds());

		requestBody.getComponentCorrespondences().forEach(
			item -> {
				EducationComponentCorrespondence correspondence = buildComponentCorrespondence(
					item, studyResult, new EducationComponentCorrespondence());
				studyResult.getEducationComponentCorrespondences().add(correspondence);
			}
		);

		var entity = studyResultRepository.save(studyResult);
		tableAnnex.getStudyResults().add(entity);

		tableAnnexRepository.save(tableAnnex);

		StudyResultDto dto = StudyResultDto.fromEntity(entity);
		return new ApiResponse(dto, "Результат навчання збережено");
	}

	public ApiResponse deleteStudyResult(UUID id) {

		var studyResult = studyResultRepository.findById(id)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));

		Set<TableAnnex> tableAnnexes = studyResult.getTableAnnexes();

		for (TableAnnex tableAnnex : tableAnnexes) {
			tableAnnex.getStudyResults().remove(studyResult);
		}

		studyResult.setTableAnnexes(new LinkedHashSet<>());
		studyResultRepository.save(studyResult);
		studyResultRepository.deleteById(id);
		return new ApiResponse(id, "Освітній компонент видалено");
	}
}
