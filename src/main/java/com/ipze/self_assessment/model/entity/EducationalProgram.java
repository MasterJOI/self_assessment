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
@Table(name = "educational_program")
public class EducationalProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "description")
    private String description;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "research_preparation")
    private String researchPreparation;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "teaching_preparation")
    private String teachingPreparation;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "supervisor_relevance")
    private String supervisorRelevance;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "research_support")
    private String researchSupport;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "international_participation")
    private String internationalParticipation;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "research_projects_supervisors_participation")
    private String researchProjectsSupervisorsParticipation;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "academic_integrity_practices")
    private String academicIntegrityPractices;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "academic_integrity_preventing_violations")
    private String academicIntegrityPreventingViolations;

    @OneToMany(mappedBy = "educationalProgram")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
