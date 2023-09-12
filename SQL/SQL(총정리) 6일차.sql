--  정리
--  create(insert)  read(select)  update(update)  delete(delete)
SELECT * FROM emp;
SELECT ename AS 사원이름 FROM emp;
SELECT ename || '의 직업은' || job AS "이름과 직업" FROM emp;
SELECT * FROM emp 
	WHERE ENAME = 'JONES';

SELECT * FROM EMP 
	WHERE sal >= 1000 AND sal <= 3000;

SELECT * FROM EMP 
	WHERE sal BETWEEN 1000 AND 3000;

SELECT ename AS 이름 , sal*12 + nvl(comm,0) AS 연봉 FROM emp;

SELECT * FROM emp
	ORDER BY sal DESC, ename desc;
-- mybatis  xml   <select>

--  단일행 함수
SELECT UPPER(ename), LOWER(ename)  FROM emp;
SELECT * FROM emp
	WHERE lower(ENAME) = lower('scott');

SELECT ename,LENGTH(ename), LENGTHB(ename)  FROM emp;

SELECT concat(ename,job) FROM emp;

SELECT ename || job AS "이름과 직업" FROM emp;

SELECT substr(job,1,3) || '...' FROM emp;

SELECT substr('oracle database 21c release',1,10) FROM dual; 

--문자열 검색
SELECT * FROM EMP 	
	WHERE ename LIKE '____S%';

SELECT '010-1111-2222' AS original ,
	REPLACE('010-1111-2222','-','') AS tel FROM dual;

SELECT 'oracle', LPAD('oracle',10,'#') FROM dual;
SELECT 'oracle', RPAD('010-2582-',13,'#') FROM dual;
SELECT trim('   abcd   ') FROM dual;
SELECT ltrim('   abcd   ') FROM dual;
SELECT rtrim('   abcd   ') FROM dual;

-- round, ceil, floor , trunc
SELECT round(1234.5678,0) FROM dual;
SELECT round(1234.5678,-1) FROM dual;

SELECT ceil(1234.1678), floor(1234.9876) FROM dual;

-- trunc의 단점 oracle에서만 사용 가능
SELECT trunc(1239.5678,-1) FROM dual;

SELECT sysdate FROM dual;
SELECT sysdate - 1 AS "어제" FROM dual;
SELECT sysdate + 1 AS "내일" FROM dual;


-- 형변환 함수
INSERT INTO EMP (empno, hiredate) VALUES 
('7777',TO_DATE('19901220','YYYY-MM-DD'));

SELECT * FROM emp;
ROLLBACK;


--char()
--varchar2()
--number()
--long()
--clob()
--blob()
--date()

SELECT sysdate, TO_CHAR(sysdate,'YYYY/MONTH/DD HH24:MI:SS', 
'NLS_DATE_LANGUAGE = ENGLISH') FROM dual; 

SELECT sysdate, TO_CHAR(sysdate,'YYYY/MONTH/DAY HH24:MI:SS', 
'NLS_DATE_LANGUAGE = ENGLISH') FROM dual;

SELECT TO_CHAR(01234,'99999') AS "9999" FROM dual;
SELECT TO_CHAR(0.45,'0.99') AS "9999" FROM dual;

SELECT NVL2(comm,sal*12+comm,sal*12) FROM emp; 


-- 오라클에서 쓰는 조건문  decode, case when
SELECT ename,job,sal,
       CASE job
       	WHEN 'SALESMAN' THEN sal*1.1
       	WHEN 'MANAGER'  THEN sal*1.5
       	ELSE sal*1.15
       END AS "인상된 월급"
FROM emp;

SELECT ename,job,sal,
       decode(job,
       	'SALESMAN',sal*1.1,
       	'MANAGER',sal*1.5,
       	sal*1.15)
        AS "인상된 월급"
FROM emp;


--다중행 함수
SELECT SUM(sal) FROM emp;

SELECT sum(sal), min(sal), max(sal), FROM emp;

SELECT SUM(sal) FROM emp WHERE DEPTNO =10 UNION ALL 
SELECT SUM(sal) FROM emp WHERE DEPTNO =20 UNION ALL
SELECT SUM(sal) FROM emp WHERE DEPTNO =30 ;

SELECT DEPTNO ,SUM(sal) FROM emp GROUP BY DEPTNO;

SELECT deptno ,avg(sal) FROM emp GROUP BY DEPTNO HAVING avg(sal) >2000;

SELECT count(*) FROM emp;

SELECT deptno, count(*) AS count ,MAX(sal) AS max,MIN(sal) AS min,
AVG(sal) AS 평균, sum(sal) AS sum FROM emp GROUP BY DEPTNO ORDER BY DEPTNO;

--join 
SELECT *FROM emp e, DEPT d
WHERE e.DEPTNO =d.DEPTNO;

