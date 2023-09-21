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
@Table(name = "human_resources")
public class HumanResource extends BaseAuditableEntity {

    @NotNull
    @Column(name = "competency_level", nullable = false, columnDefinition = "TEXT")
    private String competencyLevel;

    @NotNull
    @Column(name = "employers_engagement", nullable = false, columnDefinition = "TEXT")
    private String employersEngagement;

    @NotNull
    @Column(name = "expert_involvement", nullable = false, columnDefinition = "TEXT")
    private String expertInvolvement;

    @NotNull
    @Column(name = "teacher_development", nullable = false, columnDefinition = "TEXT")
    private String teacherDevelopment;

    @NotNull
    @Column(name = "teaching_excellence", nullable = false, columnDefinition = "TEXT")
    private String teachingExcellence;

    @OneToMany(mappedBy = "humanResources")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
