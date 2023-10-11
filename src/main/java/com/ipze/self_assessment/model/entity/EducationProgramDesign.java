package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "education_program_design")
public class EducationProgramDesign extends BaseAuditableEntity {

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "goals")
	private String goals;

	@Size(message = "Перевищено максимальну довжину поля.", max = 3000)
	@NotNull
	@Column(name = "uniqueness")
	private String uniqueness;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "stakeholder_student")
	private String stakeholderStudent;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "stakeholder_employer")
	private String stakeholderEmployer;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "stakeholder_academic")
	private String stakeholderAcademic;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "stakeholder_other")
	private String stakeholderOther;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "market_trends")
	private String marketTrends;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "industry_and_regional_context")
	private String industryAndRegionalContext;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
	@NotNull
	@Column(name = "domestic_and_foreign_programs_experience")
	private String domesticAndForeignProgramsExperience;

	@Size(message = "Перевищено максимальну довжину поля.", max = 3000)
	@NotNull
	@Column(name = "learning_experience_achieve")
	private String learningExperienceAchieve;

	@Size(message = "Перевищено максимальну довжину поля.", max = 3000)
	@NotNull
	@Column(name = "national_qualifications_level")
	private String nationalQualificationsLevel;

	@OneToMany(mappedBy = "educationalProgramDesign")
	private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();
}
