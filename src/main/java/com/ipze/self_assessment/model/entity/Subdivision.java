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
@Table(name = "subdivision")
public class Subdivision extends BaseAuditableEntity {

    @Size(max = 255)
    @NotNull
    @Column(name = "responsible_department", nullable = false)
    private String responsibleDepartment;

    @OneToMany(mappedBy = "subdivision")
    private Set<EducationProgramAccreditationInformation> educationProgramAccreditationInformations = new LinkedHashSet<>();


    @ManyToMany(mappedBy = "otherSubdivisions")
    private Set<EducationProgramAccreditationInformation> otherEducationProgramAccreditationInformations = new LinkedHashSet<>();

	@OneToMany(mappedBy = "subdivision", orphanRemoval = true)
	private Set<Teacher> teachers = new LinkedHashSet<>();

}
