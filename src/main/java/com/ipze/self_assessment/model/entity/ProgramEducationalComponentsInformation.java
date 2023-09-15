package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "program_educational_components_information")
public class ProgramEducationalComponentsInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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
