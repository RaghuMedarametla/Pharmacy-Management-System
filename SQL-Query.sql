-- Create a database
create database pharmacy;
-- use the database
use pharmacy;

-- Create a table for the Customer and setting a primary key
DROP TABLE if exists Customer;
CREATE TABLE Customer (
    ssn               varchar(20) Unique, 
	username          varchar(20) Unique NOT NULL,
    password          varchar(20) DEFAULT NULL,
    first_name        varchar(255) NOT NULL, 
    last_name         varchar(255) NOT NULL, 
    phone             varchar(11) NOT NULL UNIQUE, 
    gender            varchar(10) NOT NULL, 
    address           varchar(1000) NOT NULL, 
    dateOfBirth       varchar(20) NOT NULL, 

    PRIMARY KEY (ssn)
);

-- Create a table for the Employee and setting a primary key
DROP TABLE if exists Employee;
CREATE TABLE Employee (
    id                int NOT NULL AUTO_INCREMENT, 
    ssn               varchar(20)  UNIQUE, 
	username          varchar(20) Unique NOT NULL,
    password          varchar(20) DEFAULT NULL,
    first_name        varchar(255) NOT NULL, 
    last_name         varchar(255) NOT NULL, 
    role              varchar(255) NOT NULL, 
    salary            float NOT NULL, 
    phoneNumber      varchar(10) NOT NULL,  

    PRIMARY KEY (ID)
);

-- Create a table for the Customer and setting a primary key for the above table.
CREATE TABLE Medicine (
    drugName           varchar(255) unique, 
    batchNumber        varchar(10) unique,  
    manufacturer        varchar(255), 
    stockQuantity      int NOT NULL, 
    expiryDate         Date NOT NULL, 
    price               int NOT NULL, 

    PRIMARY KEY (drugName, batchNumber)
);

-- Create a table for the prescription and setting a primary key for the above table.
DROP TABLE if exists Prescription;
CREATE TABLE Prescription (
    prescriptionId   int NOT NULL, 
    ssn               varchar(20) unique, 
    doctorId         long NOT NULL, 
    
    PRIMARY KEY (prescriptionId)
);
-- Altering the table prescription to reference a foreign constraint from customer
ALTER TABLE Prescription ADD CONSTRAINT holds FOREIGN KEY (ssn) REFERENCES Customer (ssn);

-- Create a table for the prescribed drugs and setting the primary key
CREATE TABLE Prescribed_Drugs (
    prescriptionId       int NOT NULL, 
    drugName             varchar(255) NOT NULL, 
    prescribedQuantity   int NOT NULL, 
    
    PRIMARY KEY (prescriptionId, drugName)
);

-- Altering the table prescribed drugs to reference a foreign key constraint from prescription
ALTER TABLE Prescribed_Drugs ADD CONSTRAINT consistsof FOREIGN KEY (prescriptionId) 
    REFERENCES Prescription (prescriptionId) ON DELETE Cascade;


-- Create a table for the orders and setting the primary key
CREATE TABLE Orders(
    orderId          int NOT NULL, 
    prescriptionId   int NOT NULL, 
    employeeId        int null, 
	orderDate        Date NOT NULL,
    PRIMARY KEY (orderId)
);

-- Altering the table orders to reference a foreign key constraint from prescription
ALTER TABLE Orders ADD CONSTRAINT uses FOREIGN KEY (prescriptionId) REFERENCES Prescription (prescriptionId);

-- Create a table for the ordered_Drugs and setting the primary key
CREATE TABLE Ordered_Drugs (
    orderId           int NOT NULL, 
    drugName           varchar(255) NOT NULL, 
    batchNumber        varchar(255), 
    orderedQuantity    int NOT NULL, 
    price               int NOT NULL, 

    PRIMARY KEY (orderId, drugName, batchNumber)
);

-- Altering the table ordered drugs to reference a foreign key constraint from orders
ALTER TABLE Ordered_Drugs ADD CONSTRAINT contains FOREIGN KEY (orderId) 
    REFERENCES Orders (orderId) ON DELETE Cascade;
-- Altering the table ordered drugs to reference a foreign key constraint from medicine
ALTER TABLE Ordered_Drugs ADD CONSTRAINT FulfilledFrom FOREIGN KEY (drugName, batchNumber) 
    REFERENCES Medicine (drugName, batchNumber);

-- Create a table for the bill and setting the primary key
CREATE TABLE Bill (
    orderId            int NOT NULL, 
    customerssn         varchar(20) UNIQUE, 
    totalAmount        float NOT NULL, 
    customerAmount    float NOT NULL, 
    
    PRIMARY KEY (orderId, customerssn)
);

-- Altering the table bill to reference a foreign key constraint from order
ALTER TABLE Bill ADD CONSTRAINT makes FOREIGN KEY (orderId) REFERENCES Orders (orderId); 
-- Altering the table bill to reference a foreign key constraint from customer
ALTER TABLE Bill ADD CONSTRAINT pays FOREIGN KEY (customerssn) REFERENCES Customer (ssn);

-- creating a view by joining the order and prescription and order table.
create or replace view employeeAssign as 
(Select p.prescriptionId, p.ssn, o.orderId, o.employeeId from Prescription p inner join Orders o where p.prescriptionId = o.prescriptionId);


-- select * from employeeAssign where employeeID is null;

-- Creating a procedure to get expiring drugs that are going to expire in 30 days from the current date.
delimiter //
CREATE PROCEDURE reportExpiringDrugs()
BEGIN
	SELECT * FROM Medicine WHERE DATEDIFF(expiryDate,CURDATE()) < 30;
END //
delimiter ;

-- creating a trigger to update the time after inserting the order record into the table.
delimiter //
CREATE TRIGGER updatetime BEFORE INSERT ON orders FOR EACH ROW
BEGIN
    SET NEW.orderDate = curdate();
END//

DELIMITER ;

-- Creating a stored procedure for generating bill from ordered drugs in mysql code only 
DELIMITER //
CREATE PROCEDURE generateBill ( IN orderId INT, IN customerssn varchar(20)) 
BEGIN 
declare totalAmount float;
declare customerAmount float;
SELECT SUM(price*orderedQuantity) INTO totalAmount FROM Ordered_Drugs o WHERE o.orderId = orderId;
set customerAmount = totalAmount;
INSERT INTO BILL VALUES (orderId, customerssn, totalAmount, customerAmount);
END //

DELIMITER ;
