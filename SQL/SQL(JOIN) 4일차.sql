--join 에는 여러가지 방식이 존재
--ORACLE JOIN
SELECT * FROM emp,dept
WHERE emp.DEPTNO =dept.DEPTNO;
--ANIS 조인
SELECT * FROM emp e JOIN DEPT d
ON e.DEPTNO = d.DEPTNO;  --테이블도 별명을 부여할 수 있음(편의성)

--컬럼명이 중복일 때 어느 테이블에 컬럼이 들어올지 명확하게 써줘야함!
SELECT empno, ename,SAL , e.deptno, dname, loc FROM emp e JOin dept d
ON e.DEPTNO = d.DEPTNO WHERE SAL >=3000;

SELECT empno, ename, sal, e.deptno, dname, loc FROM emp e, DEPT d
WHERE e.DEPTNO =d.DEPTNO AND sal >=3000;

-- emp에서 월급이 salgrade에 있는 사람들만 출력해보기
SELECT * FROM emp e, SALGRADE s
WHERE e.SAL >=s.LOSAL AND e.SAL <=s.HISAL;
     -- sal between losal and hisal;

--job이 manager dls 사람의 부서번호와 부서 이름 출력 (oracle)
SELECT job, e.DEPTNO ,dname FROM emp e,DEPT d
WHERE e.DEPTNO =d.DEPTNO AND JOB ='MANAGER';
--job이 manager dls 사람의 부서번호와 부서 이름 출력 (ansi)
SELECT ENAME ,job, e.DEPTNO ,dname FROM emp e JOIN DEPT d
on e.DEPTNO =d.DEPTNO WHERE JOB ='MANAGER';

--데이터 넣기
INSERT INTO EMP e(empno,ename,job,mgr,HIREDATE,sal,COMM,DEPTNO)
VALUES (8000,'TIGER','CLERK',NULL,sysdate,1380,NULL,null);
--INSERT INTO EMP e(empno,ENAME)
--VALUES(8000,'michael');
DELETE FROM emp WHERE ename ='TIGER';
SELECT * FROM  EMP e;
ROLLBACK;
COMMIT;

--(left)? outer JOIN 
SELECT empno,ename,e.deptno,dname 
FROM EMP e  -- 메인 테이블
LEFT outer JOIN DEPT d --조인테이블
on e.DEPTNO =d.DEPTNO;

SELECT empno,ename,e.deptno,dname FROM EMP e , DEPT d
WHERE  e.DEPTNO=d.DEPTNO(+) --오라클은 조인테이블에 (+)를 붙인다.
UNION 
SELECT empno,ename,e.deptno,dname FROM EMP e , DEPT d
WHERE  e.DEPTNO(+)=d.DEPTNO;
--오라클은 유니온을 통해서 FULL 사용할 수 있음

--inner join은 겹치는 것만 조회
--outer는 main 은 무조건 출력 join은 조회 용도로만 사용
--outer join의 메인 테이블은 ansi left,right로 결정
--FULL 둘다 출력(left,right) 

--self join
SELECT e1.ENAME, e2.ENAME  FROM emp e1,EMP e2
WHERE  e1.MGR =e2.EMPNO(+);

SELECT e1.EMPNO , e1.ENAME, e1.MGR ,e2.EMPNO AS "매니저 번호",
	e2.ENAME AS "매니저 이름"  FROM emp e1 LEFT outer JOIN EMP e2
on e1.MGR =e2.EMPNO;

--연습문제 --자신의 입사일 보다 먼저 입사한 사람의 인원수를 출력
SELECT e1.empno,e1.ENAME, e1.HIREDATE, count(*) FROM emp e1, emp e2
WHERE e1.HIREDATE > E2.HIREDATE GROUP BY E1.EMPNO ,E1.ENAME ,e1.HIREDATE; 

SELECT e1.empno,e1.ENAME, e1.HIREDATE, count(*) FROM emp e1 join emp e2
on e1.HIREDATE > E2.HIREDATE GROUP BY E1.EMPNO ,E1.ENAME ,e1.HIREDATE;

