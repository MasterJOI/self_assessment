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
@Table(name = "education_program_document")
public class EducationProgramDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "education_program_doc", nullable = false, length = 100)
    private String educationProgramDoc;

    @Size(max = 100)
    @NotNull
    @Column(name = "curriculum_doc", nullable = false, length = 100)
    private String curriculumDoc;

    @Size(max = 100)
    @Column(name = "reviews", length = 100)
    private String reviews;

    @OneToMany(mappedBy = "educationProgramDocument")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
