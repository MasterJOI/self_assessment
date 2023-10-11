package com.ipze.self_assessment.domains.teacherInformation;

import com.ipze.self_assessment.model.entity.TeacherSummaryInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherInformationRepository extends JpaRepository<TeacherSummaryInformation, UUID> {
}
