
CREATE TABLE auth_group
(
    id         UUID                        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    name       VARCHAR(150)                NOT NULL,
    CONSTRAINT pk_auth_group PRIMARY KEY (id)
);

CREATE TABLE auth_group_auth_permissions
(
    auth_group_id       UUID NOT NULL,
    auth_permissions_id UUID NOT NULL,
    CONSTRAINT pk_auth_group_authpermissions PRIMARY KEY (auth_group_id, auth_permissions_id)
);

CREATE TABLE auth_permission
(
    id         UUID                        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    name       VARCHAR(255)                NOT NULL,
    codename   VARCHAR(100)                NOT NULL,
    CONSTRAINT pk_auth_permission PRIMARY KEY (id)
);

CREATE TABLE control_measures_and_academic_integrity
(
    id                                                   UUID                        NOT NULL,
    created_at                                           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                                           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    description                                          VARCHAR(3000),
    clarity_criteria                                     VARCHAR(1600),
    information_provision                                VARCHAR(1600),
    compliance_requirements                              VARCHAR(1600),
    accessibility_certification_procedure                VARCHAR(1600),
    objectivity_procedures                               VARCHAR(1600),
    repeating_control_measures_procedures                VARCHAR(1600),
    appeal_procedure_and_results_of_control_measures     VARCHAR(1600),
    policies_and_standards_documents                     VARCHAR(1600),
    combating_violations_of_academic_integrity_solutions VARCHAR(1600),
    promoting_academic_integrity                         VARCHAR(1600),
    responding_to_violations_of_academic_integrity       VARCHAR(1600),
    CONSTRAINT pk_control_measures_and_academic_integrity PRIMARY KEY (id)
);

CREATE TABLE education_component_correspondence
(
    id                       UUID                        NOT NULL,
    created_at               TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at               TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    teaching_method          VARCHAR(1000)               NOT NULL,
    assessment_form          VARCHAR(200)                NOT NULL,
    educational_component_id UUID                        NOT NULL,
    study_result_id          UUID,
    CONSTRAINT pk_education_component_correspondence PRIMARY KEY (id)
);

CREATE TABLE education_program
(
    id                       UUID                        NOT NULL,
    created_at               TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at               TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    education_program_id     BIGINT                      NOT NULL,
    name                     VARCHAR(250)                NOT NULL,
    specialty_licensing_info VARCHAR(250),
    cycle                    VARCHAR(250)                NOT NULL,
    specialization           VARCHAR(250),
    program_type             VARCHAR(250)                NOT NULL,
    admission_degree         VARCHAR(250),
    specialty_id             UUID                        NOT NULL,
    CONSTRAINT pk_education_program PRIMARY KEY (id)
);

CREATE TABLE education_program_accreditation_information
(
    id                                UUID                        NOT NULL,
    created_at                        TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                        TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    education_program_id              UUID                        NOT NULL,
    duration                          VARCHAR(255),
    education_program_forms           VARCHAR(255),
    location                          VARCHAR(255),
    grants_professional_qualification BOOLEAN,
    professional_qualification        VARCHAR(255),
    partner_hei                       VARCHAR(255),
    guarantee_id                      UUID                        NOT NULL,
    subdivision_id                    UUID,
    history_and_development           TEXT,
    CONSTRAINT pk_education_program_accreditation_information PRIMARY KEY (id)
);

CREATE TABLE education_program_accreditation_information_languages
(
    education_program_accreditation_information_id UUID NOT NULL,
    languages_id                                   UUID NOT NULL,
    CONSTRAINT pk_education_program_accreditation_information_languages PRIMARY KEY (education_program_accreditation_information_id, languages_id)
);

CREATE TABLE education_program_accreditation_information_subdivisions
(
    education_program_accreditation_information_id UUID NOT NULL,
    subdivisions_id                                UUID NOT NULL,
    CONSTRAINT pk_education_program_accreditation_information_subdivisions PRIMARY KEY (education_program_accreditation_information_id, subdivisions_id)
);

CREATE TABLE education_program_design
(
    id                                       UUID                        NOT NULL,
    created_at                               TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                               TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    goals                                    VARCHAR(1600),
    uniqueness                               VARCHAR(3000),
    stakeholder_student                      VARCHAR(1600),
    stakeholder_employer                     VARCHAR(1600),
    stakeholder_academic                     VARCHAR(1600),
    stakeholder_other                        VARCHAR(1600),
    market_trends                            VARCHAR(1600),
    industry_and_regional_context            VARCHAR(1600),
    domestic_and_foreign_programs_experience VARCHAR(1600),
    learning_experience_achieve              VARCHAR(3000),
    national_qualifications_level            VARCHAR(3000),
    CONSTRAINT pk_education_program_design PRIMARY KEY (id)
);

