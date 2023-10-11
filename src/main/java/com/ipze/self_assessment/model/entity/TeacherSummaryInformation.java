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
@Table(name = "teacher_summary_information", indexes = {
	@Index(name = "teacher_summary_information_teacher_id_6fd5f70f", columnList = "teacher_id")
})
public class TeacherSummaryInformation extends BaseAuditableEntity {

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;

	@ManyToMany(mappedBy = "teacherSummaryInformations")
	private Set<TableAnnex> tableAnnexes = new LinkedHashSet<>();

	@ManyToMany()
	@JoinTable(name = "teacher_summary_information_educational_components_informations",
		joinColumns = @JoinColumn(name = "teacherSummaryInformation_id"),
		inverseJoinColumns = @JoinColumn(name = "programEducationalComponentsInformations_id"))
	private Set<ProgramEducationalComponentsInformation> programEducationalComponentsInformations = new LinkedHashSet<>();
}
