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
@Table(name = "field_of_study")
public class FieldOfStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "field_of_study_code", nullable = false)
    private Integer fieldOfStudyCode;

    @Size(max = 250)
    @NotNull
    @Column(name = "field_of_study", nullable = false, length = 250)
    private String fieldOfStudy;

    @OneToMany(mappedBy = "fieldOfStudy")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();

}