CREATE TABLE education_program_document
(
    id         UUID                        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    type       VARCHAR(255)                NOT NULL,
    name       VARCHAR(255)                NOT NULL,
    path       VARCHAR(255),
    hash       VARCHAR(255),
    CONSTRAINT pk_education_program_document PRIMARY KEY (id)
);

CREATE TABLE education_statistics
(
    id                     UUID                        NOT NULL,
    created_at             TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at             TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    general_information_id UUID                        NOT NULL,
    study_course_year      SMALLINT                    NOT NULL,
    academic_year          VARCHAR(11)                 NOT NULL,
    enrollment             INTEGER                     NOT NULL,
    full_time              INTEGER                     NOT NULL,
    evening                INTEGER                     NOT NULL,
    part_time              INTEGER                     NOT NULL,
    foreign_full_time      INTEGER                     NOT NULL,
    foreign_evening        INTEGER                     NOT NULL,
    foreign_part_time      INTEGER                     NOT NULL,
    CONSTRAINT pk_education_statistics PRIMARY KEY (id)
);

CREATE TABLE educational_environment_and_material_resources
(
    id                                            UUID                        NOT NULL,
    created_at                                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    financial_resources                           VARCHAR(1600),
    educational_environment                       VARCHAR(1600),
    safety_measures                               VARCHAR(1600),
    support_services                              VARCHAR(3000),
    special_needs_people_education                VARCHAR(1600),
    policy_and_procedures_for_conflict_resolution VARCHAR(3000),
    CONSTRAINT pk_educational_environment_and_material_resources PRIMARY KEY (id)
);

CREATE TABLE educational_program
(
    id                                          UUID                        NOT NULL,
    created_at                                  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                                  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    description                                 VARCHAR(1600),
    research_preparation                        VARCHAR(3000),
    teaching_preparation                        VARCHAR(3000),
    supervisor_relevance                        VARCHAR(1600),
    research_support                            VARCHAR(1600),
    international_participation                 VARCHAR(1600),
    research_projects_supervisors_participation VARCHAR(1600),
    academic_integrity_practices                VARCHAR(1600),
    academic_integrity_preventing_violations    VARCHAR(1600),
    CONSTRAINT pk_educational_program PRIMARY KEY (id)
);

CREATE TABLE educational_program_access
(
    id                                             UUID                        NOT NULL,
    created_at                                     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                                     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    admission_rules_link                           VARCHAR(1600),
    admission_requirements                         VARCHAR(1600),
    recognition_of_education_results_accessibility VARCHAR(1600),
    admission_requirements_applying_rules_practice VARCHAR(1600),
    recognition_of_education_results_doc           VARCHAR(1600),
    education_results_doc_applying_rules_practice  VARCHAR(1600),
    CONSTRAINT pk_educational_program_access PRIMARY KEY (id)
);

CREATE TABLE educational_program_learning_and_teaching
(
    id                            UUID                        NOT NULL,
    created_at                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    learning_and_teaching_methods VARCHAR(1600),
    student_centered_approach     VARCHAR(1600),
    academic_freedom              VARCHAR(1600),
    learning_outcomes             VARCHAR(1600),
    learning_and_research         VARCHAR(3000),
    curriculum_update             VARCHAR(3000),
    internationalization          VARCHAR(1600),
    CONSTRAINT pk_educational_program_learning_and_teaching PRIMARY KEY (id)
);

CREATE TABLE educational_program_structure_n_content
(
    id                                    UUID                        NOT NULL,
    created_at                            TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                            TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    ep_credits_amount                     INTEGER,
    components_credits_amount             SMALLINT,
    student_electives_credits_amount      SMALLINT,
    content_compliance                    TEXT,
    individual_learning_path              TEXT,
    student_choice_right                  TEXT,
    student_practical_training            TEXT,
    student_soft_skills                   TEXT,
    relevant_professional_standard        TEXT,
    components_scope_correlating_approach TEXT,
    dual_form_education_structure         TEXT,
    CONSTRAINT pk_educational_program_structure_n_content PRIMARY KEY (id)
);

CREATE TABLE educational_transparency_and_publicity
(
    id                        UUID                        NOT NULL,
    created_at                TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    regulatory_documents      VARCHAR(1600),
    stakeholder_feedback_link VARCHAR(1600),
    educational_program_link  VARCHAR(1600),
    CONSTRAINT pk_educational_transparency_and_publicity PRIMARY KEY (id)
);

