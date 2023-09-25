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
@Table(name = "educational_program_access")
public class EducationalProgramAccess extends BaseAuditableEntity {

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "admission_rules_link")
    private String admissionRulesLink;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "admission_requirements")
    private String admissionRequirements;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "recognition_of_education_results_accessibility")
    private String recognitionOfEducationResultsAccessibility;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "admission_requirements_applying_rules_practice")
    private String admissionRequirementsApplyingRulesPractice;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "recognition_of_education_results_doc")
    private String recognitionOfEducationResultsDoc;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "education_results_doc_applying_rules_practice")
    private String educationResultsDocApplyingRulesPractice;

    @OneToMany(mappedBy = "educationalProgramAccess")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
