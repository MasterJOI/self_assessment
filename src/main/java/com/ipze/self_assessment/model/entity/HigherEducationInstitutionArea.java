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
@Table(name = "higher_education_institution_area")
public class HigherEducationInstitutionArea extends BaseAuditableEntity {

	@Column(name = "all_rooms")
	private Long allRooms;

	@Column(name = "own_rooms")
	private Long ownRooms;

	@Column(name = "other_rights_rooms")
	private Long otherRightsRooms;

	@Column(name = "rented_rooms")
	private Long rentedRooms;

	@Column(name = "educational_all_rooms")
	private Long educationalAllRooms;

	@Column(name = "educational_own_rooms")
	private Long educationalOwnRooms;

	@Column(name = "educational_other_rights_rooms")
	private Long educationalOtherRightsRooms;

	@Column(name = "educational_rented_rooms")
	private Long educationalRentedRooms;

	@OneToMany(mappedBy = "higherEducationInstitutionArea")
	private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
