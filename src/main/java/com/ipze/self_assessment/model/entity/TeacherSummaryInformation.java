package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher_summary_information", indexes = {
        @Index(name = "teacher_summary_information_structural_subdivision_id_80909189", columnList = "structural_subdivision_id"),
        @Index(name = "teacher_summary_information_teacher_full_name_id_6fd5f70f", columnList = "teacher_full_name_id")
})
public class TeacherSummaryInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "teacher_qualification", nullable = false, columnDefinition = "TEXT")
    private String teacherQualification;

    @NotNull
    @Column(name = "teacher_experience", nullable = false)
    private Integer teacherExperience;

    @NotNull
    @Column(name = "rationale", nullable = false, columnDefinition = "TEXT")
    private String rationale;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "structural_subdivision_id", nullable = false)
    private StructuralSubdivision structuralSubdivision;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_full_name_id", nullable = false)
    private Teacher teacherFullName;


	@ManyToMany(mappedBy = "teacherSummaryInformations")
	private Set<TableAnnex> tableAnnexes = new LinkedHashSet<>();

	@ManyToMany
	@JoinTable(name = "teacher_summary_information_educational_components_informations",
		joinColumns = @JoinColumn(name = "teacherSummaryInformation_id"),
		inverseJoinColumns = @JoinColumn(name = "programEducationalComponentsInformations_id"))
	private Set<ProgramEducationalComponentsInformation> programEducationalComponentsInformations = new LinkedHashSet<>();

}
