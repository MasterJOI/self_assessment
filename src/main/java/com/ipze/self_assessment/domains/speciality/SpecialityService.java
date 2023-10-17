package com.ipze.self_assessment.domains.speciality;

import com.ipze.self_assessment.domains.speciality.dto.SpecialityDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SpecialityService {

    private final SpecialityRepository specialityRepository;

    public List<SpecialityDto> getSpecialities() {
        return specialityRepository.findAll().stream().map(SpecialityDto::fromEntity).collect(Collectors.toList());
    }

}
