package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "information_on_self_assessment_of_educational_program", indexes = {
        @Index(name = "information_on_self_assess_general_information_id_0ae85ecf", columnList = "general_information_id"),
        @Index(name = "information_on_self_assess_general_question_answer_id_6feae976", columnList = "general_question_answer_id"),
        @Index(name = "information_on_self_assess_tables_annex_id_1b3c1ad5", columnList = "tables_annex_id")
})
public class InformationOnSelfAssessmentOfEducationalProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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
