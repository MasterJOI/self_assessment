package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "educational_program_structure_n_content")
public class EducationalProgramStructureAndContent extends BaseAuditableEntity {

    @Column(name = "ep_credits_amount")
    private Integer epCreditsAmount;

    @Column(name = "components_credits_amount")
    private Short componentsCreditsAmount;

    @Column(name = "student_electives_credits_amount")
    private Short studentElectivesCreditsAmount;

	@Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "content_compliance", columnDefinition = "TEXT")
    private String contentCompliance;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "individual_learning_path", columnDefinition = "TEXT")
    private String individualLearningPath;

	@Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "student_choice_right", columnDefinition = "TEXT")
    private String studentChoiceRight;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "student_practical_training", columnDefinition = "TEXT")
    private String studentPracticalTraining;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "student_soft_skills", columnDefinition = "TEXT")
    private String studentSoftSkills;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "relevant_professional_standard", columnDefinition = "TEXT")
    private String relevantProfessionalStandard;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "components_scope_correlating_approach", columnDefinition = "TEXT")
    private String componentsScopeCorrelatingApproach;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "dual_form_education_structure", columnDefinition = "TEXT")
    private String dualFormEducationStructure;

    @OneToMany(mappedBy = "educationalProgramStructureAndContent")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
