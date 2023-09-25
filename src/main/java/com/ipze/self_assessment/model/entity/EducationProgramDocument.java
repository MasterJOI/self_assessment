package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.dto.enums.DocumentType;
import com.ipze.self_assessment.model.dto.enums.EducationLevel;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "education_program_document")
public class EducationProgramDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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
