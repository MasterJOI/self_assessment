package com.ipze.self_assessment.domains.user.repo;

import com.ipze.self_assessment.model.entity.InformationOnSelfAssessmentOfEducationalProgram;
import com.ipze.self_assessment.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

	@Query("select t from Teacher t where t.teacherId = :id")
	Optional<Teacher> getByTeacherId(String id);
}
