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
@Table(name = "structural_subdivision")
public class StructuralSubdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "responsible_department", nullable = false)
    private String responsibleDepartment;

    @OneToMany(mappedBy = "structuralsubdivision")
    private Set<TeacherDepartment> teacherDepartments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "structuralSubdivision")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "structuralsubdivision")
    private Set<EducationProgramAccreditationInformationOtherEducation> educationProgramAccreditationInformationOtherEducations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "structuralSubdivision")
    private Set<TeacherSummaryInformation> teacherSummaryInformations = new LinkedHashSet<>();

}
