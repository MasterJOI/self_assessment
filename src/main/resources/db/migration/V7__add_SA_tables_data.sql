/*----------------------Таблиця 1. Інформація про обов’язкові освітні компоненти ОП----------------------*/

/*Документи освітніх компонентів (силабуси)*/
INSERT INTO education_program_document (id, general_information_id, type, name, content)
VALUES ('cdd4a7ce-dc61-4b15-942f-c10fcbd26224', '0c1ad6fd-c1d3-4ace-bcef-34251a12dcd8', 'syllabus','Syllabus_PhD_IMND-A_2020.pdf', '');

/*Інформація про освітній компонент*/
INSERT INTO program_educational_components_information (id, component_name, component_type, special_equipment_info, education_program_document_id)
VALUES ('7325b46a-af05-4f85-82bf-4838564ec4ed', 'Іноземна мова для наукової діяльності',
		'навчальна дисципліна', 'Спеціальне матеріально-технічне та/або інформаційне забезпечення не потрібне',
		'cdd4a7ce-dc61-4b15-942f-c10fcbd26224');

/*----------------------Таблиця 2. Зведена інформація про викладачів----------------------*/

/*Зведена інформація про викладача*/
INSERT INTO teacher_summary_information (id, teacher_qualification, teacher_experience, rationale, subdivision_id,
                                         teacher_full_name_id)
VALUES ('483ad039-e108-4518-81ba-6a57df3b8108', 'Диплом спеціаліста, Національний технічний університет України "Київський політехнічний інститут", рік закінчення: 2009, спеціальність: 030507 Переклад, Диплом кандидата наук ДK 035362, виданий 12.05.2016',
        8, 'Науковий ступінь
Кандидат філологічних наук, 10.02.04 – Германські мови, тема дисертації: «Особливості функціонування північно-східного діалекту Англії у період 1960-2010 років»
Підвищення кваліфікації
Навчальний комплекс «Інститут післядипломної освіти КПІ ім. Ігоря Сікорського». Сертифікат ПК № 02070921/004407-19, 2019.

Види і результати професійної діяльності за спеціальністю (п.30 Ліцензійних умов провадження освітньої діяльності)

Критерій 2
1. Колісник М. П. Специфіка актуалізації морфологічних відхилень у мовленні носіїв північно-східного діалекту Англії у період 1990-2000 років. Актуальні проблеми романо-германської філології та прикладної лінгвістики: науковий журнал. 2019. Вип. 2 (18). C. 119-126.
2. Колісник М. П. Vocalic system of the North-Eastern dialect of England within the period of 2000-2010. Наукові записки. Серія: Філологічні науки. 2017. Вип.154. С. 119-125.
3. Kolisnyk M. P., Riznyk A. O. Writing skill in distance learning programs. Current Foreign Languages Teaching Issues in Higher. 2020. P. 124-127.
4. Kolisnyk M.P. Interaction of dialect language units. Modern science: problems and innovations. Stockholm : SSPG Publish. 2020. P. 491-494.
5. Колісник М. П. Фонетичні розбіжності у системі приголосних звуків північно-східного діалекту Англії. Сучасні тенденції фонетичних досліджень. К.: «Політехніка», 2020. С. 100-102.

Критерій 8
Член редакційної колегії наукового видання «Advanced Education» indexed in ESCI (Web of Science), Index Copernicus, DOAJ, CrossRef, WorldCat, Ulrich''s Periodicals Directory, SprintKnowledge, Google Scholar, BASE, OAJI.

Критерій 14
1. Член журі І етапу Всеукраїнської студентської олімпіади з дисципліни «Англійська мова», додаток №2, до наказу 1/65 від 20. 02.2020 р.
2. Член організаційоного комітету Міжнародної студентської конференції «Ukrainian and Foreign Science: Yesterday, Today, Tomorrow» (VIII - 12.12.2019; IX - 02.12.2020).
3. Член організаційоного комітету Відкритої Інтернет-олімпіади з англійської мови та комп''ютерних наук (06-07.04.2020; 22-23.04. 2021).
4. Член організаційоного комітету Міжнародної студентської конференції «Ukrainian and Foreign Science: Yesterday, Today, Tomorrow» (VIII - 12.12.2019; IX - 02.12.2020, X- 06.12.2021).

Критерій 16
Член громадської організації «Асоціація викладачів англійської мови «ТІСОЛ-Україна» (TESOL-Ukraine), міжнародної філії TESOL, Inc. (свідоцтво № 160).

Критерій 17
Досвід практичної роботи за спеціальністю – 8 років.',
        'b6c68abb-c09b-4d8d-a280-9fc84a7f2b3a',
        'f3750d67-1124-4698-a99d-a5338ff5804e');

/*----------------------Таблиця 3. Матриця відповідності----------------------*/

/*Інформація про програмні результати навчання*/
INSERT INTO program_learning_outcome_correspondence_matrix (id, name, teaching_method, assessment_form, educational_component_id)
VALUES ('8c824f19-1925-433a-b53a-f7b894e93cba', 'Здатність сприяти в академічному та професійному контексті науковому, технологічному, соціальному та культурному прогресу в суспільстві, заснованому на знаннях.',
        'Лекції, практичні заняття, консультації, самонавчання', 'Опитування, модульний контроль, індивідуальне завдання, іспит',
        '7325b46a-af05-4f85-82bf-4838564ec4ed');

/*----------------------Додаток довідника (таблиці)----------------------*/
INSERT INTO table_annex (id)
VALUES ('55250060-4b99-4d04-abed-d53626a89db7');

/*Додати освітній компонент в таблицю*/
INSERT INTO table_annex_program_educational_components_informations (program_educational_components_informations_id, table_annex_id)
VALUES ('7325b46a-af05-4f85-82bf-4838564ec4ed', '55250060-4b99-4d04-abed-d53626a89db7');

/*Додати освіній компонент в зведену інформацію про викладача*/
INSERT INTO teacher_summary_information_educational_components_informations (program_educational_components_informations_id,
                                                                             teacher_summary_information_id)
VALUES ('7325b46a-af05-4f85-82bf-4838564ec4ed', '483ad039-e108-4518-81ba-6a57df3b8108');

INSERT INTO table_annex_teacher_summary_informations (teacher_summary_informations_id, table_annex_id)
VALUES ('483ad039-e108-4518-81ba-6a57df3b8108', '55250060-4b99-4d04-abed-d53626a89db7');

/*Додати інформацію про програмні результати навчання в таблицю*/
INSERT INTO table_annex_program_learning_outcome_correspondence_matrixes (program_learning_outcome_correspondence_matrixes_id, table_annex_id)
VALUES ('8c824f19-1925-433a-b53a-f7b894e93cba', '55250060-4b99-4d04-abed-d53626a89db7');

/*----------------------Довідник про самооцінювання ОП----------------------*/
INSERT INTO information_on_self_assessment_of_educational_program (id, general_information_id,
																   general_question_answer_id, tables_annex_id)
VALUES ('442f929e-c925-49ea-8bcb-bb3d4c37bda4', '0c1ad6fd-c1d3-4ace-bcef-34251a12dcd8',
		'bfc7424d-e8f8-411f-be57-018631dea2d5', '55250060-4b99-4d04-abed-d53626a89db7');
