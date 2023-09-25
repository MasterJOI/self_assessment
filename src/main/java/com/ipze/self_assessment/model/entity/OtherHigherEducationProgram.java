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
@Table(name = "other_higher_education_program")
public class OtherHigherEducationProgram extends BaseAuditableEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "level", nullable = false, length = 20)
    private String level;

    @OneToMany(mappedBy = "otherHigherEducationProgram")
    private Set<GeneralInformation> generalInformations = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "other_higher_education_program_educationPrograms",
            joinColumns = @JoinColumn(name = "otherHigherEducationProgram_id"),
            inverseJoinColumns = @JoinColumn(name = "educationPrograms_id"))
    private Set<EducationProgram> educationPrograms = new LinkedHashSet<>();

}
