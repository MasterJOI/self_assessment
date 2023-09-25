package com.ipze.self_assessment.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "description")
    private String description;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "clarity_criteria")
    private String clarityCriteria;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "information_provision")
    private String informationProvision;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "compliance_requirements")
    private String complianceRequirements;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "accessibility_certification_procedure")
    private String accessibilityCertificationProcedure;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "objectivity_procedures")
    private String objectivityProcedures;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "repeating_control_measures_procedures")
    private String repeatingControlMeasuresProcedures;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "appeal_procedure_and_results_of_control_measures")
    private String appealProcedureAndResultsOfControlMeasures;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "policies_and_standards_documents")
    private String policiesAndStandardsDocuments;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "combating_violations_of_academic_integrity_solutions")
    private String combatingViolationsOfAcademicIntegritySolutions;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "promoting_academic_integrity")
    private String promotingAcademicIntegrity;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "responding_to_violations_of_academic_integrity")
    private String respondingToViolationsOfAcademicIntegrity;

    @OneToMany(mappedBy = "controlMeasuresAndAcademicIntegrity")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
