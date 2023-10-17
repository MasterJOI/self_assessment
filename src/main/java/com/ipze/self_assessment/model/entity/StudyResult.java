package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "study_result")
public class StudyResult extends BaseAuditableEntity {

	@NotNull
	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;

	@NotNull
	@Column(name = "is_corresponds", nullable = false)
	private Boolean isCorresponds;

	@ManyToMany(mappedBy = "studyResults")
	private Set<TableAnnex> tableAnnexes = new LinkedHashSet<>();

	@OneToMany(mappedBy = "studyResult", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EducationComponentCorrespondence> educationComponentCorrespondences = new LinkedHashSet<>();

	public void addItem(EducationComponentCorrespondence correspondence) {
		educationComponentCorrespondences.add(correspondence);
		correspondence.setStudyResult(this);
	}
}
