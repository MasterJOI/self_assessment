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

INSERT INTO teacher (id, phone_number, address, teacher_id, hire_date, user_id, birthdate,
                     teacher_position, subdivision_id)
VALUES ('f3750d67-1124-4698-a99d-a5338ff5804e', '0954433221', '	вул.Володимирівська, 33 м. Київ, 01601', '285608', NOW(),
		 '281eeedd-3c2d-4cde-bdd3-fbe5a373b84f', NOW(), 'Професор', 'c07348ab-fd6f-4e93-99dc-271b999de6ca');
