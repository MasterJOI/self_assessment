package com.ipze.self_assessment.model.entity;

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
@Table(name = "op_development_perspectives")
public class OpDevelopmentPerspective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "strong_weak_points")
    private String strongWeakPoints;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "future_development")
    private String futureDevelopment;

    @OneToMany(mappedBy = "educationalProgramDevelopmentPerspectives")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
