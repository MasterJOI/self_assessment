package com.ipze.self_assessment.domains.selfAssessment;

import com.ipze.self_assessment.model.entity.EducationProgramAccreditationInformation;
import com.ipze.self_assessment.model.entity.GeneralInformation;
import com.ipze.self_assessment.model.entity.InformationOnSelfAssessmentOfEducationalProgram;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SelfAssessmentRepository extends JpaRepository<InformationOnSelfAssessmentOfEducationalProgram, UUID> {

	@Query("select s from InformationOnSelfAssessmentOfEducationalProgram s where s.deleted = false order by s.createdAt desc")
	List<InformationOnSelfAssessmentOfEducationalProgram> getAllSelfAssessmentInfo(Pageable pageable);
	@Query("select s from InformationOnSelfAssessmentOfEducationalProgram s where s.generalInformation.educationProgramAccreditationInformation.educationProgram.educationProgramId = :id")
	Optional<InformationOnSelfAssessmentOfEducationalProgram> getSelfAssessmentInfoByProgramId(Long id);

	@Query("select s from InformationOnSelfAssessmentOfEducationalProgram s where s.id = :id")
	InformationOnSelfAssessmentOfEducationalProgram getSelfAssessmentInfoById(UUID id);

}
