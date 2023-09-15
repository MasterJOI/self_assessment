package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "op_development_perspectives")
public class OpDevelopmentPerspective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "strong_weak_points", nullable = false, columnDefinition = "TEXT")
    private String strongWeakPoints;

    @NotNull
    @Column(name = "future_development", nullable = false, columnDefinition = "TEXT")
    private String futureDevelopment;

    @OneToMany(mappedBy = "educationalProgramDevelopmentPerspectives")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
