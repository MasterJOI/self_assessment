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
@Table(name = "hei_links_in_edebo")
public class HeiLinksInEdebo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 200)
    @NotNull
    @Column(name = "website", nullable = false, length = 200)
    private String website;

    @OneToMany(mappedBy = "heiLinksInEdebo")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
