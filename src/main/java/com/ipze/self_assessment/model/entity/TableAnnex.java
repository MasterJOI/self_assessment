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
@Table(name = "table_annex", indexes = {
        @Index(name = "table_annex_program_educational_compon_b4ce18d9", columnList = "program_educational_components_information_id"),
        @Index(name = "table_annex_teacher_summary_information_id_ab7699df", columnList = "teacher_summary_information_id")
})
public class TableAnnex extends BaseAuditableEntity {

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

    @ManyToMany
    @JoinTable(name = "table_annex_programLearningOutcomeCorrespondenceMatrixes",
            joinColumns = @JoinColumn(name = "tableAnnex_id"),
            inverseJoinColumns = @JoinColumn(name = "programLearningOutcomeCorrespondenceMatrixes_id"))
    private Set<ProgramLearningOutcomeCorrespondenceMatrix> programLearningOutcomeCorrespondenceMatrixes = new LinkedHashSet<>();

}
