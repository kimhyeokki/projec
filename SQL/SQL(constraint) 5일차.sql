-- 제약 조건
-- 값이 무조건 입력받아야 함
-- 숫자만, 문자만..
CREATE TABLE NEW_emp01(
	no NUMBER(4) CONSTRAINT emp01_no_pk PRIMARY KEY,
	name varchar2(20) CONSTRAINT emp01_name_nn NOT NULL,
	jumin varchar2(13) CONSTRAINT emp01_jumin_nn NOT null
					   CONSTRAINT emp01_jumin_uk UNIQUE,
	sal number(10) CONSTRAINT emp01_sal_ch CHECK(sal>1000),  --임의 조건도 달수 있음 				   
	deptno number(6) CONSTRAINT emp01_deptno_fk REFERENCES dept(deptno)
	-- 부모테이블에 primary key, unique 여야만 참조 가능.. 
);
INSERT INTO NEW_EMP01 VALUES(10,'조성호',121111111112,1500,20);

--테이블 수정 제약조건 추가
ALTER TABLE NEW_EMP01 ADD CONSTRAINT emp01_name_uk UNIQUE(name);
--ALTER TABLE NEW_EMP01 MODIFY emp01_name ..NOT NULL  (NOT NULL 경우에는 추가할 때 MODIFY 활용)
-- 테이블  제약조건 삭제
ALTER TABLE NEW_EMP01 drop CONSTRAINT emp01_name_uk;
INSERT INTO NEW_EMP01 VALUES(20,'조성호',121111111112,40);

CREATE TABLE NEW_emp02(
	no NUMBER(4)  PRIMARY KEY,
	name varchar2(20)  NOT NULL,
	jumin varchar2(13)  NOT NULL UNIQUE,
	deptno number(6)  REFERENCES dept(deptno)
);
SELECT *FROM NEW_EMP01;
SELECT * FROM NEW_EMP02;

INSERT INTO  NEW_EMP01 values(1,'김혁기',1122032222224,20);
INSERT INTO  NEW_EMP01 values(2,'장성호',1122031111114,20);
INSERT INTO  NEW_EMP01 values(emp_seq.nextval,'김혁기',1122033333333,20);

SELECT *FROM NEW_EMP01 e ;
-- auto increament 무조건 증가 삭제 개념 없다.
-- sequence
CREATE SEQUENCE emp_seq
		INCREMENT BY 1 --1씩증가
		START WITH   1 --1부터 시작
		MINVALUE     1
		MAXVALUE     9999
		NOCYCLE
		nocache;  --cache는 속도 향상을 위해 한번에 여러개의 메모리에 올려 놓고 작업한다.
		          --만약에 cache가 20이라면  1~20까지 작업하고 증가한다 but 중간 작업이 끊어지면
		          --1~20 사이에 데이터를 버리고 21부터 시작해버린다. 
	--oracle에서 증가방식
ALTER SEQUENCE emp_seq MAXVALUE 99999; -- emp_seq의 조건 변경할때 ALTER
DROP TABLE NEW_EMP01;
DROP SEQUENCE emp_seq;
SELECT emp_seq.nextval FROM DUAL;
-- seqence 사용하지 않고 증가 시킬때
INSERT INTO  NEW_EMP01 values(
		(SELECT NVL(max(no),0)+1  FROM NEW_EMP01),
		'장성호',1122031111114,10);
SELECT *FROM NEW_EMP01 ne ;

--dept03을 생성하시오
CREATE TABLE dept03
		(
		deptno NUMBER(2) NOT NULL UNIQUE, --PRIMARY KEY 와 같음
		dname varchar2(30) UNIQUE,
		loc varchar2(30) NOT NULL
		);
SELECT *FROM dept03;
INSERT INTO DEPT03 VALUES((SELECT NVL(Max(DEPTNO),0)+10 FROM DEPT03),'김혁기','seoul');
INSERT INTO DEPT03 VALUES((SELECT NVL(Max(DEPTNO),0)+10 FROM DEPT03),'장성호','inchun');
INSERT INTO DEPT03 VALUES((SELECT NVL(Max(DEPTNO),0)+10 FROM DEPT03),'장장수','busan');

SELECT *FROM user_constraints WHERE table_name ='NEW_EMP02';

--quiz01
--테이블 new_const 생성
--empno 숫자 4개, uni,not null, 자동증가
--ename 글자 30개 not null
--job 글자 30개
--tel 글자 13개 unique
--sal 숫자 7자리 소수점 2자리  1000이상 9999이하
--comm 숫자 7자리 소수점 2자리
--dept dept의 deptno 참조
CREATE table NEW_const(
	empno number(4) PRIMARY KEY,
	ename varchar2(30) NOT NULL,
	job varchar2(30),
	tel varchar2(13) UNIQUE,
	hiredate DATE,
	sal number(7,2) check(sal BETWEEN 1000 AND 9999),
	comm NUMBER(7,2), --자릿수,소수점 2자리
	dept NUMBER(2) REFERENCES dept(deptno)
	);
	DROP TABLE NEW_CONST;
CREATE SEQUENCE emp_seq02
		INCREMENT BY 1
		START WITH 1
		MINVALUE  1
		MAXVALUE  9999
		nocycle
		;
INSERT INTO new_const VALUES(emp_seq02.nextval,'김민재','player',01011122333,sysdate,3500,'',10);
INSERT INTO new_const VALUES(emp_seq02.nextval,'장성호','manager',01044442333,'2023-08-08',2500,'',30);
INSERT INTO new_const VALUES(emp_seq02.nextval,'클린스','salesman',01066662333,'2023-05-29',4500,'',20);
SELECT *FROM new_const;

--테이블 제약 조건 조회할 때..
SELECT  *FROM user_constraints WHERE TABLE_name= 'NEW_CONST';
