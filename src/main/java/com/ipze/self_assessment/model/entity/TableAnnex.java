package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "table_annex")
public class TableAnnex extends BaseAuditableEntity {

	@OneToMany(mappedBy = "tablesAnnex")
	private Set<InformationOnSelfAssessmentOfEducationalProgram> informationOnSelfAssessmentOfEducationalPrograms = new LinkedHashSet<>();

	@ManyToMany
	@JoinTable(name = "table_annex_programEducationalComponentsInformations",
		joinColumns = @JoinColumn(name = "tableAnnex_id"),
		inverseJoinColumns = @JoinColumn(name = "programEducationalComponentsInformations_id"))
	private Set<ProgramEducationalComponentsInformation> programEducationalComponentsInformations = new LinkedHashSet<>();

	@ManyToMany
	@JoinTable(name = "table_annex_study_result",
		joinColumns = @JoinColumn(name = "tableAnnex_id"),
		inverseJoinColumns = @JoinColumn(name = "study_result_id"))
	private Set<StudyResult> studyResults = new LinkedHashSet<>();

	@ManyToMany()
	@JoinTable(name = "table_annex_teacherSummaryInformations",
		joinColumns = @JoinColumn(name = "tableAnnex_id"),
		inverseJoinColumns = @JoinColumn(name = "teacherSummaryInformations_id"))
	private Set<TeacherSummaryInformation> teacherSummaryInformations = new LinkedHashSet<>();

}
