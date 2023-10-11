package com.ipze.self_assessment.domains.generalInformation;

import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeneralInformationService {

	private final GeneralInformationRepository generalInformationRepository;
}
