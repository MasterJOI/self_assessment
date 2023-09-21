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
@Table(name = "program_learning_outcome_correspondence_matrix", indexes = {
        @Index(name = "program_learning_outcome_c_educational_component_id_0475d371", columnList = "educational_component_id")
})
public class ProgramLearningOutcomeCorrespondenceMatrix extends BaseAuditableEntity {

    @NotNull
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Size(max = 1000)
    @NotNull
    @Column(name = "teaching_method", nullable = false, length = 1000)
    private String teachingMethod;

    @Size(max = 200)
    @NotNull
    @Column(name = "assessment_form", nullable = false, length = 200)
    private String assessmentForm;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "educational_component_id", nullable = false)
    private ProgramEducationalComponentsInformation educationalComponent;

    @ManyToMany(mappedBy = "programLearningOutcomeCorrespondenceMatrixes")
    private Set<TableAnnex> tableAnnexes = new LinkedHashSet<>();

}
