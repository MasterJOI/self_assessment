package com.ipze.self_assessment.domains.hei;

import com.ipze.self_assessment.domains.hei.dto.HeiDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HeiService {

	private final HeiRepository heiRepository;

	public List<HeiDto> getHeis() {
		return heiRepository.findAll().stream().map(HeiDto::fromEntity).collect(Collectors.toList());
	}

}
