CREATE TABLE EMPLOYEE(
EMP_ID NUMBER PRIMARY KEY,
NAME_FIRST VARCHAR2 (50),
NAME_LAST VARCHAR2 (50),
EMAIL VARCHAR2 (50),
USER_NAME VARCHAR2 (50),
PASS_WORD VARCHAR2 (50),
AVAIL_REIM NUMBER);

INSERT INTO EMPLOYEE VALUES (3, 'Dave', 'Patton', 'davepat@email.com', 'DP', 'pass', 1000);

INSERT INTO EMPLOYEE VALUES (4, 'Jamie', 'Price', 'jamieprice@email.com', 'JP', 'pass', 1000);

CREATE TABLE TRMSFORM(
FORM_ID NUMBER PRIMARY KEY,
EMP_ID NUMBER,
NAME_FIRST VARCHAR2 (50),
NAME_LAST VARCHAR2 (50),
EMAIL VARCHAR2 (50),
COURSE_TITLE VARCHAR2 (50),
COURSE_TYPE VARCHAR2 (50),
COURSE_START_DATE VARCHAR2 (50),
COURSE_LOCATION VARCHAR2 (50),
COURSE_COST NUMBER,
GRADE_FORMAT VARCHAR (50),
MIN_GRADE VARCHAR2 (50),
ADD_DOC VARCHAR2 (50),
FINAL_GRADE VARCHAR2 (50),
SUP_APPDEN VARCHAR2 (50),
DH_APPDEN VARCHAR2 (50),
BENCO_APPDEN VARCHAR2 (50),
REIM_AMOUNT NUMBER);

DROP TABLE TRMSFORM;

CREATE SEQUENCE IDSEQ START WITH 100;

INSERT INTO EMPLOYEE VALUES (1, 'Zach', 'Patton', 'zacharypatton1991@gmail.com', 'ZP', 'pass', 1000);

SELECT * FROM EMPLOYEE WHERE EMP_ID = 1;

CREATE OR REPLACE PROCEDURE MAKEREQUEST
(EMP_ID IN NUMBER, NAME_FIRST IN VARCHAR2, NAME_LAST IN VARCHAR2, EMAIL IN VARCHAR2, COURSE_TITLE IN VARCHAR2, COURSE_TYPE IN VARCHAR2, COURSE_START_DATE IN VARCHAR2, COURSE_LOCATION IN VARCHAR2, COURSE_COST IN NUMBER, GRADE_FORMAT IN VARCHAR2, MIN_GRADE IN VARCHAR2)
AS
BEGIN
INSERT INTO TRMSFORM VALUES (IDSEQ.NEXTVAL, EMP_ID, NAME_FIRST, NAME_LAST,  EMAIL, COURSE_TITLE, COURSE_TYPE, COURSE_START_DATE, COURSE_LOCATION, COURSE_COST, GRADE_FORMAT, MIN_GRADE, 'N/A', 'AWAITING', 'AWAITING APPROVAL', 'AWAITING APPROVAL', 'AWAITING APPROVAL', 0);
COMMIT;
END;
/

EXECUTE MAKEREQUEST(1, 'Zach', 'Patton', 'zacharypatton1991@gmail.com', 'RevPro', 'Software DevOp', '04-JULY-2020', 'Online', 200, 'Pass/Fail', 'Pass'); 

ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';

SELECT FORM_ID, COURSE_TITLE FROM TRMSFORM WHERE EMP_ID=1;

CREATE TABLE SUPERVISOR(
SUP_USER_NAME VARCHAR2(50) PRIMARY KEY,
SUP_PASS_WORD VARCHAR2 (50));

INSERT INTO SUPERVISOR VALUES ('ZP', 'pass');

CREATE TABLE DEPHEAD(
DH_USER_NAME VARCHAR2 (50) pRIMARY KEY,
DH_PASS_WORD VARCHAR2 (50));

INSERT INTO DEPHEAD VALUES ('DP', 'pass');

CREATE TABLE BENCO(
BC_USER_NAME VARCHAR2 (50) PRIMARY KEY,
BC_PASS_WORD VARCHAR2 (50));

INSERT INTO BENCO VALUES ('JP', 'pass');