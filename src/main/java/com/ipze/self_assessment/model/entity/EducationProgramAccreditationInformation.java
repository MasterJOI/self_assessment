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
@Table(name = "education_program_accreditation_information", indexes = {
	@Index(name = "education_program_accredit_education_program_id_c213effa", columnList = "education_program_id"),
	@Index(name = "education_program_accredit_subdivision_id_18eebbfe", columnList = "subdivision_id")
})
public class EducationProgramAccreditationInformation extends BaseAuditableEntity {

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "education_program_id", nullable = false)
	private EducationProgram educationProgram;

	@Size(max = 255)
	@Column(name = "duration")
	private String duration;

	@Size(max = 255)
	@Column(name = "education_program_forms")
	private String educationProgramForms;

	@Size(max = 255)
	@Column(name = "location")
	private String location;

	@Column(name = "grants_professional_qualification")
	private Boolean grantsProfessionalQualification;

	@Size(max = 255)
	@Column(name = "professional_qualification")
	private String professionalQualification;

	@Size(max = 255)
	@Column(name = "partner_hei")
	private String partnerHei;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "guarantee_id", nullable = false)
	private Teacher guarantee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subdivision_id")
	private Subdivision subdivision;

	@Column(name = "history_and_development", columnDefinition = "TEXT")
	private String historyAndDevelopment;

	@ManyToMany
	@JoinTable(name = "education_program_accreditation_information_languages",
		joinColumns = @JoinColumn(name = "educationProgramAccreditationInformation_id"),
		inverseJoinColumns = @JoinColumn(name = "languages_id"))
	private Set<Language> languages = new LinkedHashSet<>();

	@ManyToMany
	@JoinTable(name = "education_program_accreditation_information_subdivisions",
		joinColumns = @JoinColumn(name = "educationProgramAccreditationInformation_id"),
		inverseJoinColumns = @JoinColumn(name = "subdivisions_id"))
	private Set<Subdivision> otherSubdivisions = new LinkedHashSet<>();

	@OneToMany(mappedBy = "educationProgramAccreditationInformation")
	private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
