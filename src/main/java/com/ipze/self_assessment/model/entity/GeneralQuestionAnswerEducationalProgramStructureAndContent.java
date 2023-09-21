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
@Table(name = "general_question_answer_educational_program_structure_n_content")
public class GeneralQuestionAnswerEducationalProgramStructureAndContent extends BaseAuditableEntity {

    @NotNull
    @Column(name = "ep_credits_amount", nullable = false)
    private Integer epCreditsAmount;

    @NotNull
    @Column(name = "components_credits_amount", nullable = false)
    private Short componentsCreditsAmount;

    @NotNull
    @Column(name = "student_electives_credits_amount", nullable = false)
    private Short studentElectivesCreditsAmount;

    @NotNull
    @Column(name = "content_compliance", nullable = false, columnDefinition = "TEXT")
    private String contentCompliance;

    @NotNull
    @Column(name = "individual_learning_path", nullable = false, columnDefinition = "TEXT")
    private String individualLearningPath;

    @NotNull
    @Column(name = "student_choice_right", nullable = false, columnDefinition = "TEXT")
    private String studentChoiceRight;

    @NotNull
    @Column(name = "student_practical_training", nullable = false, columnDefinition = "TEXT")
    private String studentPracticalTraining;

    @NotNull
    @Column(name = "student_soft_skills", nullable = false, columnDefinition = "TEXT")
    private String studentSoftSkills;

    @NotNull
    @Column(name = "relevant_professional_standard", nullable = false, columnDefinition = "TEXT")
    private String relevantProfessionalStandard;

    @NotNull
    @Column(name = "components_scope_correlating_approach", nullable = false, columnDefinition = "TEXT")
    private String componentsScopeCorrelatingApproach;

    @NotNull
    @Column(name = "dual_form_education_structure", nullable = false, columnDefinition = "TEXT")
    private String dualFormEducationStructure;

    @OneToMany(mappedBy = "educationalProgramStructureAndContent")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
