package com.ipze.self_assessment.domains.educationProgramDocument;

import com.ipze.self_assessment.model.entity.EducationProgramDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationProgramDocumentRepository extends JpaRepository<EducationProgramDocument, UUID> {

}
