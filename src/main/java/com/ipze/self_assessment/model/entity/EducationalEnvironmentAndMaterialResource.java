package com.ipze.self_assessment.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "educational_environment_and_material_resources")
public class EducationalEnvironmentAndMaterialResource extends BaseAuditableEntity {

    @NotNull
    @Column(name = "financial_resources", nullable = false, columnDefinition = "TEXT")
    private String financialResources;

    @NotNull
    @Column(name = "educational_environment", nullable = false, columnDefinition = "TEXT")
    private String educationalEnvironment;

    @NotNull
    @Column(name = "safety_measures", nullable = false, columnDefinition = "TEXT")
    private String safetyMeasures;

    @NotNull
    @Column(name = "support_services", nullable = false, columnDefinition = "TEXT")
    private String supportServices;

    @NotNull
    @Column(name = "special_needs_people_education", nullable = false, columnDefinition = "TEXT")
    private String specialNeedsPeopleEducation;

    @NotNull
    @Column(name = "policy_and_procedures_for_conflict_resolution", nullable = false, columnDefinition = "TEXT")
    private String policyAndProceduresForConflictResolution;

    @OneToMany(mappedBy = "educationalEnvironmentAndMaterialResources")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
