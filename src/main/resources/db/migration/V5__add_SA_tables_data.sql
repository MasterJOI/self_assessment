/*----------------------Таблиця 1. Інформація про обов’язкові освітні компоненти ОП----------------------*/

/*Документи освітніх компонентів (силабуси)*/
INSERT INTO education_program_document (id, type, name, path, hash)
VALUES ('cdd4a7ce-dc61-4b15-942f-c10fcbd26224', 'SYLLABUS', 'Syllabus_PhD_IMND-A_2020.pdf',
        'D:\magistr\self_assessment\src\main\resources\files\Syllabus_PhD_IMND-A_2020.pdf',
        '+xTa9I3EF5vxwG/XOb8V35bcVYU9ecxakffnGWiXM+8='),
	   ('fb5caaa3-da7e-4fbd-b363-4180ccce6dce', 'SYLLABUS','Syllabus_PhD_ONOD_2020.pdf',
	    'D:\magistr\self_assessment\src\main\resources\files\Syllabus_PhD_ONOD_2020.pdf',
	    '+xTa9I3EF5vxwG/XOb8V35bcVYU9ecxakffnGWiXM+8=');

/*Інформація про освітній компонент*/
INSERT INTO program_educational_components_information (id, component_name, component_type, special_equipment_info, education_program_document_id)
VALUES ('7325b46a-af05-4f85-82bf-4838564ec4ed', 'Іноземна мова для наукової діяльності',
		'DISCIPLINE', 'Спеціальне матеріально-технічне та/або інформаційне забезпечення не потрібне',
		'cdd4a7ce-dc61-4b15-942f-c10fcbd26224'),
	   ('8ccc24ef-77dc-4960-8678-ebe2ab98d228', 'Організація науково-інноваційної діяльності',
		'DISCIPLINE', 'Спеціальне матеріально-технічне та/або інформаційне забезпечення не потрібне',
		'fb5caaa3-da7e-4fbd-b363-4180ccce6dce');

/*----------------------Таблиця 2. Зведена інформація про викладачів----------------------*/

/*Зведена інформація про викладача*/
INSERT INTO teacher_summary_information (id, teacher_id)
VALUES ('483ad039-e108-4518-81ba-6a57df3b8108', 'f3750d67-1124-4698-a99d-a5338ff5804e');

/*----------------------Таблиця 3. Матриця відповідності----------------------*/

/*Інформація про програмний результат навчання*/
INSERT INTO study_result (id, name, is_corresponds)
VALUES ('8c824f19-1925-433a-b53a-f7b894e93cba',
        'Здатність сприяти в академічному та професійному контексті науковому, технологічному, соціальному та культурному прогресу в суспільстві, заснованому на знаннях.',
        true);

/*Інформація про відповідність освітнього компоненту*/
INSERT INTO education_component_correspondence (id, teaching_method, assessment_form, educational_component_id, study_result_id)
VALUES ('e797a84c-639c-11ee-8c99-0242ac120002',
		'Ппрактичні заняття, консультації, самонавчання', 'Опитування, модульний контроль, індивідуальне завдання, іспит',
		'7325b46a-af05-4f85-82bf-4838564ec4ed',
        '8c824f19-1925-433a-b53a-f7b894e93cba'),
	   ('b6661290-506b-4bb3-b99e-011a442b4da6',
		'Лекції, практичні заняття, консультації, самонавчання', 'Опитування, модульний контроль, індивідуальне завдання, іспит',
		'8ccc24ef-77dc-4960-8678-ebe2ab98d228',
		'8c824f19-1925-433a-b53a-f7b894e93cba');

/*----------------------Додаток довідника (таблиці)----------------------*/
INSERT INTO table_annex (id)
VALUES ('55250060-4b99-4d04-abed-d53626a89db7');

/*Додати освітній компонент в таблицю*/
INSERT INTO table_annex_program_educational_components_informations (program_educational_components_informations_id, table_annex_id)
VALUES ('7325b46a-af05-4f85-82bf-4838564ec4ed', '55250060-4b99-4d04-abed-d53626a89db7'),
	   ('8ccc24ef-77dc-4960-8678-ebe2ab98d228', '55250060-4b99-4d04-abed-d53626a89db7');

/*Додати освіній компонент в зведену інформацію про викладача*/
INSERT INTO teacher_summary_information_educational_components_informations (program_educational_components_informations_id,
                                                                             teacher_summary_information_id)
VALUES ('7325b46a-af05-4f85-82bf-4838564ec4ed', '483ad039-e108-4518-81ba-6a57df3b8108');

INSERT INTO table_annex_teacher_summary_informations (teacher_summary_informations_id, table_annex_id)
VALUES ('483ad039-e108-4518-81ba-6a57df3b8108', '55250060-4b99-4d04-abed-d53626a89db7');

/*Додати інформацію про програмні результати навчання в таблицю*/
INSERT INTO table_annex_study_result (study_result_id, table_annex_id)
VALUES ('8c824f19-1925-433a-b53a-f7b894e93cba', '55250060-4b99-4d04-abed-d53626a89db7');

/*----------------------Довідник про самооцінювання ОП----------------------*/
INSERT INTO information_on_self_assessment_of_educational_program (id, general_information_id,
																   general_question_answer_id, tables_annex_id)
VALUES ('442f929e-c925-49ea-8bcb-bb3d4c37bda4', '0c1ad6fd-c1d3-4ace-bcef-34251a12dcd8',
		'bfc7424d-e8f8-411f-be57-018631dea2d5', '55250060-4b99-4d04-abed-d53626a89db7');
