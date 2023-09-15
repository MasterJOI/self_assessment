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
@Table(name = "separate_structural_unit", indexes = {
        @Index(name = "separate_structural_unit_head_full_name_id_491f206d", columnList = "head_full_name_id")
})
public class SeparateStructuralUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "ssu_id", nullable = false)
    private Long ssuId;

    @Size(max = 250)
    @NotNull
    @Column(name = "separate_structural_unit_name", nullable = false, length = 250)
    private String separateStructuralUnitName;

    @NotNull
    @Column(name = "ssu_code", nullable = false)
    private Long ssuCode;

    @Size(max = 200)
    @NotNull
    @Column(name = "website", nullable = false, length = 200)
    private String website;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "head_full_name_id", nullable = false)
    private Teacher headFullName;

    @OneToMany(mappedBy = "ssu")
    private Set<HigherEducationInstitutionInformation> higherEducationInstitutionInformations = new LinkedHashSet<>();

}
