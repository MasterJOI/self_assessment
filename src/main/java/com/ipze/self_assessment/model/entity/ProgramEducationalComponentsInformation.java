package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.enums.EducationComponentType;
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
@Table(name = "program_educational_components_information")
public class ProgramEducationalComponentsInformation extends BaseAuditableEntity {

	@Column(name = "deleted", nullable = false)
	private boolean deleted;

	@Size(max = 255)
	@NotNull
	@Column(name = "component_name", nullable = false)
	private String componentName;

	@NotNull
	@Column(name = "component_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private EducationComponentType componentType;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "education_program_document_id", nullable = false)
	private EducationProgramDocument educationProgramDocument;

	@NotNull
	@Column(name = "special_equipment_info", nullable = false, columnDefinition = "TEXT")
	private String specialEquipmentInfo;

	@OneToMany(mappedBy = "educationalComponent")
	private Set<EducationComponentCorrespondence> correspondences = new LinkedHashSet<>();

	@ManyToMany(mappedBy = "programEducationalComponentsInformations")
	private Set<TableAnnex> tableAnnexes = new LinkedHashSet<>();

	@ManyToMany(mappedBy = "programEducationalComponentsInformations")
	private Set<TeacherSummaryInformation> teacherSummaryInformations = new LinkedHashSet<>();

}
