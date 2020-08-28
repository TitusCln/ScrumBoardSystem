INSERT INTO PROJECT(NAME) VALUES('SCRUM BOARD SYSTEM')
INSERT INTO PROJECT(NAME) VALUES('RED CROSS SYSTEM')
INSERT INTO PROJECT(NAME) VALUES('SUPPORT TICKET SYSTEM')

INSERT INTO PROJECT_USER_STORY VALUES (1,1)
INSERT INTO PROJECT_USER_STORY VALUES(2,1)
INSERT INTO PROJECT_USER_STORY VALUES(3,1)
INSERT INTO PROJECT_USER_STORY VALUES(4,2)
INSERT INTO PROJECT_USER_STORY VALUES(5,2)
INSERT INTO PROJECT_USER_STORY VALUES(6,2)
INSERT INTO PROJECT_USER_STORY VALUES(7,2)
INSERT INTO PROJECT_USER_STORY VALUES(8,3)
INSERT INTO PROJECT_USER_STORY VALUES(9,3)
INSERT INTO PROJECT_USER_STORY VALUES(10,3)

INSERT INTO SPRINT(NAME,START_DATE,END_DATE,PROJECT_ID) VALUES ('SPRINT 001','2020-08-17','2020-08-30',1)
INSERT INTO SPRINT(NAME,START_DATE,END_DATE,PROJECT_ID) VALUES ('SPRINT 002','2020-08-17','2020-08-30',1)
INSERT INTO SPRINT(NAME,START_DATE,END_DATE,PROJECT_ID) VALUES ('SPRINT 003','2020-08-17','2020-08-30',1)
INSERT INTO SPRINT(NAME,START_DATE,END_DATE,PROJECT_ID) VALUES ('SPRINT 001','2020-08-17','2020-08-30',2)
INSERT INTO SPRINT(NAME,START_DATE,END_DATE,PROJECT_ID) VALUES ('SPRINT 002','2020-08-17','2020-08-30',2)

INSERT INTO SPRINT_USER_STORY(USER_STORY_ID, SPRINT_ID) VALUES (2,1)
INSERT INTO SPRINT_USER_STORY(USER_STORY_ID, SPRINT_ID) VALUES (3,2)
INSERT INTO SPRINT_USER_STORY(USER_STORY_ID, SPRINT_ID) VALUES (4,2)
INSERT INTO SPRINT_USER_STORY(USER_STORY_ID, SPRINT_ID) VALUES (5,3)
INSERT INTO SPRINT_USER_STORY(USER_STORY_ID, SPRINT_ID) VALUES (6,3)
INSERT INTO SPRINT_USER_STORY(USER_STORY_ID, SPRINT_ID) VALUES (7,4)
INSERT INTO SPRINT_USER_STORY(USER_STORY_ID, SPRINT_ID) VALUES (8,5)