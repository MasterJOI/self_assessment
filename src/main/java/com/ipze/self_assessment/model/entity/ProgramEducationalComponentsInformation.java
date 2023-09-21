package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "program_educational_components_information")
public class ProgramEducationalComponentsInformation extends BaseAuditableEntity {

    @Size(max = 255)
    @NotNull
    @Column(name = "component_name", nullable = false)
    private String componentName;

    @Size(max = 255)
    @NotNull
    @Column(name = "component_type", nullable = false)
    private String componentType;

    @Size(max = 255)
    @Column(name = "syllabus")
    private String syllabus;

    @NotNull
    @Column(name = "special_equipment_info", nullable = false, columnDefinition = "TEXT")
    private String specialEquipmentInfo;

    @OneToMany(mappedBy = "educationalComponent")
    private Set<ProgramLearningOutcomeCorrespondenceMatrix> programLearningOutcomeCorrespondenceMatrices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "programEducationalComponentsInformation")
    private Set<TableAnnex> tableAnnexes = new LinkedHashSet<>();

}
