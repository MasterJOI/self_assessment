package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "self_assessment_educational_program_restricted_info")
public class SelfAssessmentEducationalProgramRestrictedInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "info_description", nullable = false, columnDefinition = "TEXT")
    private String infoDescription;

    @NotNull
    @Column(name = "info_access_restriction_type", nullable = false, columnDefinition = "TEXT")
    private String infoAccessRestrictionType;

    @NotNull
    @Column(name = "restricted_info_description", nullable = false, columnDefinition = "TEXT")
    private String restrictedInfoDescription;

    @NotNull
    @Column(name = "restricting_access_grounds", nullable = false, columnDefinition = "TEXT")
    private String restrictingAccessGrounds;

    @OneToMany(mappedBy = "selfAssessmentEducationalProgramRestrictedInfo")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
