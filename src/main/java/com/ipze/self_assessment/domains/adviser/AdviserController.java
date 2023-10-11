package com.ipze.self_assessment.domains.adviser;

import com.ipze.self_assessment.domains.adviser.dto.AdviseDto;
import com.ipze.self_assessment.exceptions.custom.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/adviser")
public class AdviserController {

	@Autowired
	private AdviserService adviserService;

	@GetMapping("/advise")
	public AdviseDto getAdvise(@RequestParam("startWith") String startWith) throws IOException {
		var advice = adviserService.getAdvise(startWith);
		if (advice == null) {
			throw new NoSuchEntityException("Інформації про питання не знайдено!");
		}
		return advice;
	}

}
