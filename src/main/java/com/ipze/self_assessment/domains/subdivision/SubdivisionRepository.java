package com.ipze.self_assessment.domains.subdivision;

import com.ipze.self_assessment.model.entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, UUID> {
}
