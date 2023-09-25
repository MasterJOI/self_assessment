package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "higher_education_institution_area")
public class HigherEducationInstitutionArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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
