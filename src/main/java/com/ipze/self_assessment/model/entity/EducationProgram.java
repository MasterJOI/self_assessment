package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.enums.Cycle;
import com.ipze.self_assessment.model.enums.ProgramType;
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
@Table(name = "education_program")
public class EducationProgram extends BaseAuditableEntity {

    @NotNull
    @Column(name = "education_program_id", nullable = false)
    private Long educationProgramId;

	@Size(max = 250)
	@NotNull
	@Column(name = "name", nullable = false, length = 250)
	private String name;

	@Size(max = 250)
	@Column(name = "specialty_licensing_info", length = 250)
	private String specialtyLicensingInfo;

	@NotNull
	@Column(name = "cycle", nullable = false)
	@Enumerated(EnumType.STRING)
	private Cycle cycle;

	@Size(max = 250)
	@Column(name = "specialization", length = 250)
	private String specialization;

	@NotNull
	@Column(name = "program_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private ProgramType programType;

	@Size(max = 250)
	@Column(name = "admission_degree", length = 250)
	private String admissionDegree;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "specialty_id", nullable = false)
	private Specialty specialty;

    @OneToMany(mappedBy = "educationProgram")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();

	@ManyToMany(mappedBy = "otherEducationPrograms")
	private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
