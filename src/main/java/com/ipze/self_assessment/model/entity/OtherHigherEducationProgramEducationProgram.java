package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "other_higher_education_program_education_program", indexes = {
        @Index(name = "other_higher_education_p_otherhighereducationprog_59a91c0e_uniq", columnList = "otherhighereducationprogram_id, educationprogram_id", unique = true),
        @Index(name = "other_higher_education_pro_otherhighereducationprogra_a402e620", columnList = "otherhighereducationprogram_id"),
        @Index(name = "other_higher_education_pro_educationprogram_id_a4fd4b94", columnList = "educationprogram_id")
})
public class OtherHigherEducationProgramEducationProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "otherhighereducationprogram_id", nullable = false)
    private OtherHigherEducationProgram otherhighereducationprogram;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "educationprogram_id", nullable = false)
    private EducationProgram educationprogram;

}
