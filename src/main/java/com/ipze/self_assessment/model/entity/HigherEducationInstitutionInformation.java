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
@Table(name = "higher_education_institution_information", indexes = {
        @Index(name = "higher_education_institution_information_hei_id_b8abf83f", columnList = "hei_id"),
        @Index(name = "higher_education_institution_information_ssu_id_c2d84df8", columnList = "ssu_id")
})
public class HigherEducationInstitutionInformation extends BaseAuditableEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hei_id", nullable = false)
    private HigherEducationalInstitution hei;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ssu_id")
    private SeparateStructuralUnit ssu;

    @OneToMany(mappedBy = "higherEducationInstitutionInformation")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
