package com.ipze.self_assessment.domains.speciality.dto;

import com.ipze.self_assessment.model.entity.Specialty;
import com.ipze.self_assessment.model.entity.Subdivision;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecialityDto {

    String id;
    String name;
    Integer code;

    public static SpecialityDto fromEntity(Specialty specialty) {
        return SpecialityDto.builder()
			.id(specialty.getId().toString())
			.name(specialty.getSpecialty())
			.code(specialty.getSpecialtyCode())
			.build();
    }

}
