package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "self_assessment_educational_program_restricted_info")
public class SelfAssessmentEducationalProgramRestrictedInfo extends BaseAuditableEntity {

	@Column(name = "info_description", columnDefinition = "TEXT")
	private String infoDescription;

	@Column(name = "info_access_restriction_type", columnDefinition = "TEXT")
	private String infoAccessRestrictionType;

	@Column(name = "restricted_info_description", columnDefinition = "TEXT")
	private String restrictedInfoDescription;

	@Column(name = "restricting_access_grounds", columnDefinition = "TEXT")
	private String restrictingAccessGrounds;

	@OneToMany(mappedBy = "selfAssessmentEducationalProgramRestrictedInfo")
	private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
