package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "education_statistics")
public class EducationStatistic extends BaseAuditableEntity {

    @NotNull
    @Column(name = "study_course_year", nullable = false)
    private Integer studyCourseYear;

    @Size(max = 11)
    @NotNull
    @Column(name = "academic_year", nullable = false, length = 11)
    private String academicYear;

    @NotNull
    @Column(name = "enrollment", nullable = false)
    private Integer enrollment;

    @NotNull
    @Column(name = "full_time", nullable = false)
    private Integer fullTime;

    @NotNull
    @Column(name = "part_time", nullable = false)
    private Integer partTime;

    @NotNull
    @Column(name = "foreign_full_time", nullable = false)
    private Integer foreignFullTime;

    @NotNull
    @Column(name = "foreign_part_time", nullable = false)
    private Integer foreignPartTime;

    @OneToMany(mappedBy = "educationStatistics")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