CREATE TABLE field_of_study
(
    id                  UUID                        NOT NULL,
    created_at          TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at          TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    field_of_study_code INTEGER                     NOT NULL,
    field_of_study      VARCHAR(250)                NOT NULL,
    CONSTRAINT pk_field_of_study PRIMARY KEY (id)
);

CREATE TABLE general_information
(
    id                                                     UUID                        NOT NULL,
    created_at                                             TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                                             TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    education_program_accreditation_information_id         UUID                        NOT NULL,
    higher_education_institution_area_id                   UUID                        NOT NULL,
    higher_education_institution_information_id            UUID                        NOT NULL,
    self_assessment_educational_program_restricted_info_id UUID                        NOT NULL,
    CONSTRAINT pk_general_information PRIMARY KEY (id)
);

CREATE TABLE general_information_education_program_documents
(
    education_program_documents_id UUID NOT NULL,
    general_information_id         UUID NOT NULL,
    CONSTRAINT pk_general_information_educationprogramdocuments PRIMARY KEY (education_program_documents_id, general_information_id)
);

CREATE TABLE general_information_education_programs
(
    education_programs_id  UUID NOT NULL,
    general_information_id UUID NOT NULL,
    CONSTRAINT pk_general_information_educationprograms PRIMARY KEY (education_programs_id, general_information_id)
);

CREATE TABLE general_question_answer
(
    id                                                UUID                        NOT NULL,
    created_at                                        TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                                        TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    educational_program_design_id                     UUID                        NOT NULL,
    educational_program_structure_and_content_id      UUID                        NOT NULL,
    educational_program_access_id                     UUID                        NOT NULL,
    educational_program_learning_and_teaching_id      UUID                        NOT NULL,
    control_measures_and_academic_integrity_id        UUID                        NOT NULL,
    human_resources_id                                UUID                        NOT NULL,
    educational_environment_and_material_resources_id UUID                        NOT NULL,
    quality_assurance_id                              UUID                        NOT NULL,
    educational_transparency_and_publicity_id         UUID                        NOT NULL,
    educational_program_id                            UUID                        NOT NULL,
    educational_program_development_perspectives_id   UUID                        NOT NULL,
    CONSTRAINT pk_general_question_answer PRIMARY KEY (id)
);

CREATE TABLE higher_education_institution_area
(
    id                             UUID                        NOT NULL,
    created_at                     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    all_rooms                      BIGINT,
    own_rooms                      BIGINT,
    other_rights_rooms             BIGINT,
    rented_rooms                   BIGINT,
    educational_all_rooms          BIGINT,
    educational_own_rooms          BIGINT,
    educational_other_rights_rooms BIGINT,
    educational_rented_rooms       BIGINT,
    CONSTRAINT pk_higher_education_institution_area PRIMARY KEY (id)
);

CREATE TABLE higher_education_institution_information
(
    id                                  UUID                        NOT NULL,
    created_at                          TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                          TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    hei_id                              BIGINT                      NOT NULL,
    higher_educational_institution_name VARCHAR(250)                NOT NULL,
    institution_code                    BIGINT                      NOT NULL,
    website                             VARCHAR(200)                NOT NULL,
    head_full_name                      VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_higher_education_institution_information PRIMARY KEY (id)
);

CREATE TABLE human_resources
(
    id                   UUID                        NOT NULL,
    created_at           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    competency_level     VARCHAR(1600),
    employers_engagement VARCHAR(1600),
    expert_involvement   VARCHAR(1600),
    teacher_development  VARCHAR(1600),
    teaching_excellence  VARCHAR(1600),
    CONSTRAINT pk_human_resources PRIMARY KEY (id)
);

CREATE TABLE information_on_self_assessment_of_educational_program
(
    id                         UUID                        NOT NULL,
    created_at                 TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                 TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    deleted                    BOOLEAN                     NOT NULL DEFAULT FALSE,
    status                     VARCHAR(255)                NOT NULL DEFAULT 'PROGRESS',
    general_information_id     UUID                        NOT NULL,
    general_question_answer_id UUID                        NOT NULL,
    tables_annex_id            UUID                        NOT NULL,
    CONSTRAINT pk_information_on_self_assessment_of_educational_program PRIMARY KEY (id)
);

