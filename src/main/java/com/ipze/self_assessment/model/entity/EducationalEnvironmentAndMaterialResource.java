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
@Table(name = "educational_environment_and_material_resources")
public class EducationalEnvironmentAndMaterialResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "financial_resources")
    private String financialResources;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "educational_environment")
    private String educationalEnvironment;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "safety_measures")
    private String safetyMeasures;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "support_services")
    private String supportServices;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "special_needs_people_education")
    private String specialNeedsPeopleEducation;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "policy_and_procedures_for_conflict_resolution")
    private String policyAndProceduresForConflictResolution;

    @OneToMany(mappedBy = "educationalEnvironmentAndMaterialResources")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
