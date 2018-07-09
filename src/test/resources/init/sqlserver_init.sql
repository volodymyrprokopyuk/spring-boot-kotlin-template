--CREATE LOGIN family WITH PASSWORD = 'Password1!';
--CREATE USER family FOR LOGIN family;
--EXEC sp_addrolemember 'db_owner', 'family';
CREATE SCHEMA family;

--CREATE TABLE family.person(id INT NOT NULL IDENTITY, first_name NVARCHAR(100) NOT NULL, last_name NVARCHAR(100) NOT NULL, PRIMARY KEY (id));
--INSERT INTO family.person(first_name, last_name) VALUES ('Volodymyr', 'Prokopyuk');
--SELECT * FROM family.person;
