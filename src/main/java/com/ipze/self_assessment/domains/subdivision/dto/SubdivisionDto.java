package com.ipze.self_assessment.domains.subdivision.dto;

import com.ipze.self_assessment.model.entity.Subdivision;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SubdivisionDto {

    String id;
    String name;

    public static SubdivisionDto fromEntity(Subdivision subdivision) {
        return SubdivisionDto.builder().id(subdivision.getId().toString()).name(subdivision.getResponsibleDepartment()).build();
    }

}
