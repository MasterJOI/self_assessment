package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "education_program_general_information")
public class EducationProgramGeneralInformation extends BaseAuditableEntity {

    @NotNull
    @Column(name = "history_and_development", nullable = false, columnDefinition = "TEXT")
    private String historyAndDevelopment;

    @OneToMany(mappedBy = "educationProgramGeneralInformation")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
