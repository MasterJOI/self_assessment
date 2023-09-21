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
@Table(name = "quality_assurance")
public class QualityAssurance extends BaseAuditableEntity {

    @NotNull
    @Column(name = "regulatory_document", nullable = false, columnDefinition = "TEXT")
    private String regulatoryDocument;

    @NotNull
    @Column(name = "education_program_review", nullable = false, columnDefinition = "TEXT")
    private String educationProgramReview;

    @NotNull
    @Column(name = "involvement_of_students", nullable = false, columnDefinition = "TEXT")
    private String involvementOfStudents;

    @NotNull
    @Column(name = "student_self_government", nullable = false, columnDefinition = "TEXT")
    private String studentSelfGovernment;

    @NotNull
    @Column(name = "involvement_of_employers", nullable = false, columnDefinition = "TEXT")
    private String involvementOfEmployers;

    @NotNull
    @Column(name = "alumni_employment", nullable = false, columnDefinition = "TEXT")
    private String alumniEmployment;

    @NotNull
    @Column(name = "quality_issues", nullable = false, columnDefinition = "TEXT")
    private String qualityIssues;

    @NotNull
    @Column(name = "educational_program_improvement", nullable = false, columnDefinition = "TEXT")
    private String educationalProgramImprovement;

    @NotNull
    @Column(name = "academic_community_members_engaging", nullable = false, columnDefinition = "TEXT")
    private String academicCommunityMembersEngaging;

    @NotNull
    @Column(name = "structural_units_responsibilities_distribution", nullable = false, columnDefinition = "TEXT")
    private String structuralUnitsResponsibilitiesDistribution;

    @OneToMany(mappedBy = "qualityAssurance")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
