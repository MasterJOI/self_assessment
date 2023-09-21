package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "educational_program_learning_and_teaching")
public class EducationalProgramLearningAndTeaching extends BaseAuditableEntity {

    @NotNull
    @Column(name = "learning_and_teaching_methods", nullable = false, columnDefinition = "TEXT")
    private String learningAndTeachingMethods;

    @NotNull
    @Column(name = "student_centered_approach", nullable = false, columnDefinition = "TEXT")
    private String studentCenteredApproach;

    @NotNull
    @Column(name = "academic_freedom", nullable = false, columnDefinition = "TEXT")
    private String academicFreedom;

    @NotNull
    @Column(name = "learning_outcomes", nullable = false, columnDefinition = "TEXT")
    private String learningOutcomes;

    @NotNull
    @Column(name = "learning_and_research", nullable = false, columnDefinition = "TEXT")
    private String learningAndResearch;

    @NotNull
    @Column(name = "curriculum_update", nullable = false, columnDefinition = "TEXT")
    private String curriculumUpdate;

    @NotNull
    @Column(name = "internationalization", nullable = false, columnDefinition = "TEXT")
    private String internationalization;

    @OneToMany(mappedBy = "educationalProgramLearningAndTeaching")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
