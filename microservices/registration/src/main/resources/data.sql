CREATE TABLE REGISTRATION
(
    USER_ID LONG NOT NULL,
    HASH_FROM_PASS LONG NOT NULL,
    LOGIN NVARCHAR,
    USER_NAME NVARCHAR
);
INSERT INTO REGISTRATION (USER_ID, HASH_FROM_PASS, LOGIN, USER_NAME) VALUES
('1', '1', 'myBrandNewLogin', 'Arty'),
('2', '2', 'NoobKiller228', 'Ruslan'),
('3', '15', 'GoldirevRazrivaetZaCT', 'Zheka'),
('4', '16', 'Nikita', 'Nikita')