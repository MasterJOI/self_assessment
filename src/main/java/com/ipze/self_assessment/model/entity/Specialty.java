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
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "specialty_code", nullable = false)
    private Integer specialtyCode;

    @Size(max = 250)
    @NotNull
    @Column(name = "specialty", nullable = false, length = 250)
    private String specialty;

    @OneToMany(mappedBy = "specialty")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();

}
