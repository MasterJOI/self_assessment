package com.ipze.self_assessment.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "control_measures_and_academic_integrity")
public class ControlMeasuresAndAcademicIntegrity extends BaseAuditableEntity {

    @NotNull
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column(name = "clarity_criteria", nullable = false, columnDefinition = "TEXT")
    private String clarityCriteria;

    @NotNull
    @Column(name = "information_provision", nullable = false, columnDefinition = "TEXT")
    private String informationProvision;

    @NotNull
    @Column(name = "compliance_requirements", nullable = false, columnDefinition = "TEXT")
    private String complianceRequirements;

    @NotNull
    @Column(name = "accessibility_certification_procedure", nullable = false, columnDefinition = "TEXT")
    private String accessibilityCertificationProcedure;

    @NotNull
    @Column(name = "objectivity_procedures", nullable = false, columnDefinition = "TEXT")
    private String objectivityProcedures;

    @NotNull
    @Column(name = "repeating_control_measures_procedures", nullable = false, columnDefinition = "TEXT")
    private String repeatingControlMeasuresProcedures;

    @NotNull
    @Column(name = "appeal_procedure_and_results_of_control_measures", nullable = false, columnDefinition = "TEXT")
    private String appealProcedureAndResultsOfControlMeasures;

    @NotNull
    @Column(name = "policies_and_standards_documents", nullable = false, columnDefinition = "TEXT")
    private String policiesAndStandardsDocuments;

    @NotNull
    @Column(name = "combating_violations_of_academic_integrity_solutions", nullable = false, columnDefinition = "TEXT")
    private String combatingViolationsOfAcademicIntegritySolutions;

    @NotNull
    @Column(name = "promoting_academic_integrity", nullable = false, columnDefinition = "TEXT")
    private String promotingAcademicIntegrity;

    @NotNull
    @Column(name = "responding_to_violations_of_academic_integrity", nullable = false, columnDefinition = "TEXT")
    private String respondingToViolationsOfAcademicIntegrity;

    @OneToMany(mappedBy = "controlMeasuresAndAcademicIntegrity")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
