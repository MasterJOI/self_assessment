package com.ipze.self_assessment.domains.generalInformation;

import com.ipze.self_assessment.model.entity.GeneralInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeneralInformationRepository extends JpaRepository<GeneralInformation, UUID> {
}
