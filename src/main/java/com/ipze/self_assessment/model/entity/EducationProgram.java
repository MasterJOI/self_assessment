package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.enums.EducationLevel;
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

	@Size(max = 20)
	@NotNull
	@Column(name = "level", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private EducationLevel level;

    @OneToMany(mappedBy = "educationProgram")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();

	@ManyToMany(mappedBy = "otherEducationPrograms")
	private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
