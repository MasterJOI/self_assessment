package com.ipze.self_assessment.domains.language;

import com.ipze.self_assessment.domains.language.dto.LanguageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageService {

	private final LanguageRepository languageRepository;

	public List<LanguageDto> getLanguages() {
		return languageRepository.findAll().stream().map(LanguageDto::fromEntity).collect(Collectors.toList());
	}

}
