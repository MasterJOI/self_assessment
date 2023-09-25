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
@Table(name = "educational_transparency_and_publicity")
public class EducationalTransparencyAndPublicity extends BaseAuditableEntity {

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
