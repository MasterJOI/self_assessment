package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "human_resources")
public class HumanResource extends BaseAuditableEntity {

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "competency_level")
    private String competencyLevel;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "employers_engagement")
    private String employersEngagement;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "expert_involvement")
    private String expertInvolvement;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "teacher_development")
    private String teacherDevelopment;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "teaching_excellence")
    private String teachingExcellence;

    @OneToMany(mappedBy = "humanResources")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
