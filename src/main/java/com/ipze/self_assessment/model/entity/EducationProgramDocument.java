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
@Table(name = "education_program_document")
public class EducationProgramDocument extends BaseAuditableEntity {

    @Size(max = 100)
    @NotNull
    @Column(name = "education_program_doc", nullable = false, length = 100)
    private String educationProgramDoc;

    @Size(max = 100)
    @NotNull
    @Column(name = "curriculum_doc", nullable = false, length = 100)
    private String curriculumDoc;

    @Size(max = 100)
    @Column(name = "reviews", length = 100)
    private String reviews;

    @OneToMany(mappedBy = "educationProgramDocument")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

}