WITH emp as(
	SELECT 1111 empno, 'KING' ename, 'PRESIDENT' job,NULL mgr, 90 deptno, 13 locno FROM dual UNION ALL
	SELECT 1111 empno, 'BLAKE' ename, 'MANAGER' job,1111 mgr, 30 deptno, 11 locno FROM dual UNION ALL
	SELECT 2222 empno, 'CLARK' ename, 'MANAGER' job,NULL mgr, 10 deptno, 13 locno FROM dual UNION ALL
	SELECT 3333 empno, 'SCOTT' ename, 'MANAGER' job,NULL mgr, 20 deptno, 12 locno FROM dual
), 
dept as(
	SELECT 10 deptno, 'CEO' dname,  13 locno FROM dual UNION ALL
	SELECT 20 deptno, 'IT' dname,   11 locno FROM dual UNION ALL
	SELECT 30 deptno, 'SALES' dname, 13 locno FROM dual UNION ALL	
	SELECT 40 deptno, 'DB' dname,   12 locno FROM dual
),
loc as(
	SELECT 11 locno, 'seoul' locname   FROM dual UNION ALL
	SELECT 12 locno, 'bundang' locname FROM dual UNION ALL
	SELECT 13 locno, 'ilsan' locname FROM dual 
)
SELECT empno, ename, e.job, d.deptno, d.dname, l.locno, l.locname FROM emp e
JOIN DEPT d ON e.deptno = d.DEPTNO
JOIN loc l ON e.locno = l.locno; 

--quiz
--1.급여가 2000초과 인 사원들의 부서 정보 사원 정보 출력
SELECT d.DEPTNO,dname, empno, ename, sal FROM DEPT d , EMP e
WHERE d.DEPTNO = e.DEPTNO(+) AND  e.SAL(+) >2000 ORDER BY DEPTNO;

SELECT d.DEPTNO,dname, empno, ename, sal FROM DEPT d LEFT outer join EMP e
on d.DEPTNO = e.DEPTNO WHERE e.SAL >2000 ORDER BY DEPTNO;

--2 각 부서별 평균 급여 최대,최소,사원수
SELECT d.DEPTNO,d.dname,
ROUND(avg(sal))AS 평균급여,
max(sal) AS 최대급여,
Min(sal)AS 최소급여,
count(*) AS 사원수 
FROM DEPT d, EMP e 
WHERE  d.DEPTNO =e.DEPTNO 
GROUP BY d.DEPTNO ,d.DNAME ORDER BY DEPTNO;

SELECT d.DEPTNO,dname,
ROUND(avg(sal)) AS 평균급여
,max(sal),Min(sal)
,count(*) FROM DEPT d join EMP e 
on  d.DEPTNO =e.DEPTNO GROUP BY d.DEPTNO ,d.DNAME ORDER BY DEPTNO;
-- ==using(deptno)

--3 모든 부서 정보와 사원 정보를 아래와 같이 출력 (outer join 활용해서 모두 출력했다)
SELECT d.DEPTno, dname, empno, ename, job, sal 
FROM DEPT d , EMP e 
WHERE d.DEPTNO =e.DEPTNO(+) 
ORDER BY d.DEPTNO ,ename;

SELECT d.DEPTno, dname, empno, ename, job, sal 
FROM DEPT d 
LEFT join EMP e 
on d.DEPTNO =e.DEPTNO 
ORDER BY d.DEPTNO, ename;

--4 모든 부서 정보, 사원 정보 급여 등급  각 사원 직속 상관의 정보를 부서번호, 사원 번호 순서로 정렬
SELECT d.deptno,d.dname,
e1.empno,e1.ename,e1.mgr,e1.sal, e1.deptno,
losal,hisal,grade,
e2.empno,e2.ename
FROM emp e1, emp e2, DEPT d, SALGRADE s
WHERE e1.DEPTNO(+) = d.DEPTNO  AND
 e1.sal BETWEEN losal(+) AND hisal(+)
 AND e1.mgr = e2.EMPNO(+);


SELECT d.deptno,dname, e1.empno,e1.ename,e1.mgr,e1.sal, e1.deptno,
losal,hisal,grade,e2.empno,e2.ename
FROM EMP e1 RIGHT join DEPT d 
ON e1.DEPTNO =d.DEPTNO 
LEFT join SALGRADE s
ON e1.sal BETWEEN losal AND hisal
LEFT JOIN emp e2
ON e1.mgr =e2.EMPNO
ORDER BY d.DEPTNO; 