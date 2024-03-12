/*CREATE Table*/
CREATE TABLE DetaliiPersoane(
ID int,
Nume varchar(255),
Prenume varchar(255),
Varsta int,
Adresa varchar(255),
Orasul varchar(255),
);

/* INSERT INTO*/
INSERT INTO DetaliiPersoane (ID, Nume, Prenume, Varsta, Adresa, Orasul)
VALUES('1','Popescu','Adrian','27', 'Strada Castanilor', 'Brasov');

/*UPDATE*/
UPDATE DetaliiPersoane
SET Orasul = 'Sibiu', Adresa=' Strada Lamaitei'
WHERE ID=1;

/* INSERT INTO*/
INSERT INTO DetaliiPersoane (ID, Nume, Prenume, Varsta, Adresa, Orasul)
VALUES('2','Dumitru','Florin','29', 'Strada Vasile Alexandri', 'Craiova'),
      ('3','Mirea','Ana','25', 'Strada Mihai Viteazul', 'Buzau');

/*DELETE row*/
DELETE FROM DetaliiPersoane WHERE ID = 2;

INSERT INTO DetaliiPersoane (ID, Nume, Prenume, Varsta, Adresa, Orasul)
VALUES('2','Dumitru','Florin','29', 'Strada Vasile Alexandri', 'Craiova');

/*DELETE all rows*/
DELETE FROM DetaliiPersoane;