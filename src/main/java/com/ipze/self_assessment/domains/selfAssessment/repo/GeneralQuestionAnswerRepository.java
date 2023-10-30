package com.ipze.self_assessment.domains.selfAssessment.repo;

import com.ipze.self_assessment.model.entity.ControlMeasuresAndAcademicIntegrity;
import com.ipze.self_assessment.model.entity.GeneralQuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeneralQuestionAnswerRepository extends JpaRepository<GeneralQuestionAnswer, UUID> {
}
