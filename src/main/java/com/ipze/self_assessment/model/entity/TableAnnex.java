package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "table_annex", indexes = {
        @Index(name = "table_annex_program_educational_compon_b4ce18d9", columnList = "program_educational_components_information_id"),
        @Index(name = "table_annex_teacher_summary_information_id_ab7699df", columnList = "teacher_summary_information_id")
})
public class TableAnnex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_educational_components_information_id", nullable = false)
    private ProgramEducationalComponentsInformation programEducationalComponentsInformation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_summary_information_id", nullable = false)
    private TeacherSummaryInformation teacherSummaryInformation;

    @OneToMany(mappedBy = "tablesAnnex")
    private Set<InformationOnSelfAssessmentOfEducationalProgram> informationOnSelfAssessmentOfEducationalPrograms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tablesannex")
    private Set<TableAnnexProgramLearningOutcomeCorrespondenceMatrix> tableAnnexProgramLearningOutcomeCorrespondenceMatrices = new LinkedHashSet<>();

}
