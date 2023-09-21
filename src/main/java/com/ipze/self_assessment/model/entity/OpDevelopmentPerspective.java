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
@Table(name = "op_development_perspectives")
public class OpDevelopmentPerspective extends BaseAuditableEntity {

    @NotNull
    @Column(name = "strong_weak_points", nullable = false, columnDefinition = "TEXT")
    private String strongWeakPoints;

    @NotNull
    @Column(name = "future_development", nullable = false, columnDefinition = "TEXT")
    private String futureDevelopment;

    @OneToMany(mappedBy = "educationalProgramDevelopmentPerspectives")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
