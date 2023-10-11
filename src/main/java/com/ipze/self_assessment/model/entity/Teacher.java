package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher", indexes = {
        @Index(name = "teacher_teacher_id_key", columnList = "teacher_id", unique = true),
        @Index(name = "teacher_user_id_key", columnList = "user_id", unique = true),
        @Index(name = "teacher_teacher_id_d3af3ce2_like", columnList = "teacher_id")
})
public class Teacher extends BaseAuditableEntity {

    @Column(name = "birthdate")
    private Date birthdate;

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
    private Date hireDate;

	@Column(name = "teacher_qualification", columnDefinition = "TEXT")
	private String teacherQualification;

	@Column(name = "teacher_position")
	private String teacherPosition;

	@Column(name = "teacher_experience")
	private Integer teacherExperience;

	@Column(name = "rationale", columnDefinition = "TEXT")
	private String rationale;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "guaranteeFullName")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "headFullName")
    private Set<HigherEducationalInstitution> higherEducationalInstitutions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "headFullName")
    private Set<SeparateStructuralUnit> separateStructuralUnits = new LinkedHashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherSummaryInformation> teacherSummaryInformations = new LinkedHashSet<>();

	@ManyToOne
	@JoinColumn(name = "subdivision_id")
	private Subdivision subdivision;

}
