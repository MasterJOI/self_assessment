package com.ipze.self_assessment.domains.subdivision;

import com.ipze.self_assessment.domains.subdivision.dto.SubdivisionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subdivision")
public class SubdivisionController {

    @Autowired
    private SubdivisionService subdivisionService;

    @GetMapping("/all")
    public List<SubdivisionDto> getSubdivisions() {
        return subdivisionService.getSubdivisions();
    }

}