CREATE TABLE language
(
    id         UUID                        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    name       VARCHAR(50)                 NOT NULL,
    short_name VARCHAR(250)                NOT NULL,
    CONSTRAINT pk_language PRIMARY KEY (id)
);

CREATE TABLE op_development_perspectives
(
    id                 UUID                        NOT NULL,
    created_at         TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at         TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    strong_weak_points VARCHAR(3000),
    future_development VARCHAR(1600),
    CONSTRAINT pk_op_development_perspectives PRIMARY KEY (id)
);

CREATE TABLE program_educational_components_information
(
    id                            UUID                        NOT NULL,
    created_at                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    deleted                       BOOLEAN                     NOT NULL DEFAULT FALSE,
    component_name                VARCHAR(255)                NOT NULL,
    component_type                VARCHAR(255)                NOT NULL,
    education_program_document_id UUID                        NOT NULL,
    special_equipment_info        TEXT                        NOT NULL,
    CONSTRAINT pk_program_educational_components_information PRIMARY KEY (id)
);

CREATE TABLE quality_assurance
(
    id                                             UUID                        NOT NULL,
    created_at                                     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                                     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    regulatory_document                            VARCHAR(1600),
    education_program_review                       VARCHAR(3000),
    involvement_of_students                        VARCHAR(1600),
    student_self_government                        VARCHAR(1600),
    involvement_of_employers                       VARCHAR(1600),
    alumni_employment                              VARCHAR(1600),
    quality_issues                                 VARCHAR(3000),
    educational_program_improvement                VARCHAR(3000),
    academic_community_members_engaging            VARCHAR(1600),
    structural_units_responsibilities_distribution VARCHAR(1600),
    CONSTRAINT pk_quality_assurance PRIMARY KEY (id)
);

CREATE TABLE self_assessment_educational_program_restricted_info
(
    id                           UUID                        NOT NULL,
    created_at                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    info_description             TEXT,
    info_access_restriction_type TEXT,
    restricted_info_description  TEXT,
    restricting_access_grounds   TEXT,
    CONSTRAINT pk_self_assessment_educational_program_restricted_info PRIMARY KEY (id)
);

CREATE TABLE separate_structural_unit
(
    id                            UUID                        NOT NULL,
    created_at                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at                    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    ssu_id                        BIGINT                      NOT NULL,
    separate_structural_unit_name VARCHAR(250)                NOT NULL,
    ssu_code                      BIGINT                      NOT NULL,
    website                       VARCHAR(200)                NOT NULL,
    head_full_name_id             UUID                        NOT NULL,
    CONSTRAINT pk_separate_structural_unit PRIMARY KEY (id)
);

CREATE TABLE specialty
(
    id                UUID                        NOT NULL,
    created_at        TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at        TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    specialty_code    INTEGER                     NOT NULL,
    specialty         VARCHAR(250)                NOT NULL,
    field_of_study_id UUID                        NOT NULL,
    CONSTRAINT pk_specialty PRIMARY KEY (id)
);

