package com.ipze.self_assessment.domains.educationProgram;

import com.ipze.self_assessment.model.entity.EducationProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationProgramRepository extends JpaRepository<EducationProgram, UUID> {


}
