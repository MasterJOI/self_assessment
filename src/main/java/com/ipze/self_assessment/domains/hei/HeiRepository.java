package com.ipze.self_assessment.domains.hei;

import com.ipze.self_assessment.model.entity.HigherEducationInstitutionInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HeiRepository extends JpaRepository<HigherEducationInstitutionInformation, UUID> {
}
