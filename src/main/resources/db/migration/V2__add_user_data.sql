/*Структурний підрозділ*/
INSERT INTO subdivision (id, responsible_department)
VALUES ('dd150153-1baf-4aa1-9143-d9badf29783b', 'Факультет соціології і права'),
	   ('c07348ab-fd6f-4e93-99dc-271b999de6ca', 'Факультет лінгвістики');

/*Користувач*/
INSERT INTO public."user" (id, password, is_superuser, username, email, is_staff, is_active, name)
VALUES ('892a9963-7926-44f7-95f9-ddaf42647bad', '$2y$10$TUYsOhyrCvCf9.QJ8UAULOK0tboIgYdd5tAtb7CYHscg7F/4UZuzW', FALSE, 'admin', 'admin@gmail.com', FALSE,
        TRUE, 'Кирилл'),
	   ('7a426e3e-e180-4d5e-becf-5458c8823c4e', '$2y$10$TUYsOhyrCvCf9.QJ8UAULOK0tboIgYdd5tAtb7CYHscg7F/4UZuzW', FALSE, 'koval', 'koval@gmail.com', FALSE,
		TRUE, 'Коваль Олександр Васильович'),
	   ('281eeedd-3c2d-4cde-bdd3-fbe5a373b84f', '$2y$10$TUYsOhyrCvCf9.QJ8UAULOK0tboIgYdd5tAtb7CYHscg7F/4UZuzW', FALSE, 'kolysnik', 'kolysnik@gmail.com', FALSE,
		TRUE, 'Колісник Марина Павлівна');

/*Студент*/
INSERT INTO student (id, phone_number, address, student_id, enrollment_date, student_type, user_id, birthdate)
VALUES ('b9630f6a-2534-49b9-807a-9b40a3ca5920', '0954434568', 'Kyiv', '001', NOW(), 'MASTER',
        '892a9963-7926-44f7-95f9-ddaf42647bad', NOW());

/*Викладач*/
INSERT INTO teacher (id, phone_number, additional_phone_number, corporate_email, address, teacher_id, hire_date, user_id, birthdate, subdivision_id, teacher_position)
VALUES ('fe017aa6-9d3d-4ecc-865f-9d097cb7577a', '+38(044)-204-81-15', '+38(044)-204-91-13', 'dychka@pzks.fpm.kpi.ua', 'вул. Городецького, 13 м. Київ, 01001', '132762', NOW(),
        '7a426e3e-e180-4d5e-becf-5458c8823c4e', NOW(), 'dd150153-1baf-4aa1-9143-d9badf29783b', 'Доцент');

INSERT INTO teacher (id, phone_number, address, teacher_id, hire_date, user_id, birthdate, teacher_qualification,
                     teacher_position, teacher_experience, rationale, subdivision_id)
VALUES ('f3750d67-1124-4698-a99d-a5338ff5804e', '0954433221', '	вул.Володимирівська, 33 м. Київ, 01601', '285608', NOW(),
		 '281eeedd-3c2d-4cde-bdd3-fbe5a373b84f', NOW(),
        'Диплом спеціаліста, Національний технічний університет України "Київський політехнічний інститут", рік закінчення: 2009, спеціальність: 030507 Переклад, Диплом кандидата наук ДK 035362, виданий 12.05.2016',
        'Професор', 8, 'Науковий ступінь
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
        'c07348ab-fd6f-4e93-99dc-271b999de6ca');
