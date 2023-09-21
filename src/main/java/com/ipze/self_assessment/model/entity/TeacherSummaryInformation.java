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
@Table(name = "teacher_summary_information", indexes = {
        @Index(name = "teacher_summary_information_subdivision_id_80909189", columnList = "subdivision_id"),
        @Index(name = "teacher_summary_information_teacher_full_name_id_6fd5f70f", columnList = "teacher_full_name_id")
})
public class TeacherSummaryInformation extends BaseAuditableEntity {

    @Size(max = 200)
    @NotNull
    @Column(name = "teacher_qualification", nullable = false, length = 200)
    private String teacherQualification;

    @NotNull
    @Column(name = "teacher_experience", nullable = false)
    private Integer teacherExperience;

    @NotNull
    @Column(name = "education_disciplines", nullable = false, columnDefinition = "TEXT")
    private String educationDisciplines;

    @NotNull
    @Column(name = "rationale", nullable = false, columnDefinition = "TEXT")
    private String rationale;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subdivision_id", nullable = false)
    private Subdivision subdivision;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_full_name_id", nullable = false)
    private Teacher teacherFullName;

    @OneToMany(mappedBy = "teacherSummaryInformation")
    private Set<TableAnnex> tableAnnexes = new LinkedHashSet<>();

}
