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
@Table(name = "higher_educational_institution", indexes = {
        @Index(name = "higher_educational_institution_head_full_name_id_308eb478", columnList = "head_full_name_id")
})
public class HigherEducationalInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "hei_id", nullable = false)
    private Long heiId;

    @Size(max = 250)
    @NotNull
    @Column(name = "higher_educational_institution_name", nullable = false, length = 250)
    private String higherEducationalInstitutionName;

    @NotNull
    @Column(name = "institution_code", nullable = false)
    private Long institutionCode;

    @Size(max = 200)
    @NotNull
    @Column(name = "website", nullable = false, length = 200)
    private String website;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "head_full_name_id", nullable = false)
    private Teacher headFullName;

    @OneToMany(mappedBy = "hei")
    private Set<HigherEducationInstitutionInformation> higherEducationInstitutionInformations = new LinkedHashSet<>();

}
