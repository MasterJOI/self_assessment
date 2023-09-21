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
@Table(name = "hei_links_in_edebo")
public class HeiLinksInEdebo extends BaseAuditableEntity {

    @Size(max = 200)
    @NotNull
    @Column(name = "website", nullable = false, length = 200)
    private String website;

    @OneToMany(mappedBy = "heiLinksInEdebo")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
