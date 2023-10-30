package com.ipze.self_assessment.domains.selfAssessment.repo;

import com.ipze.self_assessment.model.entity.EducationProgramDesign;
import com.ipze.self_assessment.model.entity.QualityAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QualityAssuranceRepository extends JpaRepository<QualityAssurance, UUID> {
}
