package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.enums.EducationProgramStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "information_on_self_assessment_of_educational_program", indexes = {
        @Index(name = "information_on_self_assess_general_information_id_0ae85ecf", columnList = "general_information_id"),
        @Index(name = "information_on_self_assess_general_question_answer_id_6feae976", columnList = "general_question_answer_id"),
        @Index(name = "information_on_self_assess_tables_annex_id_1b3c1ad5", columnList = "tables_annex_id")
})
public class InformationOnSelfAssessmentOfEducationalProgram extends BaseAuditableEntity {

	@Column(name = "deleted", nullable = false)
	private boolean deleted;

	@NotNull
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private EducationProgramStatus status = EducationProgramStatus.PROGRESS;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "general_information_id", nullable = false)
    private GeneralInformation generalInformation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "general_question_answer_id", nullable = false)
    private GeneralQuestionAnswer generalQuestionAnswer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tables_annex_id", nullable = false)
    private TableAnnex tablesAnnex;

}
