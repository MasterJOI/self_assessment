package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "education_component_correspondence")
public class EducationComponentCorrespondence extends BaseAuditableEntity {

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

    @ManyToOne
    @JoinColumn(name = "study_result_id")
    private StudyResult studyResult;

}
