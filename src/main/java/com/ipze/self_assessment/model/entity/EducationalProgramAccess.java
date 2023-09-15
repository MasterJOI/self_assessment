package com.ipze.self_assessment.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "educational_program_access")
public class EducationalProgramAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 200)
    @NotNull
    @Column(name = "admission_rules_link", nullable = false, length = 200)
    private String admissionRulesLink;

    @NotNull
    @Column(name = "admission_requirements", nullable = false, columnDefinition = "TEXT")
    private String admissionRequirements;

    @NotNull
    @Column(name = "recognition_of_education_results_accessibility", nullable = false, columnDefinition = "TEXT")
    private String recognitionOfEducationResultsAccessibility;

    @NotNull
    @Column(name = "admission_requirements_applying_rules_practice", nullable = false, columnDefinition = "TEXT")
    private String admissionRequirementsApplyingRulesPractice;

    @NotNull
    @Column(name = "recognition_of_education_results_doc", nullable = false, columnDefinition = "TEXT")
    private String recognitionOfEducationResultsDoc;

    @NotNull
    @Column(name = "education_results_doc_applying_rules_practice", nullable = false, columnDefinition = "TEXT")
    private String educationResultsDocApplyingRulesPractice;

    @OneToMany(mappedBy = "educationalProgramAccess")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
