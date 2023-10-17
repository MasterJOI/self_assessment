package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import com.ipze.self_assessment.domains.selfAssessment.SelfAssessmentInfoMapper;
import com.ipze.self_assessment.model.entity.GeneralInformation;
import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class GeneralInformationDto {
	private EducationProgramAccreditationInformationDto educationProgramAccreditationInformation;
	private String historyAndDevelopment;
	private List<EducationStatisticDto> educationStatistic;
	private String website;
	private HigherEducationInstitutionAreaDto higherEducationInstitutionArea;
	private HigherEducationInstitutionInformationDto higherEducationInstitutionInformation;
	private SelfAssessmentEducationalProgramRestrictedInfoDto selfAssessmentEducationalProgramRestrictedInfo;
	private List<EducationProgramDocumentDto> educationProgramDocuments;


	public static GeneralInformationDto fromEntity(GeneralInformation information) {
		var accreditationInfo = information.getEducationProgramAccreditationInformation();

		// educationProgramAccreditationInformation
		var educationProgramAccreditationInformation = SelfAssessmentInfoMapper.MAPPER
			.educationProgramAccreditationInformationToDto(accreditationInfo);

		educationProgramAccreditationInformation.setDuration(List.of(accreditationInfo.getDuration().split(",")));
		educationProgramAccreditationInformation.setEducationProgramForms(List.of(accreditationInfo.getEducationProgramForms().split(",")));

		var guarantee = GuaranteeDto.fromEntity(accreditationInfo);
		educationProgramAccreditationInformation.setGuarantee(guarantee);

		educationProgramAccreditationInformation.setEducationProgramId(accreditationInfo.getEducationProgram().getEducationProgramId());
		educationProgramAccreditationInformation.setEducationProgramName(accreditationInfo.getEducationProgram().getName());
		educationProgramAccreditationInformation.setFieldOfStudy(accreditationInfo.getFieldOfStudy().getFieldOfStudy());
		educationProgramAccreditationInformation.setFieldOfStudyCode(accreditationInfo.getFieldOfStudy().getFieldOfStudyCode());
		educationProgramAccreditationInformation.setSpecialty(accreditationInfo.getSpecialty().getSpecialty());
		educationProgramAccreditationInformation.setSpecialtyCode(accreditationInfo.getSpecialty().getSpecialtyCode());

		educationProgramAccreditationInformation.setSubdivisionName(String.valueOf(accreditationInfo.getSubdivision().getResponsibleDepartment()));
		educationProgramAccreditationInformation.setLanguages(accreditationInfo.getLanguages().stream()
			.map(language -> String.valueOf(language.getName())).toList());
		educationProgramAccreditationInformation.setOtherSubdivisions(accreditationInfo.getOtherSubdivisions().stream()
			.map(subdivision -> String.valueOf(subdivision.getResponsibleDepartment())).toList());

		//educationStatistic
		var educationStatistics = information.getEducationStatistics().stream()
			.map(SelfAssessmentInfoMapper.MAPPER::educationStatisticToDto)
			.sorted(Comparator.comparingInt(EducationStatisticDto::getStudyCourseYear))
			.toList();

		//higherEducationInstitutionArea
		var higherEducationInstitutionArea = SelfAssessmentInfoMapper.MAPPER.higherEducationInstitutionAreaToDto(information.getHigherEducationInstitutionArea());

		//higherEducationInstitutionInformation
		var higherEducationInstitutionInformation = new HigherEducationInstitutionInformationDto();

		var hei = SelfAssessmentInfoMapper.MAPPER.higherEducationalInstitutionToDto(information.getHigherEducationInstitutionInformation().getHei());
		hei.setHeadFullName(information.getHigherEducationInstitutionInformation().getHei().getHeadFullName().getUser().getName());
		var ssu = SelfAssessmentInfoMapper.MAPPER.separateStructuralUnitToDto(information.getHigherEducationInstitutionInformation().getSsu());
		if (ssu != null) {
			ssu.setHeadFullName(information.getHigherEducationInstitutionInformation().getSsu().getHeadFullName().getUser().getName());
		}

		higherEducationInstitutionInformation.setHei(hei);
		higherEducationInstitutionInformation.setSsu(ssu);

		//selfAssessmentEducationalProgramRestrictedInfo
		var restrictedInfo = SelfAssessmentInfoMapper.MAPPER
			.selfAssessmentEducationalProgramRestrictedInfoToDto(information.getSelfAssessmentEducationalProgramRestrictedInfo());

		//educationProgramDocuments
		var educationProgramDocuments = information.getEducationProgramDocuments().stream()
			.map(EducationProgramDocumentDto::fromEntity).toList();

		return builder()
			.educationProgramAccreditationInformation(educationProgramAccreditationInformation)
			.historyAndDevelopment(information.getEducationProgramGeneralInformation().getHistoryAndDevelopment())
			.educationStatistic(educationStatistics)
			.website(information.getHeiLinksInEdebo().getWebsite())
			.higherEducationInstitutionArea(higherEducationInstitutionArea)
			.higherEducationInstitutionInformation(higherEducationInstitutionInformation)
			.selfAssessmentEducationalProgramRestrictedInfo(restrictedInfo)
			.educationProgramDocuments(educationProgramDocuments)
			.build();
	}
}
