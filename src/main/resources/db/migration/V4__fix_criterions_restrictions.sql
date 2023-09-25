ALTER TABLE quality_assurance
	ALTER COLUMN academic_community_members_engaging TYPE VARCHAR(1500) USING (academic_community_members_engaging::VARCHAR(1500));

ALTER TABLE quality_assurance
	ALTER COLUMN academic_community_members_engaging DROP NOT NULL;

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN academic_freedom TYPE VARCHAR(1500) USING (academic_freedom::VARCHAR(1500));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN academic_freedom DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN academic_integrity_practices TYPE VARCHAR(1500) USING (academic_integrity_practices::VARCHAR(1500));

ALTER TABLE educational_program
	ALTER COLUMN academic_integrity_practices DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN academic_integrity_preventing_violations TYPE VARCHAR(1500) USING (academic_integrity_preventing_violations::VARCHAR(1500));

ALTER TABLE educational_program
	ALTER COLUMN academic_integrity_preventing_violations DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN accessibility_certification_procedure TYPE VARCHAR(1500) USING (accessibility_certification_procedure::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN accessibility_certification_procedure DROP NOT NULL;

ALTER TABLE educational_program_access
	ALTER COLUMN admission_requirements TYPE VARCHAR(1500) USING (admission_requirements::VARCHAR(1500));

ALTER TABLE educational_program_access
	ALTER COLUMN admission_requirements DROP NOT NULL;

ALTER TABLE educational_program_access
	ALTER COLUMN admission_requirements_applying_rules_practice TYPE VARCHAR(1500) USING (admission_requirements_applying_rules_practice::VARCHAR(1500));

ALTER TABLE educational_program_access
	ALTER COLUMN admission_requirements_applying_rules_practice DROP NOT NULL;

ALTER TABLE educational_program_access
	ALTER COLUMN admission_rules_link TYPE VARCHAR(1500) USING (admission_rules_link::VARCHAR(1500));

ALTER TABLE educational_program_access
	ALTER COLUMN admission_rules_link DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN alumni_employment TYPE VARCHAR(1500) USING (alumni_employment::VARCHAR(1500));

ALTER TABLE quality_assurance
	ALTER COLUMN alumni_employment DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN appeal_procedure_and_results_of_control_measures TYPE VARCHAR(1500) USING (appeal_procedure_and_results_of_control_measures::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN appeal_procedure_and_results_of_control_measures DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN clarity_criteria TYPE VARCHAR(1500) USING (clarity_criteria::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN clarity_criteria DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN combating_violations_of_academic_integrity_solutions TYPE VARCHAR(1500) USING (combating_violations_of_academic_integrity_solutions::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN combating_violations_of_academic_integrity_solutions DROP NOT NULL;

ALTER TABLE human_resources
	ALTER COLUMN competency_level TYPE VARCHAR(1500) USING (competency_level::VARCHAR(1500));

ALTER TABLE human_resources
	ALTER COLUMN competency_level DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN compliance_requirements TYPE VARCHAR(1500) USING (compliance_requirements::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN compliance_requirements DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN components_credits_amount DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN components_scope_correlating_approach DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN content_compliance DROP NOT NULL;

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN curriculum_update TYPE VARCHAR(3000) USING (curriculum_update::VARCHAR(3000));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN curriculum_update DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN description TYPE VARCHAR(3000) USING (description::VARCHAR(3000));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN description DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN description TYPE VARCHAR(1500) USING (description::VARCHAR(1500));

ALTER TABLE educational_program
	ALTER COLUMN description DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN domestic_and_foreign_programs_experience TYPE VARCHAR(1500) USING (domestic_and_foreign_programs_experience::VARCHAR(1500));

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN dual_form_education_structure DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN education_program_review TYPE VARCHAR(3000) USING (education_program_review::VARCHAR(3000));

ALTER TABLE quality_assurance
	ALTER COLUMN education_program_review DROP NOT NULL;

ALTER TABLE educational_program_access
	ALTER COLUMN education_results_doc_applying_rules_practice TYPE VARCHAR(1500) USING (education_results_doc_applying_rules_practice::VARCHAR(1500));

ALTER TABLE educational_program_access
	ALTER COLUMN education_results_doc_applying_rules_practice DROP NOT NULL;

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN educational_environment TYPE VARCHAR(1500) USING (educational_environment::VARCHAR(1500));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN educational_environment DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN educational_program_improvement TYPE VARCHAR(3000) USING (educational_program_improvement::VARCHAR(3000));

ALTER TABLE quality_assurance
	ALTER COLUMN educational_program_improvement DROP NOT NULL;

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN educational_program_link TYPE VARCHAR(1500) USING (educational_program_link::VARCHAR(1500));

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN educational_program_link DROP NOT NULL;

ALTER TABLE human_resources
	ALTER COLUMN employers_engagement TYPE VARCHAR(1500) USING (employers_engagement::VARCHAR(1500));

ALTER TABLE human_resources
	ALTER COLUMN employers_engagement DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN ep_credits_amount DROP NOT NULL;

ALTER TABLE human_resources
	ALTER COLUMN expert_involvement TYPE VARCHAR(1500) USING (expert_involvement::VARCHAR(1500));

ALTER TABLE human_resources
	ALTER COLUMN expert_involvement DROP NOT NULL;

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN financial_resources TYPE VARCHAR(1500) USING (financial_resources::VARCHAR(1500));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN financial_resources DROP NOT NULL;

ALTER TABLE op_development_perspectives
	ALTER COLUMN future_development TYPE VARCHAR(1500) USING (future_development::VARCHAR(1500));

ALTER TABLE op_development_perspectives
	ALTER COLUMN future_development DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN goals TYPE VARCHAR(1500) USING (goals::VARCHAR(1500));

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN individual_learning_path DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN industry_and_regional_context TYPE VARCHAR(1500) USING (industry_and_regional_context::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN information_provision TYPE VARCHAR(1500) USING (information_provision::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN information_provision DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN international_participation TYPE VARCHAR(1500) USING (international_participation::VARCHAR(1500));

ALTER TABLE educational_program
	ALTER COLUMN international_participation DROP NOT NULL;

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN internationalization TYPE VARCHAR(1500) USING (internationalization::VARCHAR(1500));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN internationalization DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN involvement_of_employers TYPE VARCHAR(1500) USING (involvement_of_employers::VARCHAR(1500));

ALTER TABLE quality_assurance
	ALTER COLUMN involvement_of_employers DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN involvement_of_students TYPE VARCHAR(1500) USING (involvement_of_students::VARCHAR(1500));

ALTER TABLE quality_assurance
	ALTER COLUMN involvement_of_students DROP NOT NULL;

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_and_research TYPE VARCHAR(3000) USING (learning_and_research::VARCHAR(3000));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_and_research DROP NOT NULL;

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_and_teaching_methods TYPE VARCHAR(1500) USING (learning_and_teaching_methods::VARCHAR(1500));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_and_teaching_methods DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN learning_experience_achieve TYPE VARCHAR(3000) USING (learning_experience_achieve::VARCHAR(3000));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_outcomes TYPE VARCHAR(1500) USING (learning_outcomes::VARCHAR(1500));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN learning_outcomes DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN market_trends TYPE VARCHAR(1500) USING (market_trends::VARCHAR(1500));

ALTER TABLE education_program_design
	ALTER COLUMN national_qualifications_level TYPE VARCHAR(3000) USING (national_qualifications_level::VARCHAR(3000));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN objectivity_procedures TYPE VARCHAR(1500) USING (objectivity_procedures::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN objectivity_procedures DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN policies_and_standards_documents TYPE VARCHAR(1500) USING (policies_and_standards_documents::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN policies_and_standards_documents DROP NOT NULL;

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN policy_and_procedures_for_conflict_resolution TYPE VARCHAR(3000) USING (policy_and_procedures_for_conflict_resolution::VARCHAR(3000));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN policy_and_procedures_for_conflict_resolution DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN promoting_academic_integrity TYPE VARCHAR(1500) USING (promoting_academic_integrity::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN promoting_academic_integrity DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN quality_issues TYPE VARCHAR(3000) USING (quality_issues::VARCHAR(3000));

ALTER TABLE quality_assurance
	ALTER COLUMN quality_issues DROP NOT NULL;

ALTER TABLE educational_program_access
	ALTER COLUMN recognition_of_education_results_accessibility TYPE VARCHAR(1500) USING (recognition_of_education_results_accessibility::VARCHAR(1500));

ALTER TABLE educational_program_access
	ALTER COLUMN recognition_of_education_results_accessibility DROP NOT NULL;

ALTER TABLE educational_program_access
	ALTER COLUMN recognition_of_education_results_doc TYPE VARCHAR(1500) USING (recognition_of_education_results_doc::VARCHAR(1500));

ALTER TABLE educational_program_access
	ALTER COLUMN recognition_of_education_results_doc DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN regulatory_document TYPE VARCHAR(1500) USING (regulatory_document::VARCHAR(1500));

ALTER TABLE quality_assurance
	ALTER COLUMN regulatory_document DROP NOT NULL;

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN regulatory_documents DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN relevant_professional_standard DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN repeating_control_measures_procedures TYPE VARCHAR(1500) USING (repeating_control_measures_procedures::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN repeating_control_measures_procedures DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN research_preparation TYPE VARCHAR(3000) USING (research_preparation::VARCHAR(3000));

ALTER TABLE educational_program
	ALTER COLUMN research_preparation DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN research_projects_supervisors_participation TYPE VARCHAR(1500) USING (research_projects_supervisors_participation::VARCHAR(1500));

ALTER TABLE educational_program
	ALTER COLUMN research_projects_supervisors_participation DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN research_support TYPE VARCHAR(1500) USING (research_support::VARCHAR(1500));

ALTER TABLE educational_program
	ALTER COLUMN research_support DROP NOT NULL;

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN responding_to_violations_of_academic_integrity TYPE VARCHAR(1500) USING (responding_to_violations_of_academic_integrity::VARCHAR(1500));

ALTER TABLE control_measures_and_academic_integrity
	ALTER COLUMN responding_to_violations_of_academic_integrity DROP NOT NULL;

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN safety_measures TYPE VARCHAR(1500) USING (safety_measures::VARCHAR(1500));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN safety_measures DROP NOT NULL;

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN special_needs_people_education TYPE VARCHAR(1500) USING (special_needs_people_education::VARCHAR(1500));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN special_needs_people_education DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_academic TYPE VARCHAR(1500) USING (stakeholder_academic::VARCHAR(1500));

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_employer TYPE VARCHAR(1500) USING (stakeholder_employer::VARCHAR(1500));

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN stakeholder_feedback_link TYPE VARCHAR(1500) USING (stakeholder_feedback_link::VARCHAR(1500));

ALTER TABLE educational_transparency_and_publicity
	ALTER COLUMN stakeholder_feedback_link DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_other TYPE VARCHAR(1500) USING (stakeholder_other::VARCHAR(1500));

ALTER TABLE education_program_design
	ALTER COLUMN stakeholder_student TYPE VARCHAR(1500) USING (stakeholder_student::VARCHAR(1500));

ALTER TABLE op_development_perspectives
	ALTER COLUMN strong_weak_points TYPE VARCHAR(3000) USING (strong_weak_points::VARCHAR(3000));

ALTER TABLE op_development_perspectives
	ALTER COLUMN strong_weak_points DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN structural_units_responsibilities_distribution TYPE VARCHAR(1500) USING (structural_units_responsibilities_distribution::VARCHAR(1500));

ALTER TABLE quality_assurance
	ALTER COLUMN structural_units_responsibilities_distribution DROP NOT NULL;

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN student_centered_approach TYPE VARCHAR(1500) USING (student_centered_approach::VARCHAR(1500));

ALTER TABLE educational_program_learning_and_teaching
	ALTER COLUMN student_centered_approach DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN student_choice_right DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN student_electives_credits_amount DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN student_practical_training DROP NOT NULL;

ALTER TABLE quality_assurance
	ALTER COLUMN student_self_government TYPE VARCHAR(1500) USING (student_self_government::VARCHAR(1500));

ALTER TABLE quality_assurance
	ALTER COLUMN student_self_government DROP NOT NULL;

ALTER TABLE general_question_answer_educational_program_structure_n_content
	ALTER COLUMN student_soft_skills DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN supervisor_relevance TYPE VARCHAR(1500) USING (supervisor_relevance::VARCHAR(1500));

ALTER TABLE educational_program
	ALTER COLUMN supervisor_relevance DROP NOT NULL;

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN support_services TYPE VARCHAR(3000) USING (support_services::VARCHAR(3000));

ALTER TABLE educational_environment_and_material_resources
	ALTER COLUMN support_services DROP NOT NULL;

ALTER TABLE human_resources
	ALTER COLUMN teacher_development TYPE VARCHAR(1500) USING (teacher_development::VARCHAR(1500));

ALTER TABLE human_resources
	ALTER COLUMN teacher_development DROP NOT NULL;

ALTER TABLE human_resources
	ALTER COLUMN teaching_excellence TYPE VARCHAR(1500) USING (teaching_excellence::VARCHAR(1500));

ALTER TABLE human_resources
	ALTER COLUMN teaching_excellence DROP NOT NULL;

ALTER TABLE educational_program
	ALTER COLUMN teaching_preparation TYPE VARCHAR(3000) USING (teaching_preparation::VARCHAR(3000));

ALTER TABLE educational_program
	ALTER COLUMN teaching_preparation DROP NOT NULL;

ALTER TABLE education_program_design
	ALTER COLUMN uniqueness TYPE VARCHAR(3000) USING (uniqueness::VARCHAR(3000));
