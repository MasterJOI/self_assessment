package com.ipze.self_assessment.domains.educationalComponent;

import com.ipze.self_assessment.model.entity.ProgramEducationalComponentsInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationalComponentRepository extends JpaRepository<ProgramEducationalComponentsInformation, UUID> {


}
