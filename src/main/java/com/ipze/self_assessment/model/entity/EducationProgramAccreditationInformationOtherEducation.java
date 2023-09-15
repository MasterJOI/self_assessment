package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "education_program_accreditation_information_other_education", indexes = {
        @Index(name = "education_program_accred_educationprogramaccredit_e5fec51d_uniq", columnList = "education_program_accreditation_information_id, structural_subdivision_id", unique = true),
        @Index(name = "education_program_accredit_educationprogramaccreditat_82eea96e", columnList = "education_program_accreditation_information_id"),
        @Index(name = "education_program_accredit_structural_subdivision_id_72819120", columnList = "structural_subdivision_id")
})
public class EducationProgramAccreditationInformationOtherEducation {
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
    @JoinColumn(name = "structural_subdivision_id", nullable = false)
    private StructuralSubdivision structuralsubdivision;

}
