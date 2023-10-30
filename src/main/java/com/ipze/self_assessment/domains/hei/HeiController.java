package com.ipze.self_assessment.domains.hei;

import com.ipze.self_assessment.domains.hei.dto.HeiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hei")
public class HeiController {

	@Autowired
	private HeiService heiService;

	@GetMapping("/all")
	public List<HeiDto> getHeis() {
		return heiService.getHeis();
	}

}
