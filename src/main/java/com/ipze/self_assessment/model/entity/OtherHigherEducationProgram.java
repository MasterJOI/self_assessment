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
@Table(name = "other_higher_education_program")
public class OtherHigherEducationProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 20)
    @NotNull
    @Column(name = "level", nullable = false, length = 20)
    private String level;

    @OneToMany(mappedBy = "otherHigherEducationProgram")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "otherhighereducationprogram")
    private Set<OtherHigherEducationProgramEducationProgram> otherHigherEducationProgramEducationPrograms = new LinkedHashSet<>();

}
