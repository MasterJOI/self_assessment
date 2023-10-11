package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.enums.DocumentType;
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
@Table(name = "education_program_document")
public class EducationProgramDocument extends BaseAuditableEntity {

	@NotNull
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private DocumentType type;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "path")
    private String path;

	@OneToMany(mappedBy = "educationProgramDocument")
	private Set<ProgramEducationalComponentsInformation> educationalComponentsInformations = new LinkedHashSet<>();

	@ManyToMany(mappedBy = "educationProgramDocuments")
	private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
