SELECT COUNT(IDTranzactie) as 'Tranzactii'
FROM Tranzactii
WHERE IDClient = 1;

SELECT COUNT(IDTranzactie) as 'Tranzactii'
FROM Tranzactii
WHERE IDClient = 1 AND IDProdus = 123;

SELECT COUNT(IDTranzactie) as 'Tranzactii'
FROM Tranzactii
WHERE IDClient = 1 AND IDProdus = 124;

SELECT COUNT(IDTranzactie) as 'Produse cumparate'
FROM Tranzactii
WHERE IDProdus = 124;

SELECT COUNT(IDTranzactie) as 'Tranzactii'
FROM Tranzactii
WHERE IDProdus = 123;