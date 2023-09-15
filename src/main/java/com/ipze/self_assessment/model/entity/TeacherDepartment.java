package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "\"Teacher_department\"", indexes = {
        @Index(name = "Teacher_department_teacher_id_structuralsub_6e690524_uniq", columnList = "teacher_id, structural_subdivision_id", unique = true),
        @Index(name = "Teacher_department_teacher_id_f4d2f436", columnList = "teacher_id"),
        @Index(name = "Teacher_department_structural_subdivision_id_7c546132", columnList = "structural_subdivision_id")
})
public class TeacherDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "structural_subdivision_id", nullable = false)
    private StructuralSubdivision structuralsubdivision;

}
