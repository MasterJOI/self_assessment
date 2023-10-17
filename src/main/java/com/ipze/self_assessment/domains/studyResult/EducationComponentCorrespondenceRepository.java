package com.ipze.self_assessment.domains.studyResult;

import com.ipze.self_assessment.model.entity.EducationComponentCorrespondence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationComponentCorrespondenceRepository extends JpaRepository<EducationComponentCorrespondence, UUID> {
}
