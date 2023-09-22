CREATE TABLE test(
	NO number(4),
	id varchar2(30) ,
	password varchar2(50),
	age number(5),
	joindate DATE, 
	birth number(5)
);
INSERT INTO test values(test_seq.nextval,'kimhk11','1234',20,sysdate );
INSERT INTO test values(test_seq.nextval,'kimhk12','2222',25,sysdate);
INSERT INTO test values(test_seq.nextval,'kimhk13','3333',40,sysdate );

CREATE  SEQUENCE test_seq
		INCREMENT by 1
		START WITH  1
		MINVALUE 1
		MAXVALUE 9999
		nocycle
		nocache
		;
	
ROLLBACK;

COMMIT;
SELECT *FROM test;
DROP TABLE test;
DROP SEQUENCE test_seq;
DROP TABLE MEMBER ;

CREATE TABLE member(
	NO number(4),
	userID varchar2(50) PRIMARY key,
	userPW varchar2(50) unique,
	userName varchar2(50),
	postcode NUMBER(10), 
	address varchar2(80),
	detailaddress varchar2(80),
	email varchar2(80) UNIQUE ,
	tel varchar2(50) UNIQUE, 
	redate DATE 
);
CREATE  SEQUENCE seq_member
		INCREMENT by 1
		START WITH  1
		MINVALUE 1
		MAXVALUE 9999
		nocycle
		nocache
		;
DROP SEQUENCE seq_member;

SELECT *FROM MEMBER;
INSERT INTO MEMBER (NO,USERID,USERNAME,USERPW,ADDRESS,DETAILADDRESS) 
values(seq_member.nextval,'khk1234','김혁기',12312,'강원도',123);
INSERT INTO MEMBER (NO,USERID,USERNAME,USERPW,ADDRESS,DETAILADDRESS) 
values(seq_member.nextval,'khk1235','김혁기',12315,'강원도',123);
INSERT INTO MEMBER (NO,USERID,USERNAME,USERPW,ADDRESS,DETAILADDRESS) 
values(seq_member.nextval,'khk1236','김혁기',12316,'강원도',123);
INSERT INTO MEMBER (NO,USERID,USERNAME,USERPW,ADDRESS,DETAILADDRESS) 
values(seq_member.nextval,'khk1237','김혁기',12317,'강원도',123);
COMMIT;

SELECT REPLACE(USERNAME,SUBSTR(USERNAME,2,1),'*') FROM MEMBER WHERE  userid='kkk';
SELECT CONCAT(RPAD(SUBSTR(USERNAME,1,1),3,'*'),SUBSTR(USERNAME,3,1)) FROM MEMBER WHERE  userid='khk11';
select rpad(substr(postcode,1,2),LENGTH(postcode),'*') as postcode from member WHERE 
userid='kkk';
select rpad(substr(address,1,8),LENGTHB(address),'*') as addresss from member WHERE  userid= 'khk1234';
SELECT LENGTH(address) FROM MEMBER WHERE USERID='';
CREATE TABLE board(
		NO number(5),
		userid varchar2(40),
		userpw varchar2(40),
		username varchar2(40),
		title varchar2(40),
		content varchar2(100),
		regdate DATE,
		hit NUMBER(5)
	);
	CREATE  SEQUENCE seq_board
		INCREMENT by 1
		START WITH  1
		MINVALUE 1
		MAXVALUE 9999
		nocycle
		nocache
		;
		COMMIT;
		SELECT *FROM board WHERE title='애국';
		SELECT *FROM MEMBER ;
	
	
--100
	--plsql  for(i=0;i<100;i++)
	
	BEGIN
		FOR i IN 1..100 
		LOOP
			INSERT INTO board VALUEs(seq_board.nextval,'khk11'||i,'123'||i,'김혁기'||i,'제목_'||i,'내용이 들어갑니다'||i,
		sysdate,0);
		END LOOP;
END;
BEGIN
		FOR i IN 1..100 
		LOOP
			INSERT INTO member VALUEs(seq_member.nextval,'khk11'||i,'1235'||i,'김혁기'||i,1233||i,'1233'||i,'1233'||i,
		'kkk@gmail.com'||i,'010-1111-444'||i,sysdate);
		END LOOP;
END;
		SELECT COUNT(*)  FROM MEMBER;
	COMMIT;
	SELECT *FROM (
SELECT rownum AS num,b.* FROM   (SELECT * FROM board b ORDER BY NO DESC) b)
WHERE num >= 1 AND num<=10;