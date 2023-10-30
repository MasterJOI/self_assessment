package com.ipze.self_assessment.domains.language.dto;

import com.ipze.self_assessment.model.entity.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LanguageDto {
	private String id;
	private String name;

	public static LanguageDto fromEntity(Language language) {
		return LanguageDto.builder()
			.id(language.getId().toString())
			.name(language.getName())
			.build();
	}
}
