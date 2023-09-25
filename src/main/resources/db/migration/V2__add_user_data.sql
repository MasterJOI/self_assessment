/*Структурний підрозділ*/
INSERT INTO subdivision (id, responsible_department)
VALUES ('dd150153-1baf-4aa1-9143-d9badf29783b', '5 кафедра ІПЗЕ'),
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
VALUES ('b9630f6a-2534-49b9-807a-9b40a3ca5920', '0954434568', 'Kyiv', '001', NOW(), '1',
        '892a9963-7926-44f7-95f9-ddaf42647bad', NOW());

/*Викладач*/
INSERT INTO teacher (id, phone_number, address, teacher_id, hire_date, user_id, birthdate)
VALUES ('fe017aa6-9d3d-4ecc-865f-9d097cb7577a', '0954433221', 'вул. Городецького, 13 м. Київ, 01001', '001', NOW(),
        '7a426e3e-e180-4d5e-becf-5458c8823c4e', NOW()),
	   ('f3750d67-1124-4698-a99d-a5338ff5804e', '0954433221', '	вул.Володимирівська, 33 м. Київ, 01601', '002', NOW(),
		'281eeedd-3c2d-4cde-bdd3-fbe5a373b84f', NOW());

/*Структурний підрозділ викладача*/
INSERT INTO teacher_subdivisions (subdivisions_id, teacher_id)
VALUES ('dd150153-1baf-4aa1-9143-d9badf29783b', 'fe017aa6-9d3d-4ecc-865f-9d097cb7577a'),
	   ('c07348ab-fd6f-4e93-99dc-271b999de6ca', 'f3750d67-1124-4698-a99d-a5338ff5804e');
