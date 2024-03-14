CREATE TABLE User (
    UserId INT AUTO_INCREMENT,
    FirstName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100) NOT NULL,
    UserName VARCHAR(100),
    Password VARCHAR(100) NOT NULL DEFAULT '0000',
    Role ENUM('ADMIN', 'KITCHEN', 'CASHIER', 'BOTH') NOT NULL,
    PRIMARY KEY (UserId)
);

CREATE TABLE Tip (
    TipId INT AUTO_INCREMENT,
    MonetaryValue DECIMAL(10,2) NOT NULL,
    Date DATE NOT NULL,
    UserId INT,
    PRIMARY KEY (TipId),
    FOREIGN KEY (UserId) REFERENCES User(UserId)
);
