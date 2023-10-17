package com.ipze.self_assessment.domains.educationalComponent.dto;

import com.ipze.self_assessment.model.entity.ProgramEducationalComponentsInformation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgramEducationalComponentDto {
	private String id;
	private String componentName;
	private Integer componentType;
	private String documentName;
	private String documentPath;
	private String documentHash;
	private String specialEquipmentInfo;

	public static ProgramEducationalComponentDto fromEntity(ProgramEducationalComponentsInformation information) {
		return builder()
			.id(String.valueOf(information.getId()))
			.componentName(information.getComponentName())
			.componentType(information.getComponentType().ordinal())
			.documentName(information.getEducationProgramDocument().getName())
			.documentPath(information.getEducationProgramDocument().getPath())
			.documentHash(information.getEducationProgramDocument().getHash())
			.specialEquipmentInfo(information.getSpecialEquipmentInfo()).build();
	}
}