CREATE TABLE student
(
    id              UUID                        NOT NULL,
    created_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    birthdate       TIMESTAMP WITHOUT TIME ZONE,
    phone_number    VARCHAR(20)                 NOT NULL,
    address         VARCHAR(255)                NOT NULL,
    student_id      VARCHAR(15)                 NOT NULL,
    enrollment_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    student_type    VARCHAR(255)                NOT NULL,
    user_id         UUID                        NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

CREATE TABLE study_result
(
    id             UUID                        NOT NULL,
    created_at     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    name           TEXT                        NOT NULL,
    is_corresponds BOOLEAN                     NOT NULL,
    CONSTRAINT pk_study_result PRIMARY KEY (id)
);

CREATE TABLE subdivision
(
    id                     UUID                        NOT NULL,
    created_at             TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at             TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    responsible_department VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_subdivision PRIMARY KEY (id)
);

CREATE TABLE table_annex
(
    id         UUID                        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    CONSTRAINT pk_table_annex PRIMARY KEY (id)
);

CREATE TABLE table_annex_program_educational_components_informations
(
    program_educational_components_informations_id UUID NOT NULL,
    table_annex_id                                 UUID NOT NULL,
    CONSTRAINT pk_table_annex_programeducationalcomponentsinformations PRIMARY KEY (program_educational_components_informations_id, table_annex_id)
);

CREATE TABLE table_annex_study_result
(
    study_result_id UUID NOT NULL,
    table_annex_id  UUID NOT NULL,
    CONSTRAINT pk_table_annex_study_result PRIMARY KEY (study_result_id, table_annex_id)
);

CREATE TABLE table_annex_teacher_summary_informations
(
    table_annex_id                  UUID NOT NULL,
    teacher_summary_informations_id UUID NOT NULL,
    CONSTRAINT pk_table_annex_teachersummaryinformations PRIMARY KEY (table_annex_id, teacher_summary_informations_id)
);

CREATE TABLE teacher
(
    id                      UUID                        NOT NULL,
    created_at              TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at              TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    birthdate               TIMESTAMP WITHOUT TIME ZONE,
    phone_number            VARCHAR(20)                 NOT NULL,
    additional_phone_number VARCHAR(20),
    corporate_email         VARCHAR(254),
    address                 VARCHAR(255)                NOT NULL,
    teacher_id              VARCHAR(15)                 NOT NULL,
    hire_date               TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    teacher_qualification   TEXT,
    teacher_position        VARCHAR(255),
    teacher_experience      INTEGER,
    rationale               TEXT,
    user_id                 UUID                        NOT NULL,
    subdivision_id          UUID,
    CONSTRAINT pk_teacher PRIMARY KEY (id)
);

CREATE TABLE teacher_summary_information
(
    id         UUID                        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    teacher_id UUID                        NOT NULL,
    CONSTRAINT pk_teacher_summary_information PRIMARY KEY (id)
);

CREATE TABLE teacher_summary_information_educational_components_informations
(
    program_educational_components_informations_id UUID NOT NULL,
    teacher_summary_information_id                 UUID NOT NULL,
    CONSTRAINT pk_teachersummaryinformationeducationalcomponentsinformations PRIMARY KEY (program_educational_components_informations_id,
                                                                                          teacher_summary_information_id)
);

CREATE TABLE public."user"
(
    id           UUID                        NOT NULL,
    created_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    password     VARCHAR(128)                NOT NULL,
    last_login   TIMESTAMP WITHOUT TIME ZONE,
    is_superuser BOOLEAN                     NOT NULL,
    username     VARCHAR(150)                NOT NULL,
    email        VARCHAR(254)                NOT NULL,
    is_staff     BOOLEAN                     NOT NULL,
    is_active    BOOLEAN                     NOT NULL,
    name         VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE public.user_auth_groups
(
    auth_groups_id UUID NOT NULL,
    user_id        UUID NOT NULL,
    CONSTRAINT pk_user_authgroups PRIMARY KEY (auth_groups_id, user_id)
);

CREATE TABLE public.user_auth_permissions
(
    auth_permissions_id UUID NOT NULL,
    user_id             UUID NOT NULL,
    CONSTRAINT pk_user_authpermissions PRIMARY KEY (auth_permissions_id, user_id)
);

CREATE UNIQUE INDEX auth_group_name_key ON auth_group (name);

CREATE UNIQUE INDEX auth_permission_codename_01ab375a_uniq ON auth_permission (codename);

CREATE UNIQUE INDEX student_student_id_key ON student (student_id);

CREATE UNIQUE INDEX teacher_teacher_id_key ON teacher (teacher_id);

CREATE INDEX user_username_06e46fe6_like ON public."user" (username);

ALTER TABLE education_program_accreditation_information
    ADD CONSTRAINT FK_EDUCATIONPROGRAMACCREDITATIONINFORMATION_ON_EDUCATIONPROGRAM FOREIGN KEY (education_program_id) REFERENCES education_program (id);

CREATE INDEX education_program_accredit_education_program_id_c213effa ON education_program_accreditation_information (education_program_id);

ALTER TABLE education_component_correspondence
    ADD CONSTRAINT FK_EDUCATION_COMPONENT_CORRESPONDENCE_ON_EDUCATIONAL_COMPONENT FOREIGN KEY (educational_component_id) REFERENCES program_educational_components_information (id);

ALTER TABLE education_component_correspondence
    ADD CONSTRAINT FK_EDUCATION_COMPONENT_CORRESPONDENCE_ON_STUDY_RESULT FOREIGN KEY (study_result_id) REFERENCES study_result (id);

ALTER TABLE education_program_accreditation_information
    ADD CONSTRAINT FK_EDUCATION_PROGRAM_ACCREDITATION_INFORMATION_ON_GUARANTEE FOREIGN KEY (guarantee_id) REFERENCES teacher (id);

ALTER TABLE education_program_accreditation_information
    ADD CONSTRAINT FK_EDUCATION_PROGRAM_ACCREDITATION_INFORMATION_ON_SUBDIVISION FOREIGN KEY (subdivision_id) REFERENCES subdivision (id);

CREATE INDEX education_program_accredit_subdivision_id_18eebbfe ON education_program_accreditation_information (subdivision_id);

ALTER TABLE education_program
    ADD CONSTRAINT FK_EDUCATION_PROGRAM_ON_SPECIALTY FOREIGN KEY (specialty_id) REFERENCES specialty (id);

ALTER TABLE education_statistics
    ADD CONSTRAINT FK_EDUCATION_STATISTICS_ON_GENERAL_INFORMATION FOREIGN KEY (general_information_id) REFERENCES general_information (id);

ALTER TABLE general_information
    ADD CONSTRAINT FK_GENERALINFORMATION_ON_EDUCATIONPROGRAMACCREDITATIONINFORMATI FOREIGN KEY (education_program_accreditation_information_id) REFERENCES education_program_accreditation_information (id);

CREATE INDEX general_information_education_program_accredit_abab7da5 ON general_information (education_program_accreditation_information_id);

ALTER TABLE general_information
    ADD CONSTRAINT FK_GENERALINFORMATION_ON_HIGHEREDUCATIONINSTITUTIONINFORMATION FOREIGN KEY (higher_education_institution_information_id) REFERENCES higher_education_institution_information (id);

CREATE INDEX general_information_higher_education_instituti_8a77b1fb ON general_information (higher_education_institution_information_id);

ALTER TABLE general_information
    ADD CONSTRAINT FK_GENERALINFORMATION_ON_SELFASSESSMENTEDUCATIONALPROGRAMRESTRI FOREIGN KEY (self_assessment_educational_program_restricted_info_id) REFERENCES self_assessment_educational_program_restricted_info (id);

CREATE INDEX general_information_self_assessment_educationa_dbed7cf2 ON general_information (self_assessment_educational_program_restricted_info_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERALQUESTIONANSWER_ON_CONTROLMEASURESANDACADEMICINTEGRITY FOREIGN KEY (control_measures_and_academic_integrity_id) REFERENCES control_measures_and_academic_integrity (id);

CREATE INDEX general_question_answer_control_measures_and_acade_bd5cef5d ON general_question_answer (control_measures_and_academic_integrity_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERALQUESTIONANSWER_ON_EDUCATIONALENVIRONMENTANDMATERIALRE FOREIGN KEY (educational_environment_and_material_resources_id) REFERENCES educational_environment_and_material_resources (id);

CREATE INDEX general_question_answer_educational_environment_an_0c16cdc5 ON general_question_answer (educational_environment_and_material_resources_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERALQUESTIONANSWER_ON_EDUCATIONALPROGRAMDEVELOPMENTPERSPE FOREIGN KEY (educational_program_development_perspectives_id) REFERENCES op_development_perspectives (id);

CREATE INDEX general_question_answer_educational_program_develo_797ade6e ON general_question_answer (educational_program_development_perspectives_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERALQUESTIONANSWER_ON_EDUCATIONALPROGRAMLEARNINGANDTEACHI FOREIGN KEY (educational_program_learning_and_teaching_id) REFERENCES educational_program_learning_and_teaching (id);

CREATE INDEX general_question_answer_educational_program_learni_97f7172e ON general_question_answer (educational_program_learning_and_teaching_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERALQUESTIONANSWER_ON_EDUCATIONALPROGRAMSTRUCTUREANDCONTE FOREIGN KEY (educational_program_structure_and_content_id) REFERENCES educational_program_structure_n_content (id);

CREATE INDEX general_question_answer_educational_program_struct_2f47bf23 ON general_question_answer (educational_program_structure_and_content_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERALQUESTIONANSWER_ON_EDUCATIONALTRANSPARENCYANDPUBLICITY FOREIGN KEY (educational_transparency_and_publicity_id) REFERENCES educational_transparency_and_publicity (id);

CREATE INDEX general_question_answer_educational_transparency_a_456511d4 ON general_question_answer (educational_transparency_and_publicity_id);

ALTER TABLE general_information
    ADD CONSTRAINT FK_GENERAL_INFORMATION_ON_HIGHER_EDUCATION_INSTITUTION_AREA FOREIGN KEY (higher_education_institution_area_id) REFERENCES higher_education_institution_area (id);

CREATE INDEX general_information_higher_education_instituti_35f8bd71 ON general_information (higher_education_institution_area_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERAL_QUESTION_ANSWER_ON_EDUCATIONAL_PROGRAM FOREIGN KEY (educational_program_id) REFERENCES educational_program (id);

CREATE INDEX general_question_answer_educational_program_id_c4af4251 ON general_question_answer (educational_program_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERAL_QUESTION_ANSWER_ON_EDUCATIONAL_PROGRAM_ACCESS FOREIGN KEY (educational_program_access_id) REFERENCES educational_program_access (id);

CREATE INDEX general_question_answer_educational_program_access_id_925b7575 ON general_question_answer (educational_program_access_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERAL_QUESTION_ANSWER_ON_EDUCATIONAL_PROGRAM_DESIGN FOREIGN KEY (educational_program_design_id) REFERENCES education_program_design (id);

CREATE INDEX general_question_answer_educational_program_design_id_857a65e3 ON general_question_answer (educational_program_design_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERAL_QUESTION_ANSWER_ON_HUMAN_RESOURCES FOREIGN KEY (human_resources_id) REFERENCES human_resources (id);

CREATE INDEX general_question_answer_human_resources_id_151f132b ON general_question_answer (human_resources_id);

ALTER TABLE general_question_answer
    ADD CONSTRAINT FK_GENERAL_QUESTION_ANSWER_ON_QUALITY_ASSURANCE FOREIGN KEY (quality_assurance_id) REFERENCES quality_assurance (id);

CREATE INDEX general_question_answer_quality_assurance_id_61cd8b08 ON general_question_answer (quality_assurance_id);

ALTER TABLE information_on_self_assessment_of_educational_program
    ADD CONSTRAINT FK_INFORMATIONONSELFASSESSMENTOFEDUCATIONALPROGR_ON_TABLESANNEX FOREIGN KEY (tables_annex_id) REFERENCES table_annex (id);

CREATE INDEX information_on_self_assess_tables_annex_id_1b3c1ad5 ON information_on_self_assessment_of_educational_program (tables_annex_id);

ALTER TABLE information_on_self_assessment_of_educational_program
    ADD CONSTRAINT FK_INFORMATIONONSELFASSESSMENTOFEDUCATION_ON_GENERALINFORMATION FOREIGN KEY (general_information_id) REFERENCES general_information (id);

CREATE INDEX information_on_self_assess_general_information_id_0ae85ecf ON information_on_self_assessment_of_educational_program (general_information_id);

ALTER TABLE information_on_self_assessment_of_educational_program
    ADD CONSTRAINT FK_INFORMATIONONSELFASSESSMENTOFEDUCAT_ON_GENERALQUESTIONANSWER FOREIGN KEY (general_question_answer_id) REFERENCES general_question_answer (id);

CREATE INDEX information_on_self_assess_general_question_answer_id_6feae976 ON information_on_self_assessment_of_educational_program (general_question_answer_id);

ALTER TABLE program_educational_components_information
    ADD CONSTRAINT FK_PROGRAMEDUCATIONALCOMPONENTSINFO_ON_EDUCATIONPROGRAMDOCUMENT FOREIGN KEY (education_program_document_id) REFERENCES education_program_document (id);

ALTER TABLE separate_structural_unit
    ADD CONSTRAINT FK_SEPARATE_STRUCTURAL_UNIT_ON_HEAD_FULL_NAME FOREIGN KEY (head_full_name_id) REFERENCES teacher (id);

CREATE INDEX separate_structural_unit_head_full_name_id_491f206d ON separate_structural_unit (head_full_name_id);

ALTER TABLE specialty
    ADD CONSTRAINT FK_SPECIALTY_ON_FIELD_OF_STUDY FOREIGN KEY (field_of_study_id) REFERENCES field_of_study (id);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_USER FOREIGN KEY (user_id) REFERENCES public."user" (id);

CREATE UNIQUE INDEX student_user_id_key ON student (user_id);

ALTER TABLE teacher
    ADD CONSTRAINT FK_TEACHER_ON_SUBDIVISION FOREIGN KEY (subdivision_id) REFERENCES subdivision (id);

ALTER TABLE teacher
    ADD CONSTRAINT FK_TEACHER_ON_USER FOREIGN KEY (user_id) REFERENCES public."user" (id);

CREATE UNIQUE INDEX teacher_user_id_key ON teacher (user_id);

ALTER TABLE teacher_summary_information
    ADD CONSTRAINT FK_TEACHER_SUMMARY_INFORMATION_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher (id);

CREATE INDEX teacher_summary_information_teacher_id_6fd5f70f ON teacher_summary_information (teacher_id);

ALTER TABLE auth_group_auth_permissions
    ADD CONSTRAINT fk_autgroautper_on_auth_group FOREIGN KEY (auth_group_id) REFERENCES auth_group (id);

ALTER TABLE auth_group_auth_permissions
    ADD CONSTRAINT fk_autgroautper_on_auth_permission FOREIGN KEY (auth_permissions_id) REFERENCES auth_permission (id);

ALTER TABLE education_program_accreditation_information_languages
    ADD CONSTRAINT fk_eduproaccinflan_on_educationprogramaccreditationinformation FOREIGN KEY (education_program_accreditation_information_id) REFERENCES education_program_accreditation_information (id);

ALTER TABLE education_program_accreditation_information_languages
    ADD CONSTRAINT fk_eduproaccinflan_on_language FOREIGN KEY (languages_id) REFERENCES language (id);

ALTER TABLE education_program_accreditation_information_subdivisions
    ADD CONSTRAINT fk_eduproaccinfsub_on_educationprogramaccreditationinformation FOREIGN KEY (education_program_accreditation_information_id) REFERENCES education_program_accreditation_information (id);

ALTER TABLE education_program_accreditation_information_subdivisions
    ADD CONSTRAINT fk_eduproaccinfsub_on_subdivision FOREIGN KEY (subdivisions_id) REFERENCES subdivision (id);

ALTER TABLE general_information_education_programs
    ADD CONSTRAINT fk_geninfedupro_on_education_program FOREIGN KEY (education_programs_id) REFERENCES education_program (id);

ALTER TABLE general_information_education_programs
    ADD CONSTRAINT fk_geninfedupro_on_general_information FOREIGN KEY (general_information_id) REFERENCES general_information (id);

ALTER TABLE general_information_education_program_documents
    ADD CONSTRAINT fk_geninfeduprodoc_on_education_program_document FOREIGN KEY (education_program_documents_id) REFERENCES education_program_document (id);

ALTER TABLE general_information_education_program_documents
    ADD CONSTRAINT fk_geninfeduprodoc_on_general_information FOREIGN KEY (general_information_id) REFERENCES general_information (id);

ALTER TABLE table_annex_program_educational_components_informations
    ADD CONSTRAINT fk_tabannproeducominf_on_programeducationalcomponentsinformatio FOREIGN KEY (program_educational_components_informations_id) REFERENCES program_educational_components_information (id);

ALTER TABLE table_annex_program_educational_components_informations
    ADD CONSTRAINT fk_tabannproeducominf_on_table_annex FOREIGN KEY (table_annex_id) REFERENCES table_annex (id);

ALTER TABLE table_annex_study_result
    ADD CONSTRAINT fk_tabannstures_on_study_result FOREIGN KEY (study_result_id) REFERENCES study_result (id);

ALTER TABLE table_annex_study_result
    ADD CONSTRAINT fk_tabannstures_on_table_annex FOREIGN KEY (table_annex_id) REFERENCES table_annex (id);

ALTER TABLE table_annex_teacher_summary_informations
    ADD CONSTRAINT fk_tabannteasuminf_on_table_annex FOREIGN KEY (table_annex_id) REFERENCES table_annex (id);

ALTER TABLE table_annex_teacher_summary_informations
    ADD CONSTRAINT fk_tabannteasuminf_on_teacher_summary_information FOREIGN KEY (teacher_summary_informations_id) REFERENCES teacher_summary_information (id);

ALTER TABLE teacher_summary_information_educational_components_informations
    ADD CONSTRAINT fk_teasuminfeducominf_on_programeducationalcomponentsinformatio FOREIGN KEY (program_educational_components_informations_id) REFERENCES program_educational_components_information (id);

ALTER TABLE teacher_summary_information_educational_components_informations
    ADD CONSTRAINT fk_teasuminfeducominf_on_teacher_summary_information FOREIGN KEY (teacher_summary_information_id) REFERENCES teacher_summary_information (id);

ALTER TABLE public.user_auth_groups
    ADD CONSTRAINT fk_useautgro_on_auth_group FOREIGN KEY (auth_groups_id) REFERENCES auth_group (id);

ALTER TABLE public.user_auth_groups
    ADD CONSTRAINT fk_useautgro_on_user FOREIGN KEY (user_id) REFERENCES public."user" (id);

ALTER TABLE public.user_auth_permissions
    ADD CONSTRAINT fk_useautper_on_auth_permission FOREIGN KEY (auth_permissions_id) REFERENCES auth_permission (id);

ALTER TABLE public.user_auth_permissions
    ADD CONSTRAINT fk_useautper_on_user FOREIGN KEY (user_id) REFERENCES public."user" (id);
