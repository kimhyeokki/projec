CREATE OR REPLACE VIEW V_emp01
AS
SELECT empno, ename, hiredate FROM emp;
--view를 생성하려면 권한을 받아야함 (create view to scott)

SELECT *FROM V_emp01;

--quiz view 생성해라
-- empno, empno,job,deptno 20번 부서 사람만!!

CREATE OR REPLACE VIEW V_emp02
AS
SELECT empno, ename, job, deptno FROM emp WHERE DEPTNO =20;
SELECT *FROM V_EMP02 ;

--view table 조회
SELECT *FROM user_views;

DROP VIEW V_emp02;

--연봉 상위 5명 
--rownum 이라는 가상 컬럼명을 이용한다. 순서를 매겨주는 
SELECT ROWNUM, e.* FROM EMP e WHERE rownum <=5;;
SELECT rownum, e.* FROM EMP e WHERE rownum <= 5 ORDER BY sal DESC; --결과값이 이상함 그래서 서브쿼리를 이용해서 해결
--서브쿼리 (연봉 상위 5명)
SELECT rownum, e.* FROM (SELECT *FROM emp ORDER BY sal DESC) e WHERE rownum BETWEEN  1 AND 6;

--입사일 빠른 순서 5명
SELECT rownum, e.* FROM (SELECT *FROM emp ORDER BY hiredate) e WHERE rownum <=5;

SELECT *FROM (
		SELECT rownum AS num, e.* FROM 
		(SELECT *FROM emp ORDER BY sal DESC) e)
		WHERE num >=3 AND num <=5;
--rownum 은 가상이고 1부터 무조건 시작함 --> 그래서 rownum 쿼리에 바깥에 쿼리를 씌운다 그러면 1이 아닌 다른 범위도 활용가능 
                                  -- 예악어인 rownum 을 쓰는 것 보단 AS를 활용해서 별칭을 붙이는게 좋다.
SELECT  *FROM EMP;	


SELECT *FROM EMP e  WHERE sal > (SELECT sal FROM emp WHERE ename='JONES');
SELECT *FROM emp e WHERE HIREDATE > (SELECT HIREDATE FROM emp WHERE ename = 'SCOTT');

SELECT *FROM emp WHERE DEPTNO IN(20,30);
-- 각 부서의 최고 월급 제일 많이 받는 사람
SELECT *FROM emp WHERE sal IN (SELECT max(sal) FROM emp GROUP BY DEPTNO); --서브쿼리에서 IN은 결과값을 모두 반환
-- ANY some는 하나라도 참이면 참
-- ALL 은 전부 만족해야 
SELECT *FROM emp WHERE sal = any (SELECT max(sal) FROM emp GROUP BY DEPTNO); 
-- > ANY 서브쿼리 중 최솟값을 반환
-- < ANY 서브쿼리 중 최댓값을 반환

--quiz01 
-- 1. 전체 사원 중 allen과 같은 직책인 
SELECT e.job, e.EMPNO , e.sal, e.DEPTNO ,d.DNAME  FROM emp e JOIN DEPT d 
ON e.deptno = d.DEPTNO
WHERE job =(SELECT job FROM emp WHERE ENAME='ALLEN');

-- 2. 전체 사원의 평균 급여보다 높은 급여를 받는 사원드르이 정보
SELECT e.job, e.EMPNO , e.sal, e.DEPTNO ,d.DNAME,d.LOC  FROM emp e JOIN DEPT d 
ON e.deptno = d.DEPTNO
WHERE sal > (SELECT avg(sal) FROM emp);

-- 3. 10번 부서 근무하는 사원중  30번 부서에는 존재하지 않는 직책을 가진 사원들의 정보
SELECT e.job,e.ENAME,e.EMPNO , e.sal, e.DEPTNO ,d.DNAME,d.LOC  FROM emp e JOIN DEPT d 
ON e.deptno = d.DEPTNO
WHERE e.DEPTNO =10 and job NOT IN (SELECT job FROM emp WHERE DEPTNO=30);  --> 서브 쿼리에서 이 결과값은 10부서에 있는 모든 직업들.
                                                         -- IN(결과값 : 직업들...), IN은 결과값 모두를 반환

-- 4. 직책이 salesman인 사람들의 최고 급여보다 높은 급여를 받는 사원들의 정보및 급여 등급
SELECT e.ENAME,e.EMPNO , e.sal, e.DEPTNO, e.job,s.GRADE  
FROM emp e left join SALGRADE s  -- OUTER JOIN 정보를 모두 출력하고 싶을때
ON e.sal BETWEEN s.LOSAL AND s.hisal      -- 이조건에 만족하지 않은 정보까지 출력해줌
WHERE sal > (SELECT max(sal) FROM emp WHERE job='SALESMAN');  

SELECT * FROM EMP e ;
SELECT * FROM SALGRADE s ;