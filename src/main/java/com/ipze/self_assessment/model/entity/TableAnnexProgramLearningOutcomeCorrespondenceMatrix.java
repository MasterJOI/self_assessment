package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "table_annex_program_learning_outcome_correspondence_matrix", indexes = {
        @Index(name = "table_annex_program_lear_tablesannex_id_programle_33701012_uniq", columnList = "tablesannex_id, programlearningoutcomecorrespondencematrix_id", unique = true),
        @Index(name = "table_annex_program_learni_tablesannex_id_f344b8fc", columnList = "tablesannex_id"),
        @Index(name = "table_annex_program_learni_programlearningoutcomecorr_b3989622", columnList = "programlearningoutcomecorrespondencematrix_id")
})
public class TableAnnexProgramLearningOutcomeCorrespondenceMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tablesannex_id", nullable = false)
    private TableAnnex tablesannex;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "programlearningoutcomecorrespondencematrix_id", nullable = false)
    private ProgramLearningOutcomeCorrespondenceMatrix programlearningoutcomecorrespondencematrix;

}
