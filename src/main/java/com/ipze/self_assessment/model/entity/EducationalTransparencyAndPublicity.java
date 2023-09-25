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

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "regulatory_documents")
    private String regulatoryDocuments;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "stakeholder_feedback_link")
    private String stakeholderFeedbackLink;

	@Size(message = "Перевищено максимальну довжину поля.", max = 1600)
    @Column(name = "educational_program_link")
    private String educationalProgramLink;

    @OneToMany(mappedBy = "educationalTransparencyAndPublicity")
    private Set<GeneralQuestionAnswer> generalQuestionAnswers = new LinkedHashSet<>();

}
