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
@Table(name = "education_program_general_information")
public class EducationProgramGeneralInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "history_and_development", nullable = false, columnDefinition = "TEXT")
    private String historyAndDevelopment;

    @OneToMany(mappedBy = "educationProgramGeneralInformation")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
