package com.ipze.self_assessment.domains.speciality;

import com.ipze.self_assessment.model.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpecialityRepository extends JpaRepository<Specialty, UUID> {
}
