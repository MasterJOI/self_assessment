package com.ipze.self_assessment.domains.speciality;

import com.ipze.self_assessment.domains.speciality.dto.SpecialityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/all")
    public List<SpecialityDto> getSpecialities() {
        return specialityService.getSpecialities();
    }

}
