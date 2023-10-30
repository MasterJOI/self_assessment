package com.ipze.self_assessment.domains.hei.dto;

import com.ipze.self_assessment.model.entity.HigherEducationInstitutionInformation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeiDto {

	String id;
	String name;

	public static HeiDto fromEntity(HigherEducationInstitutionInformation information) {
		return HeiDto.builder()
			.id(information.getId().toString())
			.name(information.getHigherEducationalInstitutionName())
			.build();
	}

}
