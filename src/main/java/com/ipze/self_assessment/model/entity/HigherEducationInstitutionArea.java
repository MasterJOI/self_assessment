package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "higher_education_institution_area")
public class HigherEducationInstitutionArea extends BaseAuditableEntity {

	@NotNull
	@Column(name = "all_rooms", nullable = false)
	private Long allRooms;

	@NotNull
	@Column(name = "own_rooms", nullable = false)
	private Long ownRooms;

	@NotNull
	@Column(name = "other_rights_rooms", nullable = false)
	private Long otherRightsRooms;

	@NotNull
	@Column(name = "rented_rooms", nullable = false)
	private Long rentedRooms;

	@NotNull
	@Column(name = "educational_all_rooms", nullable = false)
	private Long educationalAllRooms;

	@NotNull
	@Column(name = "educational_own_rooms", nullable = false)
	private Long educationalOwnRooms;

	@NotNull
	@Column(name = "educational_other_rights_rooms", nullable = false)
	private Long educationalOtherRightsRooms;

	@NotNull
	@Column(name = "educational_rented_rooms", nullable = false)
	private Long educationalRentedRooms;

	@OneToMany(mappedBy = "higherEducationInstitutionArea")
	private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
