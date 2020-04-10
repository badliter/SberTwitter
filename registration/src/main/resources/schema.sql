CREATE TABLE USERS
(
    userId LONG NOT NULL auto_increment,
    userName NVARCHAR,
    email NVARCHAR,
    password NVARCHAR,
    firstName NVARCHAR,
    lastName NVARCHAR,
    status NVARCHAR,
    created DATETIME,
    updated DATETIME
);