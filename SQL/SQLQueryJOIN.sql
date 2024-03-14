/*SQL - Querry1 INNER JOIN*/
SELECT Customers.ContactName
FROM Orders
INNER JOIN Customers ON Customers.CustomerID = Orders.CustomerID
GROUP BY Customers.ContactName

/*SQL - Querry2 INNER JOIN*/
SELECT Orders.CustomerID, COUNT(*) AS OrderNumber
FROM Orders
INNER JOIN Customers ON Customers.CustomerID = Orders.CustomerID
INNER JOIN dbo.[Order Details] ON [Order Details].OrderID = dbo.Orders.OrderID
WHERE Orders.OrderDate >= '1996-07-04 00:00:00.000' AND Orders.OrderDate <= '1996-07-04 00:00:00.000'
GROUP BY Orders.CustomerID
