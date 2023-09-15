package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "education_program_accreditation_information_language_of", indexes = {
        @Index(name = "education_program_accred_educationprogramaccredit_03820633_uniq", columnList = "education_program_accreditation_information_id, language_id", unique = true),
        @Index(name = "education_program_accredit_educationprogramaccreditat_77df1be5", columnList = "education_program_accreditation_information_id"),
        @Index(name = "education_program_accredit_language_id_07a75e84", columnList = "language_id")
})
public class EducationProgramAccreditationInformationLanguageOf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_program_accreditation_information_id", nullable = false)
    private EducationProgramAccreditationInformation educationProgramAccreditationInformation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

}
