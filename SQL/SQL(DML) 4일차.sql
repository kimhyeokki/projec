--DML
--CREATE는 auto commit 롤백사용X
CREATE TABLE emp02 AS SELECT * FROM emp; --emp 테이블을 emp02 복사
SELECT *FROM emp02;

DROP TABLE emp02 CASCADE CONSTRAINTS;

--테이블의 컬럼만 가지고 올때  where절 뒤에는 거짓인 조건을 적는다
CREATE TABLE emp02 AS SELECT *FROM emp WHERE 1 <> 1;
           --한글 허용
CREATE TABLE my_table (NO NUMBER(3), 
					   name varchar2(4),
					   birth date);
SELECT *FROM MY_TABLE;
-- sequence 
-- insert,delete 는 롤백(되돌리기) ,커밋(저장) 사용해야함
INSERT INTO MY_TABLE (NO,name,birth) values(100,'kkk',sysdate);
INSERT INTO MY_TABLE (NO,name,birth) values(101,'aaa',sysdate);
INSERT INTO MY_TABLE (NO,name) values(102,'bbb');
INSERT INTO MY_TABLE (NO,name) values(103,'ccc');
INSERT INTO MY_TABLE  values(104,'ddd','1999-11-11');
INSERT INTO MY_TABLE  values(105,'eee',TO_DATE('09-11-1987','dd-mm-yyyy'));

COMMIT;
UPDATE MY_TABLE SET name='vvv', birth = sysdate WHERE NO=103;
DELETE FROM MY_TABLE WHERE NO=103;

--qiuz
--1. dept02를 구조만 배껴와서 하나 만들고
CREATE TABLE dept02 AS SELECT *FROM DEPT d WHERE 2=1;
SELECT *FROM dept02;
INSERT INTO dept02 VALUES(50,'css','jeju');
INSERT INTO dept02 VALUES(70,'c##','deagu');
INSERT INTO dept02 VALUES(60,'java','ilsan');
INSERT INTO dept02 VALUES(80,'oracle','busan');

--2. emp02를 데이터에서 복사해서 30번 부서에서 근무하는 사원들의 평균 급여보다 많은 급여를 받는
-- 사원들을 50번 부서로 바꾸시오
CREATE TABLE emp02 AS SELECT *FROM emp;
SELECT * FROM emp02;
UPDATE emp02 SET deptno=50 WHERE sal >(SELECT avg(sal) FROM emp02 WHERE deptno=30);

--3. emp02 10번 부서에서 근무하는 사원 중 입사일이 가장 빠른 사원보다 늦게 입사한 사원의 급여를 10%인상하고 60번으로 옮기시오
--?? 잘모르겠음 => 서브 쿼리를 사용해서 조건을 사용한다.
UPDATE emp02 SET sal=sal*1.1, deptno=60 
WHERE hiredate >(SELECT min(hiredate) FROM emp02 WHERE deptno=10);
SELECT * FROM emp02;

--4 emp02에서 salgrade 5인 사원을 삭제하시오
--DELETE FROM emp02 WHERE  
--(SELECT empno FROM EMP e , SALGRADE s WHERE e.SAL BETWEEN losal AND hisal AND s.GRADE =5); 

SELECT empno FROM EMP02 e , SALGRADE s 
WHERE e.SAL BETWEEN s.losal AND s.hisal AND s.GRADE =5;
--join 예습
--32
SELECT ename, e.deptno,d.dname FROM EMP e ,DEPT d 
WHERE e.DEPTNO =d.DEPTNO  AND ENAME ='SCOTT';
--33
SELECT ename, dname, LOC FROM EMP e JOIN DEPT d
ON e.DEPTNO =d.DEPTNO;
--34
SELECT empno,loc,job FROM emp e JOIN DEPT d 
using(deptno) WHERE DEPTNO =10;
--35
SELECT ename,dname,loc FROM emp e NATURAL JOIN DEPT d
WHERE comm IS not NULL;
--36
SELECT ename, dname FROM EMP e ,DEPT d 
WHERE e.DEPTNO =d.DEPTNO AND ENAME LIKE '%A%' AND dname LIKE '%A%';
--37
SELECT ename, job,deptno,dname FROM EMP e  NATURAL JOIN DEPT d
WHERE loc ='NEW YORK';
--38
SELECT e1.ename, e1.empno,e1.mgr,e2.ename FROM EMP e1 JOIN EMP e2
ON e1.mgr =e2.EMPNO;
--39
SELECT e1.ename, e1.empno FROM EMP e1 left JOIN emp e2
ON e1.mgr =e2.EMPNO;
--40
SELECT *FROM emp;
SELECT e1.ename, e1.deptno FROM EMP e1 JOIN EMP e2
ON e1.ENAME =e2.ENAME WHERE e1.DEPTNO =20;
--41
SELECT e1.ename, e1.hiredate FROM EMP e1 JOIN EMP e2
ON e1.ENAME =e2.ENAME WHERE e2.HIREDATE <'1981-02-22'; 
--42
SELECT e1.ename,e1.HIREDATE ,e2.HIREDATE, e2.ENAME  FROM EMP e1 JOIN EMP e2 
ON e1.mgr =E2.EMPNO WHERE e1.HIREDATE < E2.HIREDATE; 
--43 ???
SELECT e1.ename, e1.job FROM EMP e1 JOIN EMP e2
ON e1.ENAME =E2.ENAME;
