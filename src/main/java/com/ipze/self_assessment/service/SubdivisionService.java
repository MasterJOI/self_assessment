package com.ipze.self_assessment.service;

import com.ipze.self_assessment.model.dto.subdivision.SubdivisionDto;
import com.ipze.self_assessment.repo.SubdivisionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubdivisionService {

    private final SubdivisionRepository subdivisionRepository;

    public List<SubdivisionDto> getSubdivisions() {
        return subdivisionRepository.findAll().stream().map(SubdivisionDto::fromEntity).collect(Collectors.toList());
    }

}
