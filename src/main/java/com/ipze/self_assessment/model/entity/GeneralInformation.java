package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "general_information", indexes = {
        @Index(name = "general_information_education_program_accredit_abab7da5", columnList = "education_program_accreditation_information_id"),
        @Index(name = "general_information_education_program_document_id_154f8daa", columnList = "education_program_document_id"),
        @Index(name = "general_information_education_program_general__fdcf62e6", columnList = "education_program_general_information_id"),
        @Index(name = "general_information_education_statistics_id_355f9606", columnList = "education_statistics_id"),
        @Index(name = "general_information_hei_links_in_edebo_id_86baa426", columnList = "hei_links_in_edebo_id"),
        @Index(name = "general_information_higher_education_instituti_35f8bd71", columnList = "higher_education_institution_area_id"),
        @Index(name = "general_information_higher_education_instituti_8a77b1fb", columnList = "higher_education_institution_information_id"),
        @Index(name = "general_information_other_higher_education_program_id_3d97e981", columnList = "other_higher_education_program_id"),
        @Index(name = "general_information_self_assessment_educationa_dbed7cf2", columnList = "self_assessment_educational_program_restricted_info_id")
})
public class GeneralInformation extends BaseAuditableEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_program_accreditation_information_id", nullable = false)
    private EducationProgramAccreditationInformation educationProgramAccreditationInformation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_program_document_id", nullable = false)
    private EducationProgramDocument educationProgramDocument;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_program_general_information_id", nullable = false)
    private EducationProgramGeneralInformation educationProgramGeneralInformation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_statistics_id", nullable = false)
    private EducationStatistic educationStatistics;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hei_links_in_edebo_id", nullable = false)
    private HeiLinksInEdebo heiLinksInEdebo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "higher_education_institution_area_id", nullable = false)
    private HigherEducationInstitutionArea higherEducationInstitutionArea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "higher_education_institution_information_id", nullable = false)
    private HigherEducationInstitutionInformation higherEducationInstitutionInformation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "other_higher_education_program_id", nullable = false)
    private OtherHigherEducationProgram otherHigherEducationProgram;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "self_assessment_educational_program_restricted_info_id", nullable = false)
    private SelfAssessmentEducationalProgramRestrictedInfo selfAssessmentEducationalProgramRestrictedInfo;

    @OneToMany(mappedBy = "generalInformation")
    private Set<InformationOnSelfAssessmentOfEducationalProgram> informationOnSelfAssessmentOfEducationalPrograms = new LinkedHashSet<>();

}
