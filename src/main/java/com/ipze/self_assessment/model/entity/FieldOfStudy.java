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
@Table(name = "field_of_study")
public class FieldOfStudy extends BaseAuditableEntity {

    @NotNull
    @Column(name = "field_of_study_code", nullable = false)
    private Integer fieldOfStudyCode;

    @Size(max = 250)
    @NotNull
    @Column(name = "field_of_study", nullable = false, length = 250)
    private String fieldOfStudy;

    @OneToMany(mappedBy = "fieldOfStudy")
    private Set<Specialty> specialties = new LinkedHashSet<>();

}
