package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.enums.GrantsProfessionalQualification;
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
	@Index(name = "education_program_accredit_field_of_study_id_af2c4c0b", columnList = "field_of_study_id"),
	@Index(name = "education_program_accredit_guarantee_full_name_id_f721fbaf", columnList = "guarantee_full_name_id"),
	@Index(name = "education_program_accredit_specialty_id_9c56be99", columnList = "specialty_id"),
	@Index(name = "education_program_accredit_subdivision_id_18eebbfe", columnList = "subdivision_id")
})
public class EducationProgramAccreditationInformation extends BaseAuditableEntity {

	@Size(max = 250)
	@NotNull
	@Column(name = "specialty_licensing_info", nullable = false, length = 250)
	private String specialtyLicensingInfo;

	@Size(max = 250)
	@NotNull
	@Column(name = "cycle", nullable = false, length = 250)
	private String cycle;

	@Size(max = 250)
	@Column(name = "specialization", length = 250)
	private String specialization;

	@Size(max = 250)
	@NotNull
	@Column(name = "program_type", nullable = false, length = 250)
	private String programType;

	@Size(max = 250)
	@NotNull
	@Column(name = "admission_degree", nullable = false, length = 250)
	private String admissionDegree;

	@Size(max = 255)
	@NotNull
	@Column(name = "duration", nullable = false)
	private String duration;

	@Size(max = 255)
	@NotNull
	@Column(name = "education_program_forms", nullable = false)
	private String educationProgramForms;

	@Size(max = 255)
	@NotNull
	@Column(name = "location", nullable = false)
	private String location;

	@NotNull
	@Column(name = "grants_professional_qualification", nullable = false)
	@Enumerated(EnumType.STRING)
	private GrantsProfessionalQualification grantsProfessionalQualification;

	@Size(max = 255)
	@Column(name = "professional_qualification")
	private String professionalQualification;

	@NotNull
	@Column(name = "guarantee_id", nullable = false)
	private Long guaranteeId;

	@Size(max = 255)
	@NotNull
	@Column(name = "guarantee_position", nullable = false)
	private String guaranteePosition;

	@Size(max = 254)
	@NotNull
	@Column(name = "guarantee_email", nullable = false, length = 254)
	private String guaranteeEmail;

	@Size(max = 20)
	@NotNull
	@Column(name = "guarantee_phone", nullable = false, length = 20)
	private String guaranteePhone;

	@Size(max = 20)
	@Column(name = "additional_phone", length = 20)
	private String additionalPhone;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "education_program_id", nullable = false)
	private EducationProgram educationProgram;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "field_of_study_id", nullable = false)
	private FieldOfStudy fieldOfStudy;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "guarantee_full_name_id", nullable = false)
	private Teacher guaranteeFullName;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "specialty_id", nullable = false)
	private Specialty specialty;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "subdivision_id", nullable = false)
	private Subdivision subdivision;

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
