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
@Table(name = "educational_transparency_and_publicity")
public class EducationalTransparencyAndPublicity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 1500)
    @NotNull
    @Column(name = "regulatory_documents", nullable = false, length = 1500)
    private String regulatoryDocuments;

    @Size(max = 200)
    @NotNull
    @Column(name = "stakeholder_feedback_link", nullable = false, length = 200)
    private String stakeholderFeedbackLink;

    @Size(max = 200)
    @NotNull
    @Column(name = "educational_program_link", nullable = false, length = 200)
    private String educationalProgramLink;

    @OneToMany(mappedBy = "educationalTransparencyAndPublicity")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
