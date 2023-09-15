package com.ipze.self_assessment.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "educational_program")
public class EducationalProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column(name = "research_preparation", nullable = false, columnDefinition = "TEXT")
    private String researchPreparation;

    @NotNull
    @Column(name = "teaching_preparation", nullable = false, columnDefinition = "TEXT")
    private String teachingPreparation;

    @NotNull
    @Column(name = "supervisor_relevance", nullable = false, columnDefinition = "TEXT")
    private String supervisorRelevance;

    @NotNull
    @Column(name = "research_support", nullable = false, columnDefinition = "TEXT")
    private String researchSupport;

    @NotNull
    @Column(name = "international_participation", nullable = false, columnDefinition = "TEXT")
    private String internationalParticipation;

    @NotNull
    @Column(name = "research_projects_supervisors_participation", nullable = false, columnDefinition = "TEXT")
    private String researchProjectsSupervisorsParticipation;

    @NotNull
    @Column(name = "academic_integrity_practices", nullable = false, columnDefinition = "TEXT")
    private String academicIntegrityPractices;

    @NotNull
    @Column(name = "academic_integrity_preventing_violations", nullable = false, columnDefinition = "TEXT")
    private String academicIntegrityPreventingViolations;

    @OneToMany(mappedBy = "educationalProgram")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
