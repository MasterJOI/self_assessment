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
@Table(name = "specialty")
public class Specialty extends BaseAuditableEntity {

    @NotNull
    @Column(name = "specialty_code", nullable = false)
    private Integer specialtyCode;

    @Size(max = 250)
    @NotNull
    @Column(name = "specialty", nullable = false, length = 250)
    private String specialty;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "field_of_study_id", nullable = false)
	private FieldOfStudy fieldOfStudy;

	@OneToMany(mappedBy = "specialty")
	private Set<EducationProgram> educationPrograms = new LinkedHashSet<>();
}
