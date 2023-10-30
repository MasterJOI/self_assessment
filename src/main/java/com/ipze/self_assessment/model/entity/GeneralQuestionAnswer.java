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
@Table(name = "general_question_answer", indexes = {
        @Index(name = "general_question_answer_control_measures_and_acade_bd5cef5d", columnList = "control_measures_and_academic_integrity_id"),
        @Index(name = "general_question_answer_educational_environment_an_0c16cdc5", columnList = "educational_environment_and_material_resources_id"),
        @Index(name = "general_question_answer_educational_program_id_c4af4251", columnList = "educational_program_id"),
        @Index(name = "general_question_answer_educational_program_access_id_925b7575", columnList = "educational_program_access_id"),
        @Index(name = "general_question_answer_educational_program_design_id_857a65e3", columnList = "educational_program_design_id"),
        @Index(name = "general_question_answer_educational_program_develo_797ade6e", columnList = "educational_program_development_perspectives_id"),
        @Index(name = "general_question_answer_educational_program_learni_97f7172e", columnList = "educational_program_learning_and_teaching_id"),
        @Index(name = "general_question_answer_educational_program_struct_2f47bf23", columnList = "educational_program_structure_and_content_id"),
        @Index(name = "general_question_answer_educational_transparency_a_456511d4", columnList = "educational_transparency_and_publicity_id"),
        @Index(name = "general_question_answer_human_resources_id_151f132b", columnList = "human_resources_id"),
        @Index(name = "general_question_answer_quality_assurance_id_61cd8b08", columnList = "quality_assurance_id")
})
public class GeneralQuestionAnswer extends BaseAuditableEntity {

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "educational_program_design_id", nullable = false)
	private EducationProgramDesign educationalProgramDesign;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "educational_program_structure_and_content_id", nullable = false)
	private EducationalProgramStructureAndContent educationalProgramStructureAndContent;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "educational_program_access_id", nullable = false)
	private EducationalProgramAccess educationalProgramAccess;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "educational_program_learning_and_teaching_id", nullable = false)
	private EducationalProgramLearningAndTeaching educationalProgramLearningAndTeaching;

	@NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "control_measures_and_academic_integrity_id", nullable = false)
    private ControlMeasuresAndAcademicIntegrity controlMeasuresAndAcademicIntegrity;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "human_resources_id", nullable = false)
	private HumanResource humanResources;

	@NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "educational_environment_and_material_resources_id", nullable = false)
    private EducationalEnvironmentAndMaterialResource educationalEnvironmentAndMaterialResources;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "quality_assurance_id", nullable = false)
	private QualityAssurance qualityAssurance;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "educational_transparency_and_publicity_id", nullable = false)
	private EducationalTransparencyAndPublicity educationalTransparencyAndPublicity;

	@NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "educational_program_id", nullable = false)
    private EducationalProgram educationalProgram;

	@NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "educational_program_development_perspectives_id", nullable = false)
    private OpDevelopmentPerspective educationalProgramDevelopmentPerspectives;

    @OneToMany(mappedBy = "generalQuestionAnswer")
    private Set<InformationOnSelfAssessmentOfEducationalProgram> informationOnSelfAssessmentOfEducationalPrograms = new LinkedHashSet<>();

}
