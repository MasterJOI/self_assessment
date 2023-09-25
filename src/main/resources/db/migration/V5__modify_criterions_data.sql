ALTER TABLE quality_assurance
	ALTER COLUMN academic_community_members_engaging TYPE VARCHAR(1600) USING (academic_community_members_engaging::VARCHAR(1600));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN academic_freedom TYPE VARCHAR(1600) USING (academic_freedom::VARCHAR(1600));

ALTER TABLE educational_program
	ALTER COLUMN academic_integrity_practices TYPE VARCHAR(1600) USING (academic_integrity_practices::VARCHAR(1600));

ALTER TABLE educational_program
	ALTER COLUMN academic_integrity_preventing_violations TYPE VARCHAR(1600) USING (academic_integrity_preventing_violations::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN accessibility_certification_procedure TYPE VARCHAR(1600) USING (accessibility_certification_procedure::VARCHAR(1600));

ALTER TABLE educational_program_access
	ALTER COLUMN admission_requirements TYPE VARCHAR(1600) USING (admission_requirements::VARCHAR(1600));

ALTER TABLE educational_program_access
	ALTER COLUMN admission_requirements_applying_rules_practice TYPE VARCHAR(1600) USING (admission_requirements_applying_rules_practice::VARCHAR(1600));

ALTER TABLE educational_program_access
	ALTER COLUMN admission_rules_link TYPE VARCHAR(1600) USING (admission_rules_link::VARCHAR(1600));

ALTER TABLE quality_assurance
	ALTER COLUMN alumni_employment TYPE VARCHAR(1600) USING (alumni_employment::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN appeal_procedure_and_results_of_control_measures TYPE VARCHAR(1600) USING (appeal_procedure_and_results_of_control_measures::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN clarity_criteria TYPE VARCHAR(1600) USING (clarity_criteria::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN combating_violations_of_academic_integrity_solutions TYPE VARCHAR(1600) USING (combating_violations_of_academic_integrity_solutions::VARCHAR(1600));

ALTER TABLE human_resources
	ALTER COLUMN competency_level TYPE VARCHAR(1600) USING (competency_level::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN compliance_requirements TYPE VARCHAR(1600) USING (compliance_requirements::VARCHAR(1600));

ALTER TABLE educational_program
	ALTER COLUMN description TYPE VARCHAR(1600) USING (description::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN domestic_and_foreign_programs_experience TYPE VARCHAR(1600) USING (domestic_and_foreign_programs_experience::VARCHAR(1600));

ALTER TABLE educational_program_access
	ALTER COLUMN education_results_doc_applying_rules_practice TYPE VARCHAR(1600) USING (education_results_doc_applying_rules_practice::VARCHAR(1600));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN educational_environment TYPE VARCHAR(1600) USING (educational_environment::VARCHAR(1600));

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN educational_program_link TYPE VARCHAR(1600) USING (educational_program_link::VARCHAR(1600));

ALTER TABLE human_resources
	ALTER COLUMN employers_engagement TYPE VARCHAR(1600) USING (employers_engagement::VARCHAR(1600));

ALTER TABLE human_resources
	ALTER COLUMN expert_involvement TYPE VARCHAR(1600) USING (expert_involvement::VARCHAR(1600));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN financial_resources TYPE VARCHAR(1600) USING (financial_resources::VARCHAR(1600));

ALTER TABLE op_development_perspectives
	ALTER COLUMN future_development TYPE VARCHAR(1600) USING (future_development::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN goals TYPE VARCHAR(1600) USING (goals::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN industry_and_regional_context TYPE VARCHAR(1600) USING (industry_and_regional_context::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN information_provision TYPE VARCHAR(1600) USING (information_provision::VARCHAR(1600));

ALTER TABLE educational_program
	ALTER COLUMN international_participation TYPE VARCHAR(1600) USING (international_participation::VARCHAR(1600));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN internationalization TYPE VARCHAR(1600) USING (internationalization::VARCHAR(1600));

ALTER TABLE quality_assurance
	ALTER COLUMN involvement_of_employers TYPE VARCHAR(1600) USING (involvement_of_employers::VARCHAR(1600));

ALTER TABLE quality_assurance
	ALTER COLUMN involvement_of_students TYPE VARCHAR(1600) USING (involvement_of_students::VARCHAR(1600));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_and_teaching_methods TYPE VARCHAR(1600) USING (learning_and_teaching_methods::VARCHAR(1600));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_outcomes TYPE VARCHAR(1600) USING (learning_outcomes::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN market_trends TYPE VARCHAR(1600) USING (market_trends::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN objectivity_procedures TYPE VARCHAR(1600) USING (objectivity_procedures::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN policies_and_standards_documents TYPE VARCHAR(1600) USING (policies_and_standards_documents::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN promoting_academic_integrity TYPE VARCHAR(1600) USING (promoting_academic_integrity::VARCHAR(1600));

ALTER TABLE educational_program_access
	ALTER COLUMN recognition_of_education_results_accessibility TYPE VARCHAR(1600) USING (recognition_of_education_results_accessibility::VARCHAR(1600));

ALTER TABLE educational_program_access
	ALTER COLUMN recognition_of_education_results_doc TYPE VARCHAR(1600) USING (recognition_of_education_results_doc::VARCHAR(1600));

ALTER TABLE quality_assurance
	ALTER COLUMN regulatory_document TYPE VARCHAR(1600) USING (regulatory_document::VARCHAR(1600));

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN regulatory_documents TYPE VARCHAR(1600) USING (regulatory_documents::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN repeating_control_measures_procedures TYPE VARCHAR(1600) USING (repeating_control_measures_procedures::VARCHAR(1600));

ALTER TABLE educational_program
	ALTER COLUMN research_projects_supervisors_participation TYPE VARCHAR(1600) USING (research_projects_supervisors_participation::VARCHAR(1600));

ALTER TABLE educational_program
	ALTER COLUMN research_support TYPE VARCHAR(1600) USING (research_support::VARCHAR(1600));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN responding_to_violations_of_academic_integrity TYPE VARCHAR(1600) USING (responding_to_violations_of_academic_integrity::VARCHAR(1600));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN safety_measures TYPE VARCHAR(1600) USING (safety_measures::VARCHAR(1600));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN special_needs_people_education TYPE VARCHAR(1600) USING (special_needs_people_education::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_academic TYPE VARCHAR(1600) USING (stakeholder_academic::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_employer TYPE VARCHAR(1600) USING (stakeholder_employer::VARCHAR(1600));

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN stakeholder_feedback_link TYPE VARCHAR(1600) USING (stakeholder_feedback_link::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_other TYPE VARCHAR(1600) USING (stakeholder_other::VARCHAR(1600));

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_student TYPE VARCHAR(1600) USING (stakeholder_student::VARCHAR(1600));

ALTER TABLE quality_assurance
	ALTER COLUMN structural_units_responsibilities_distribution TYPE VARCHAR(1600) USING (structural_units_responsibilities_distribution::VARCHAR(1600));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN student_centered_approach TYPE VARCHAR(1600) USING (student_centered_approach::VARCHAR(1600));

ALTER TABLE quality_assurance
	ALTER COLUMN student_self_government TYPE VARCHAR(1600) USING (student_self_government::VARCHAR(1600));

ALTER TABLE educational_program
	ALTER COLUMN supervisor_relevance TYPE VARCHAR(1600) USING (supervisor_relevance::VARCHAR(1600));

ALTER TABLE human_resources
	ALTER COLUMN teacher_development TYPE VARCHAR(1600) USING (teacher_development::VARCHAR(1600));

ALTER TABLE human_resources
	ALTER COLUMN teaching_excellence TYPE VARCHAR(1600) USING (teaching_excellence::VARCHAR(1600));
