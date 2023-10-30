package com.ipze.self_assessment.domains.language;

import com.ipze.self_assessment.domains.language.dto.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@GetMapping("/all")
	public List<LanguageDto> getLanguages() {
		return languageService.getLanguages();
	}

}
