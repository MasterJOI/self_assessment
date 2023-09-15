package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"Teacher\"", indexes = {
        @Index(name = "Teacher_teacher_id_key", columnList = "teacher_id", unique = true),
        @Index(name = "Teacher_user_id_key", columnList = "user_id", unique = true),
        @Index(name = "Teacher_teacher_id_d3af3ce2_like", columnList = "teacher_id")
})
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Size(max = 15)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Size(max = 15)
    @NotNull
    @Column(name = "teacher_id", nullable = false, length = 15)
    private String teacherId;

    @NotNull
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherDepartment> teacherDepartments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "guaranteeFullName")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "headFullName")
    private Set<HigherEducationalInstitution> higherEducationalInstitutions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "headFullName")
    private Set<SeparateStructuralUnit> separateStructuralUnits = new LinkedHashSet<>();

    @OneToMany(mappedBy = "teacherFullName")
    private Set<TeacherSummaryInformation> teacherSummaryInformations = new LinkedHashSet<>();

}
