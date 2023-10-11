package com.ipze.self_assessment.domains.subdivision;

import com.ipze.self_assessment.domains.subdivision.dto.SubdivisionDto;
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
