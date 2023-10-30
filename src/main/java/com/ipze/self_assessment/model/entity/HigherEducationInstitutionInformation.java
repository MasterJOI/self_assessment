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
@Table(name = "higher_education_institution_information")
public class HigherEducationInstitutionInformation extends BaseAuditableEntity {

	@NotNull
	@Column(name = "hei_id", nullable = false)
	private Long heiId;

	@Size(max = 250)
	@NotNull
	@Column(name = "higher_educational_institution_name", nullable = false, length = 250)
	private String higherEducationalInstitutionName;

	@NotNull
	@Column(name = "institution_code", nullable = false)
	private Long institutionCode;

	@Size(max = 200)
	@NotNull
	@Column(name = "website", nullable = false, length = 200)
	private String website;

	@NotNull
	@Column(name = "head_full_name", nullable = false)
	private String headFullName;

    @OneToMany(mappedBy = "higherEducationInstitutionInformation")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
