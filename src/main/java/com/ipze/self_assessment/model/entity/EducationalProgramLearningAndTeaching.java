package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "educational_program_learning_and_teaching")
public class EducationalProgramLearningAndTeaching extends BaseAuditableEntity {

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@Column(name = "learning_and_teaching_methods")
	private String learningAndTeachingMethods;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@Column(name = "student_centered_approach")
	private String studentCenteredApproach;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@Column(name = "academic_freedom")
	private String academicFreedom;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@Column(name = "learning_outcomes")
	private String learningOutcomes;

	@Size(message = "Перевищено максимальну довжину поля.", max = 3000)
	@Column(name = "learning_and_research")
	private String learningAndResearch;

	@Size(message = "Перевищено максимальну довжину поля.", max = 3000)
	@Column(name = "curriculum_update")
	private String curriculumUpdate;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@Column(name = "internationalization")
	private String internationalization;

	@OneToMany(mappedBy = "educationalProgramLearningAndTeaching")
	private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
