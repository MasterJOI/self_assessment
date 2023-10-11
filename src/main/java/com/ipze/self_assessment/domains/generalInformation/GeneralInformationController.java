package com.ipze.self_assessment.domains.generalInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/general")
public class GeneralInformationController {

	@Autowired
	private GeneralInformationService generalInformationService;
}
