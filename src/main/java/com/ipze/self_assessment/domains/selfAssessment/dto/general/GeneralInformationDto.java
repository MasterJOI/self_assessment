package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import com.ipze.self_assessment.domains.language.dto.LanguageDto;
import com.ipze.self_assessment.domains.selfAssessment.SelfAssessmentInfoMapper;
import com.ipze.self_assessment.domains.subdivision.dto.SubdivisionDto;
import com.ipze.self_assessment.model.entity.GeneralInformation;
import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
@Builder
public class GeneralInformationDto {
	private EducationProgramAccreditationInformationDto educationProgramAccreditationInformation;
	private List<EducationStatisticDto> educationStatistic;
	private HigherEducationInstitutionAreaDto higherEducationInstitutionArea;
	private HigherEducationInstitutionInformationDto higherEducationInstitutionInformation;
	private SelfAssessmentEducationalProgramRestrictedInfoDto selfAssessmentEducationalProgramRestrictedInfo;
	private List<EducationProgramDocumentDto> educationProgramDocuments;


	public static GeneralInformationDto fromEntity(GeneralInformation information) {
		var accreditationInfo = information.getEducationProgramAccreditationInformation();

		// educationProgramAccreditationInformation
		var educationProgramAccreditationInformation = SelfAssessmentInfoMapper.MAPPER
			.educationProgramAccreditationInformationToDto(accreditationInfo);

		educationProgramAccreditationInformation.setCycle(accreditationInfo.getEducationProgram().getCycle().getValue());
		educationProgramAccreditationInformation.setProgramType(accreditationInfo.getEducationProgram().getProgramType().getValue());
		educationProgramAccreditationInformation.setSpecialtyLicensingInfo(accreditationInfo.getEducationProgram().getSpecialtyLicensingInfo());
		educationProgramAccreditationInformation.setSpecialization(accreditationInfo.getEducationProgram().getSpecialization());
		educationProgramAccreditationInformation.setAdmissionDegree(accreditationInfo.getEducationProgram().getAdmissionDegree());
		if (accreditationInfo.getDuration() != null) {
			educationProgramAccreditationInformation.setDuration(List.of(accreditationInfo.getDuration().split(",")));
		}
		if (accreditationInfo.getEducationProgramForms() != null) {
			educationProgramAccreditationInformation.setEducationProgramForms(List.of(accreditationInfo.getEducationProgramForms().split(",")));
		}

		var guarantee = GuaranteeDto.fromEntity(accreditationInfo.getGuarantee());
		educationProgramAccreditationInformation.setGuarantee(guarantee);

		educationProgramAccreditationInformation.setEducationProgramId(accreditationInfo.getEducationProgram().getEducationProgramId());
		educationProgramAccreditationInformation.setEducationProgramName(accreditationInfo.getEducationProgram().getName());
		educationProgramAccreditationInformation.setFieldOfStudy(accreditationInfo.getEducationProgram().getSpecialty().getFieldOfStudy().getFieldOfStudy());
		educationProgramAccreditationInformation.setFieldOfStudyCode(accreditationInfo.getEducationProgram().getSpecialty().getFieldOfStudy().getFieldOfStudyCode());
		educationProgramAccreditationInformation.setSpecialty(accreditationInfo.getEducationProgram().getSpecialty().getSpecialty());
		educationProgramAccreditationInformation.setSpecialtyCode(accreditationInfo.getEducationProgram().getSpecialty().getSpecialtyCode());

		if (accreditationInfo.getSubdivision() != null) {
			educationProgramAccreditationInformation.setSubdivisionName(accreditationInfo.getSubdivision().getResponsibleDepartment());
			educationProgramAccreditationInformation.setSubdivisionId(String.valueOf(accreditationInfo.getSubdivision().getId()));
		}
		educationProgramAccreditationInformation.setLanguages(accreditationInfo.getLanguages().stream()
			.map(language -> new LanguageDto(
				String.valueOf(language.getId()),
				String.valueOf(language.getName()
			))).toList());
		educationProgramAccreditationInformation.setOtherSubdivisions(accreditationInfo.getOtherSubdivisions().stream()
			.map(subdivision -> new SubdivisionDto(
				String.valueOf(subdivision.getId()),
				String.valueOf(subdivision.getResponsibleDepartment())
			)).toList());

		//educationStatistic
		var educationStatistics = information.getEducationStatistics().stream()
			.map(SelfAssessmentInfoMapper.MAPPER::educationStatisticToDto)
			.sorted(Comparator.comparingInt(EducationStatisticDto::getStudyCourseYear))
			.toList();

		//higherEducationInstitutionArea
		var higherEducationInstitutionArea = SelfAssessmentInfoMapper.MAPPER.higherEducationInstitutionAreaToDto(information.getHigherEducationInstitutionArea());

		//higherEducationInstitutionInformation
		var higherEducationInstitutionInformation = SelfAssessmentInfoMapper.MAPPER.higherEducationalInstitutionInformationToDto(information.getHigherEducationInstitutionInformation());

		//selfAssessmentEducationalProgramRestrictedInfo
		var restrictedInfo = SelfAssessmentInfoMapper.MAPPER
			.selfAssessmentEducationalProgramRestrictedInfoToDto(information.getSelfAssessmentEducationalProgramRestrictedInfo());

		//educationProgramDocuments
		var educationProgramDocuments = information.getEducationProgramDocuments().stream()
			.map(EducationProgramDocumentDto::fromEntity).toList();

		return builder()
			.educationProgramAccreditationInformation(educationProgramAccreditationInformation)
			.educationStatistic(educationStatistics)
			.higherEducationInstitutionArea(higherEducationInstitutionArea)
			.higherEducationInstitutionInformation(higherEducationInstitutionInformation)
			.selfAssessmentEducationalProgramRestrictedInfo(restrictedInfo)
			.educationProgramDocuments(educationProgramDocuments)
			.build();
	}
}
