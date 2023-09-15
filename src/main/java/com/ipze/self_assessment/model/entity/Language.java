package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 250)
    @NotNull
    @Column(name = "short_name", nullable = false, length = 250)
    private String shortName;

    @OneToMany(mappedBy = "language")
    private Set<EducationProgramAccreditationInformationLanguageOf> educationProgramAccreditationInformationLanguageOf = new LinkedHashSet<>();

}
