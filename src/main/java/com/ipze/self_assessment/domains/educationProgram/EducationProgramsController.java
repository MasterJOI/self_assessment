package com.ipze.self_assessment.domains.educationProgram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/programs")
public class EducationProgramsController {

	@Autowired
	private EducationProgramsService educationProgramsService;

}
