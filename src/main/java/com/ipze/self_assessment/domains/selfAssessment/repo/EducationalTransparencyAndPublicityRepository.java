package com.ipze.self_assessment.domains.selfAssessment.repo;

import com.ipze.self_assessment.model.entity.EducationProgramDesign;
import com.ipze.self_assessment.model.entity.EducationalTransparencyAndPublicity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationalTransparencyAndPublicityRepository extends JpaRepository<EducationalTransparencyAndPublicity, UUID> {
}
