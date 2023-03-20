CREATE DATABASE exemplodata
GO
USE exemplodata
GO
CREATE TABLE pessoa (
id					INT				NOT NULL,
nome				VARCHAR(100)	NOT NULL,
data_nascimento		DATE			NOT NULL
PRIMARY KEY(id))

SELECT * FROM pessoa
DELETE pessoa