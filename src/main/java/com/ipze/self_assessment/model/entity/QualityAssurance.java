package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "quality_assurance")
public class QualityAssurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "regulatory_document")
    private String regulatoryDocument;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "education_program_review")
    private String educationProgramReview;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "involvement_of_students")
    private String involvementOfStudents;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "student_self_government")
    private String studentSelfGovernment;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "involvement_of_employers")
    private String involvementOfEmployers;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "alumni_employment")
    private String alumniEmployment;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "quality_issues")
    private String qualityIssues;

    @Size(message = "Перевищено максимальну довжину поля.", max = 3000)
    @Column(name = "educational_program_improvement")
    private String educationalProgramImprovement;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "academic_community_members_engaging")
    private String academicCommunityMembersEngaging;

    @Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "structural_units_responsibilities_distribution")
    private String structuralUnitsResponsibilitiesDistribution;

    @OneToMany(mappedBy = "qualityAssurance")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
