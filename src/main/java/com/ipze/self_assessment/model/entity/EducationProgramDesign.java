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
@Table(name = "education_program_design")
public class EducationProgramDesign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "goals", nullable = false, columnDefinition = "TEXT")
    private String goals;

    @NotNull
    @Column(name = "uniqueness", nullable = false, columnDefinition = "TEXT")
    private String uniqueness;

    @NotNull
    @Column(name = "stakeholder_student", nullable = false, columnDefinition = "TEXT")
    private String stakeholderStudent;

    @NotNull
    @Column(name = "stakeholder_employer", nullable = false, columnDefinition = "TEXT")
    private String stakeholderEmployer;

    @NotNull
    @Column(name = "stakeholder_academic", nullable = false, columnDefinition = "TEXT")
    private String stakeholderAcademic;

    @NotNull
    @Column(name = "stakeholder_other", nullable = false, columnDefinition = "TEXT")
    private String stakeholderOther;

    @NotNull
    @Column(name = "market_trends", nullable = false, columnDefinition = "TEXT")
    private String marketTrends;

    @NotNull
    @Column(name = "industry_and_regional_context", nullable = false, columnDefinition = "TEXT")
    private String industryAndRegionalContext;

    @NotNull
    @Column(name = "domestic_and_foreign_programs_experience", nullable = false, columnDefinition = "TEXT")
    private String domesticAndForeignProgramsExperience;

    @NotNull
    @Column(name = "learning_experience_achieve", nullable = false, columnDefinition = "TEXT")
    private String learningExperienceAchieve;

    @NotNull
    @Column(name = "national_qualifications_level", nullable = false, columnDefinition = "TEXT")
    private String nationalQualificationsLevel;

    @OneToMany(mappedBy = "educationalProgramDesign")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
