package com.ipze.self_assessment.domains.selfAssessment.dto.general;

import com.ipze.self_assessment.model.entity.EducationProgramDocument;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EducationProgramDocumentDto {
	private String id;
	private String type;
	private String name;
	private String path;
	private String hash;

	public static EducationProgramDocumentDto fromEntity(EducationProgramDocument document) {
		return builder()
			.id(document.getId().toString())
			.type(document.getType().getValue())
			.name(document.getName())
			.path(document.getPath())
			.hash(document.getHash())
			.build();
	}
}
