package com.ipze.self_assessment.domains.teacherInformation;

import com.ipze.self_assessment.domains.educationalComponent.EducationalComponentRepository;
import com.ipze.self_assessment.domains.selfAssessment.SelfAssessmentRepository;
import com.ipze.self_assessment.domains.tableAnnex.TableAnnexRepository;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationDto;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationRequestBodyDto;
import com.ipze.self_assessment.domains.user.repo.TeacherRepository;
import com.ipze.self_assessment.exceptions.custom.IdNotFoundException;
import com.ipze.self_assessment.model.dto.ApiResponse;
import com.ipze.self_assessment.model.entity.TableAnnex;
import com.ipze.self_assessment.model.entity.TeacherSummaryInformation;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
@PropertySource("classpath:storage.properties")
public class TeacherInformationService {

	private final TeacherInformationRepository teacherInformationRepository;
	private final EducationalComponentRepository educationalComponentRepository;
	private final SelfAssessmentRepository selfAssessmentRepository;
	private final TableAnnexRepository tableAnnexRepository;
	private final TeacherRepository teacherRepository;

	public ApiResponse updateTeacherInformation(UUID id, TeacherInformationRequestBodyDto requestBody) {
		var teacherSummaryInformation = teacherInformationRepository.findById(id)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + id + " не знайдено."));

		var components = new HashSet<>(educationalComponentRepository.findAllById(requestBody.getDisciplinesIDs()));
		teacherSummaryInformation.setProgramEducationalComponentsInformations(components);

		var entity = teacherInformationRepository.save(teacherSummaryInformation);
		TeacherInformationDto dto = TeacherInformationDto.fromEntity(entity);
		return new ApiResponse(dto, "Інформацію про викладача збережено");
	}

	public ApiResponse createTeacherInformation(UUID selfAssessmentId, TeacherInformationRequestBodyDto requestBody) {
		var tableAnnex = selfAssessmentRepository.findById(selfAssessmentId)
			.orElseThrow(() -> new IdNotFoundException("Запис з id : " + selfAssessmentId + " не знайдено.")).getTablesAnnex();
		var teacherSummaryInformation = new TeacherSummaryInformation();

		var components = new HashSet<>(educationalComponentRepository.findAllById(requestBody.getDisciplinesIDs()));

		var teacher = teacherRepository.getByTeacherId(requestBody.getTeacherId())
			.orElseThrow(() -> new IdNotFoundException("Викладача з id : " + requestBody.getTeacherId() + " не знайдено."));
		;

		teacherSummaryInformation.setTeacher(teacher);
		teacherSummaryInformation.setProgramEducationalComponentsInformations(components);

		var entity = teacherInformationRepository.save(teacherSummaryInformation);
		tableAnnex.getTeacherSummaryInformations().add(entity);

		tableAnnexRepository.save(tableAnnex);

		TeacherInformationDto dto = TeacherInformationDto.fromEntity(entity);
		return new ApiResponse(dto, "Інформацію про викладача збережено");
	}

	public ApiResponse deleteTeacherInformation(UUID id) {

		var teacherSummaryInformation = teacherInformationRepository.findById(id).orElseThrow(
			() -> new IdNotFoundException("Інформацію про викладача з id : " + id + " не знайдено.")
		);

		Set<TableAnnex> tableAnnexes = teacherSummaryInformation.getTableAnnexes();

		for (TableAnnex tableAnnex : tableAnnexes) {
			tableAnnex.getTeacherSummaryInformations().remove(teacherSummaryInformation);
		}

		teacherSummaryInformation.setTableAnnexes(new LinkedHashSet<>());
		teacherInformationRepository.save(teacherSummaryInformation);
		teacherInformationRepository.deleteById(id);

		return new ApiResponse(id, "Інформацію про викладача видалено");
	}
}
