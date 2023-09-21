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
@Table(name = "higher_education_institution_area")
public class HigherEducationInstitutionArea extends BaseAuditableEntity {

    @Size(max = 2)
    @NotNull
    @Column(name = "area_type", nullable = false, length = 2)
    private String areaType;

    @NotNull
    @Column(name = "all_rooms", nullable = false)
    private Long allRooms;

    @NotNull
    @Column(name = "own_rooms", nullable = false)
    private Long ownRooms;

    @NotNull
    @Column(name = "other_rights_rooms", nullable = false)
    private Long otherRightsRooms;

    @NotNull
    @Column(name = "rented_rooms", nullable = false)
    private Long rentedRooms;

    @OneToMany(mappedBy = "higherEducationInstitutionArea")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
