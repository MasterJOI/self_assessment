package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.dto.enums.DocumentType;
import com.ipze.self_assessment.model.dto.enums.EducationLevel;
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
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "general_information_id", nullable = false)
	private GeneralInformation generalInformation;

	@NotNull
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private DocumentType type;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 100)
    @NotNull
    @Column(name = "content", nullable = false, length = 100)
    private String content;

    @Size(max = 100)
    @Column(name = "path", length = 100)
    private String path;

	@OneToMany(mappedBy = "educationProgramDocument")
	private Set<ProgramEducationalComponentsInformation> educationalComponentsInformations = new LinkedHashSet<>();
}
