/*
 В подключенном MySQL репозитории создать базу данных “Друзья человека”
 Создать таблицы с иерархией из диаграммы в БД
 Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
*/
DROP DATABASE IF EXISTS Друзья_человека;
CREATE DATABASE IF NOT EXISTS Друзья_человека;
USE Друзья_человека;

DROP TABLE IF EXISTS type_animals;
CREATE TABLE IF NOT EXISTS type_animals (
	type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_animal VARCHAR(15)
);

INSERT INTO type_animals (type_animal)
VALUE("pets"),
     ("pack_animals");

SELECT * FROM type_animals;


DROP TABLE IF EXISTS dogs;
CREATE TABLE IF NOT EXISTS dogs(
	id_animal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_id INT NOT NULL,
    name_animal VARCHAR(20),
    date_of_birthday DATE,
    commands TEXT,
    FOREIGN KEY (type_id) REFERENCES type_animals (type_id)
);

INSERT INTO dogs(type_id,name_animal,date_of_birthday,commands)
VALUES
	(1,"Reks","2022-12-2","seat,bark,run"),
    (1,"Tobik","2021-02-12","seat,bark");
    
DROP TABLE IF EXISTS cats;
CREATE TABLE IF NOT EXISTS cats(
	id_animal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_id INT NOT NULL,
    name_animal VARCHAR(20),
    date_of_birthday DATE,
    commands TEXT,
    FOREIGN KEY (type_id) REFERENCES type_animals (type_id)
);

INSERT INTO cats(type_id,name_animal,date_of_birthday,commands)
VALUES
	(1,"Murka","2020-10-4","seat,meow,run"),
    (1,"Murzik","2023-01-10","seat");
    
DROP TABLE IF EXISTS humsters;
CREATE TABLE IF NOT EXISTS humsters(
	id_animal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_id INT NOT NULL,
    name_animal VARCHAR(20),
    date_of_birthday DATE,
    commands TEXT,
    FOREIGN KEY (type_id) REFERENCES type_animals (type_id)
);

INSERT INTO humsters(type_id,name_animal,date_of_birthday,commands)
VALUES
	(1,"Micki","2020-12-24","seat, run"),
    (1,"Pushistik","2024-02-02","seat");
    
DROP TABLE IF EXISTS horses;
CREATE TABLE IF NOT EXISTS horses(
	id_animal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_id INT NOT NULL,
    name_animal VARCHAR(20),
    date_of_birthday DATE,
    commands TEXT,
    FOREIGN KEY (type_id) REFERENCES type_animals (type_id)
);

INSERT INTO horses(type_id,name_animal,date_of_birthday,commands)
VALUES
	(2,"Mustang","2019-12-24","seat,sleep,run"),
    (2,"Grom","2020-04-13","seat,run");

DROP TABLE IF EXISTS camels;
CREATE TABLE IF NOT EXISTS camels(
	id_animal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_id INT NOT NULL,
    name_animal VARCHAR(20),
    date_of_birthday DATE,
    commands TEXT,
    FOREIGN KEY (type_id) REFERENCES type_animals (type_id)
);

INSERT INTO camels(type_id,name_animal,date_of_birthday,commands)
VALUES
	(2,"Gorb","2012-11-22","seat,run"),
    (2,"Vasya","2003-03-14","seat, eat");
    
DROP TABLE IF EXISTS donkeys;
CREATE TABLE IF NOT EXISTS donkeys(
	id_animal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type_id INT NOT NULL,
    name_animal VARCHAR(20),
    date_of_birthday DATE,
    commands TEXT,
    FOREIGN KEY (type_id) REFERENCES type_animals (type_id)
);

INSERT INTO donkeys(type_id,name_animal,date_of_birthday,commands)
VALUES
	(2,"Monsy","2010-12-2","seat,ia,run"),
    (2,"Ia","2011-02-12","seat,ia");

/*
Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
*/

TRUNCATE camels;

DROP TABLE IF EXISTS horses_and_donkeys;
CREATE TABLE IF NOT EXISTS horses_and_donkeys AS
SELECT 'horses' AS source_table, type_id, name_animal, date_of_birthday, commands FROM horses
UNION
SELECT 'donkeys' AS source_table, type_id, name_animal, date_of_birthday, commands FROM donkeys;

SELECT * FROM horses_and_donkeys;

/*
Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/

DROP TABLE IF EXISTS young_animals;
CREATE TABLE IF NOT EXISTS young_animals AS
SELECT 'dogs' AS source_table, type_id, name_animal, date_of_birthday, commands FROM dogs
WHERE datediff(CURDATE(),date_of_birthday) BETWEEN 356 AND (356*3)
UNION
SELECT 'cats' AS source_table, type_id, name_animal, date_of_birthday, commands FROM cats
WHERE datediff(CURDATE(),date_of_birthday) BETWEEN 356 AND (356*3)
UNION
SELECT 'humsters' AS source_table, type_id, name_animal, date_of_birthday, commands FROM humsters
WHERE datediff(CURDATE(),date_of_birthday) BETWEEN 356 AND (356*3)
UNION
SELECT 'horses' AS source_table, type_id, name_animal, date_of_birthday, commands FROM horses
WHERE datediff(CURDATE(),date_of_birthday) BETWEEN 356 AND (356*3)
UNION
SELECT 'camels' AS source_table, type_id, name_animal, date_of_birthday, commands FROM camels
WHERE datediff(CURDATE(),date_of_birthday) BETWEEN 356 AND (356*3)
UNION
SELECT 'donkeys' AS source_table, type_id, name_animal, date_of_birthday, commands FROM donkeys
WHERE datediff(CURDATE(),date_of_birthday) BETWEEN 356 AND (356*3);

SELECT source_table, type_id, name_animal, date_of_birthday, FLOOR(DATEDIFF(CURDATE(), date_of_birthday) / 30.43) AS age FROM young_animals;

/*
Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
*/

DROP TABLE IF EXISTS all_animals;
CREATE TABLE IF NOT EXISTS all_animals AS
SELECT 'dogs' AS source_table, id_animal, type_id, name_animal, date_of_birthday, commands FROM dogs
UNION
SELECT 'cats' AS source_table, id_animal, type_id, name_animal, date_of_birthday, commands FROM cats
UNION
SELECT 'humsters' AS source_table, id_animal, type_id, name_animal, date_of_birthday, commands FROM humsters
UNION
SELECT 'horses' AS source_table, id_animal, type_id, name_animal, date_of_birthday, commands FROM horses
UNION
SELECT 'camels' AS source_table, id_animal, type_id, name_animal, date_of_birthday, commands FROM camels
UNION
SELECT 'donkeys' AS source_table, id_animal, type_id, name_animal, date_of_birthday, commands FROM donkeys
UNION
SELECT 'camels' AS source_table, id_animal, type_id, name_animal, date_of_birthday, commands FROM camels;

SELECT * FROM all_animals;