SELECT ENAME , EMPNO , d.*  FROM emp e join DEPT d
on e.DEPTNO =d.DEPTNO
WHERE SAL >=3000;

SELECT * FROM emp e,SALGRADE s 
WHERE sal BETWEEN losal(+) AND hisal(+);

SELECT * FROM emp e left JOIN SALGRADE s 
on sal BETWEEN losal AND hisal;
--outer join
SELECT e.empno, e.ename,d.DEPTNO ,d.DNAME  FROM emp e, DEPT d
WHERE e.DEPTNO(+) = d.DEPTNO;

SELECT e.empno, e.ename,d.DEPTNO ,d.DNAME  FROM emp e full join DEPT d
on e.DEPTNO = d.DEPTNO;

SELECT e.empno, e.ename,d.DEPTNO ,d.DNAME  FROM emp e, DEPT d
WHERE e.DEPTNO(+) = d.DEPTNO UNION 
SELECT e.empno, e.ename,d.DEPTNO ,d.DNAME  FROM emp e, DEPT d
WHERE e.DEPTNO = d.DEPTNo(+);

--self join
SELECT e1.ename,e1.ENAME ,e1.MGR ,e2.EMPNO AS "매니저 번호" ,e2.ENAME AS "매니저 이름"  
FROM EMP e1 ,EMP e2
WHERE e1.mgr = e2.EMPNO(+);

SELECT e1.ename,e1.ENAME ,e1.MGR ,e2.EMPNO AS "매니저 번호" ,e2.ENAME AS "매니저 이름"  
FROM EMP e1 LEFT JOIN EMP e2
on e1.mgr = e2.EMPNO;

-- insert update delete

CREATE TABLE EMP02 AS 
	SELECT * FROM emp WHERE 2=1;  --형식만 가지고 오고 싶을 땐 조건절을 거짓으로 함
SELECT *FROM EMP02 e ;
DROP TABLE EMP02;

INSERT INTO emp02 VALUES(1111,'kkk','MANAGER',2222,sysdate, 2300,'',10); 
INSERT INTO emp02 (empno) VALUES(2222);
--데이터 변경
UPDATE EMP02 SET EMPNO =3333 WHERE EMPNO =2222; 
--데이터 삭제
DELETE FROM emp02 WHERE EMPNO =3333;
COMMIT;
ROLLBACK;

--제약조건
CREATE TABLE kkkk (
	NO NUMBER(3) PRIMARY KEY,
	name varchar2(30) NOT NULL,
	job varchar2(30),
	phone varchar2(32) NOT NULL UNIQUE,
	depno NUMBER(2) REFERENCES dept(deptno)
);

ALTER TABLE kkkk ADD joinDATE DATE DEFAULT sysdate;
-- email 추가
ALTER TABLE kkkk ADD email varchar2(40) DEFAULT 'null@null.com' NOT NULL;
ALTER TABLE kkkk MODIFY email varchar2(150); --변경
--ALTER TABLE kkkk DROP column email 삭제
select *FROM KKKK;
DROP TABLE kkkk;

INSERT INTO kkkk VALUES(1,'김혁기','','010-1111-2222',10);
INSERT INTO kkkk VALUES(kkk_seq.nextval,'김혁기','','010-1111-2222',20);

CREATE SEQUENCE kkk_seq
		INCREMENT BY 1
		START WITH 1
		MINVALUE  1
		MAXVALUE 9999
		nocycle
		nocache
;
ALTER SEQUENCE kkk_seq MAXVALUE 999999;
SELECT max(NVL(NO,0))+1 FROM kkkk;

----member table 만들기 ----
--id(pk),password(nn),name(nn),gender(nn),birthday,email(nn,uq),tel(nn,uq),address,regdate DEFAULT sysdate

CREATE TABLE member(
			id varchar2(20) PRIMARY KEY,
			password varchar2(20) NOT NULL,
			name varchar2(10) NOT NULL,
			gender varchar2(6) NOT NULL,
			birthday number(6),
			email varchar2(30) NOT NULL UNIQUE,
			tel varchar2(13) NOT NULL UNIQUE,
			address varchar2(50),
			regdate DATE DEFAULT sysdate
			);
SELECT *FROM MEMBER;
ALTER TABLE MEMBER modify birthday DATE  ; 
ALTER TABLE MEMBER ADD no number(4) UNIQUE;
ALTER TABLE MEMBER MODIFY id visible;
DROP TABLE MEMBER;
INSERT INTO MEMBER VALUES('kkkk','1234','유재석','남자','881102','kkkk@naver.com','010-1111-2222',
							'서울시 강남구 삼성동','');
INSERT INTO MEMBER VALUES('aaaa','1234','정형돈','남자','901202','aaaa@naver.com','010-2222-3333',
							'경기 성남시 분당','');
INSERT INTO MEMBER VALUES('bbbb','1234','홍진경','여자','890202','bbbb@naver.com','010-2222-4444',
							'대전시 수성구',default);


						