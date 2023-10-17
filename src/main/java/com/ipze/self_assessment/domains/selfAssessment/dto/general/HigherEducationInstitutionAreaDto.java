package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HigherEducationInstitutionAreaDto {
	private Long allRooms;
	private Long ownRooms;
	private Long otherRightsRooms;
	private Long rentedRooms;
	private Long educationalAllRooms;
	private Long educationalOwnRooms;
	private Long educationalOtherRightsRooms;
	private Long educationalRentedRooms;
}
