--decode
WITH temp as(
	SELECT 'male' gender FROM dual UNION ALL
	SELECT 'female' gender FROM dual UNION ALL
	SELECT 'X' gender FROM DUAL 
	)
SELECT gender, DECODE(gender,'male','남자','female','여자','X','기타') gender02  FROM temp; 
SELECT job,DECODE(JOB,'CLERK','사원','ANALYST','분석가','SALESMAN','영업') FROM emp;

--SALESMAN 10%,MANAGER 5%,ANALYST 0% 나머진 3%
SELECT ENAME,JOB,SAL,DECODE(JOB,'SALESMAN',SAL*1.1,'MANAGER',SAL*1.05,
					    'ANALYST',SAL*1,SAL*1.03) AS 인상된월급  FROM EMP;
SELECT ENAME, JOB, SAL,CASE JOB
							WHEN 'SALESMAN' THEN SAL*1.1 
							WHEN 'MANAGER' THEN SAL*1.05
							WHEN 'ANALYST' THEN SAL*1 
							ELSE SAL*1.03 
							END AS "인상된 월급" FROM EMP; 	
--10번이면 location 부산 20번이면 분당, 30번이면 서울
SELECT ename, DEPTNO, DECODE(DEPTNO, 10,'부산',20,'분당',30,'서울') AS 위치  FROM emp;
SELECT ename, deptno, CASE deptno
						WHEN 10 THEN '부산'
						WHEN 20 THEN '분당'
						WHEN 30 THEN '서울'
						END AS 위치
						FROM emp;
SELECT ename, sal, CASE 
						WHEN sal >= 2900 THEN '다이아'
						WHEN sal >= 2700 THEN '에메'
						WHEN SAL >= 2000 THEN '골드'
						ELSE '실버'
						END AS "등급"
						FROM emp;		
SELECT ename, comm, CASE   
						WHEN COMM IS NULL THEN '해당사항없음'
						WHEN COMM=0 THEN '커미션 없음'
						WHEN COMM>0 THEN '커미션 :' ||COMM 
						END AS COMMKOR
FROM emp;

--다중행 함수
SELECT  sal FROM emp;
SELECT SUM(sal),COUNT(SAL) FROM emp; 
SELECT SUM(sal), sum(DISTINCT SAL) FROM emp;
SELECT AVG(sal), AVG(COMM), avg(NVL(COMM,0)), count(COMM) FROM EMP;

SELECT  MAX(sal),Min(sal) FROM emp;
SELECT  MAX(HIREDATE),MIN(HIREDATE)  FROM emp ;
--부서번호 30번인 평균 월급,(10,20,30)
SELECT DEPTNO ,AVG(sal) FROM emp GROUP BY DEPTNO;
--직업별 월급 합계
SELECT JOB , SUM(SAL)  FROM emp GROUP BY JOB ;
--GROUP BY 먼저 그룹화 한다음 select 구절을 실행함
--직업별 평균
SELECT DEPTNO ,job, avg(sal) FROM emp GROUP BY JOB, DEPTNO ORDER BY DEPTNO;
--월급에 커미션 포함한 것을 부서별로 출력
SELECT DEPTNO,JOB  ,SUM(sal) AS sal , SUM(sal +NVL(COMM,0))  FROM EMP e 
			GROUP BY DEPTNO,job ORDER BY DEPTNO DESC;
-- where -> group by -> having -> order by(정렬은 마지막에)
SELECT DEPTNO, AVG(SAL)  FROM emp WHERE DEPTNO =10 GROUP BY DEPTNO
HAVING AVG(sal) >2000;
--부서번호, 직업, 평균월급 출력 월급은 3000이상는 제외하고 평균 월급이 2000이상인 출력 deptno로 정렬
SELECT DEPTNO , job, AVG(sal)  FROM EMP e WHERE SAL <=3000 GROUP BY DEPTNO,job 
HAVING AVG(sal) >2000 ORDER by DEPTNO ; 
--아이디 중복 확인하기
SELECT * FROM emp;
SELECT  COUNT(*) AS result FROM emp WHERE  ename ='SCOTT';

SELECT  deptno, NULL job, count(*),MAX(sal),SUM(sal),AVG(sal) FROM emp
GROUP BY DEPTNO  UNION ALL 
SELECT  deptno, job, count(*),MAX(sal),SUM(sal),AVG(sal) FROM emp
GROUP BY DEPTNO , JOB  
UNION ALL
SELECT  null deptno, null job, count(*),MAX(sal),SUM(sal),AVG(sal) FROM emp
ORDER BY deptno;

SELECT  deptno, job, count(*),MAX(sal),SUM(sal),AVG(sal) FROM emp
GROUP BY ROLLUP (DEPTNO ,JOB) ORDER BY DEPTNO ,JOB ;  
--소계 ROLLUP(DEPTNO, JOB)의 순서 1. DEPTNO 그룹집계, 2.DEPTNO, JOB 그룹집계, 3. 전체그룹집계

--GROUPING();
SELECT  DECODE(GROUPING(job),1,'합계',JOB) AS JOB ,DEPTNO AS 부서,
SUM(sal) FROM emp
GROUP BY ROLLUP (JOB,DEPTNO) ORDER BY DEPTNO ,JOB ;

--grouping set: job, deptno 분리해서 보여줌
SELECT job, deptno, COUNT(*) AS count, SUM(sal) FROM EMP 
GROUP BY GROUPING SETS(job,DEPTNO)  
ORDER BY JOB ,DEPTNO;
--ROLLUP : 둘다 묶어서 소계, 합계 출력해줌
SELECT job, deptno, COUNT(*) AS count  FROM EMP 
GROUP BY ROLLUP (job,DEPTNO)  
ORDER BY JOB ,DEPTNO;

SELECT  job, mgr, deptno, COUNT(*) AS count 
FROM EMP
GROUP BY GROUPING SETS((job,mgr),(JOB,DEPTNO));

SELECT  job, deptno, COUNT(*) AS count 
FROM EMP
GROUP BY GROUPING SETS((JOB,DEPTNO),());  --이경우에는 합계가 나옴

--나올 수 있는 경우의 수 다 따져 준다.
SELECT job, DEPTNO, SUM(sal) FROM EMP e 
GROUP BY CUBE(JOB,DEPTNO) ;
-- cube, rollup 차이점
SELECT job, DEPTNO, SUM(sal) FROM EMP e 
GROUP BY ROLLUP (JOB,DEPTNO) ;

-- 문자 연결해서 출력
SELECT LISTAGG(ename,'//') WITHIN GROUP(ORDER BY ename) AS 이름 FROM emp --WITHIN GROUP() 가로로 그룹화 하고 싶을때
WHERE job IN('CLERK','MANGER');--IN(a,b) : a이거나 b인 

--버전이 낮은데서 사용 x (19c 이상 사용가능)
SELECT LISTAGG(DISTINCT DEPTNO ,'//') WITHIN GROUP(ORDER BY DEPTNO) AS 부서번호 FROM emp; 

--pivot() columm -> row
SELECT * FROM (SELECT job, TO_CHAR(HIREDATE,'mm') || '월' hiremonth FROM emp) --서브쿼리라고 함
PIVOT(
	count(*) FOR hiremonth in('1월','2월','3월','4월','5월','6월',
	'7월','8월','9월','10월','11월','12월')	
);

--quiz01 
--부서별 평균 월급(소수점 버리기), 최고 월급 ,최저월급, 부서별 인원 수를 출력
SELECT deptno, TRUNC(AVG(SAL)) AS 평균월급,
			   MAX(SAL) AS 최고월급, min(SAL) AS 최소월급,
			   COUNT(DEPTNO) AS 인원  FROM emp GROUP BY DEPTNO;

--quiz02
--직책별 인원수가 3명 이상인 것만 출력
SELECT job, count(JOB) FROM EMP GROUP BY job HAVING COUNT(job) >= 3;

--quiz03
--각 부서별 년도별 입사 인원을 출력
SELECT deptno,TO_CHAR(hiredate,'YYYY') AS "입사한 연도",count(DEPTNO)  FROM EMP e 
GROUP BY DEPTNO,TO_CHAR(hiredate,'YYYY')
ORDER BY DEPTNO; 

--quiz04
--커미션이 있는 것과 없는 경우를 카운팅해서 출력하시오
SELECT NVL2(comm,'o','x'), COUNT(*) FROM emp GROUP BY NVL2(comm,'o','x'); 

--quiz05
--각 부서의 년도별 입사인원과 최고 월급, 월급의 합 월급의 평균을 소계별로 출력하시오
SELECT deptno, TO_CHAR(hiredate,'YYYY') AS 연도 ,
		count(*), MAX(SAL) ,ROUND(AVG(SAL),1)  
		FROM emp 
GROUP BY ROLLUP(DEPTNO,TO_CHAR(hiredate,'YYYY')) 
ORDER by DEPTNO;

SELECT max(sal+NVL(COMM,0)),min(sal+NVL(COMM,0)),round(AVG(sal+NVL(COMM,0)),1)  FROM EMP e;
SELECT DEPTNO, SAL, sum(sal)over(ORDER BY DEPTNO,SAL)  FROM emp GROUP BY ROLLUP(DEPTNO,SAL); 

--예습01
SELECT ename, sal, sal+300 FROM emp;

--예습02
SELECT ename,SAL ,SAL*12+100 FROM emp ORDER BY SAL;
--예습03
SELECT ename, SAL  FROM emp WHERE SAL>2000 ORDER BY SAL DESC ;
--4
SELECT ename,deptno FROM EMP WHERE EMPNO=7788;
--5
SELECT ename, sal FROM EMP WHERE sal<2000 or sal>3000;
--6
SELECT ename,job,hiredate FROM EMP WHERE HIREDATE  BETWEEN '1981-02-20' AND '1981-05-01';
--7
SELECT ename, deptno FROM EMP WHERE DEPTNO IN(20,30) ORDER BY ENAME DESC ;
--8
SELECT ename, sal, deptno FROM emp WHERE sal BETWEEN 2000 AND 3000 AND DEPTNO IN(20,30)ORDER BY ENAME; 
--9
SELECT ename, TO_CHAR(hiredate,'YY/mm/dd') AS 입사일  FROM emp WHERE hiredate LIKE '%81%';
--10
SELECT  ename, job FROM emp WHERE mgr IS NULL;
--11
SELECT ename, job,comm FROM EMP WHERE comm IS NOT NULL AND comm !=0 ORDER BY COMM ;
--12
SELECT ename FROM emp WHERE ENAME LIKE '__R%';
--13
SELECT ename FROM emp WHERE ENAME LIKE '%A%E%';
--14
SELECT ename, job,sal FROM EMP WHERE JOB IN('CLERK','SALESMAN') AND sal not IN(1600,950,1300);
--15
SELECT  ename, sal, comm FROM emp WHERE comm>=500;
--16
SELECT ename, SUBSTR(hiredate,1,2), substr(hiredate,4,2) FROM EMP;
--17
SELECT * FROM emp WHERE SUBSTR(HIREDATE,4,2)=04;
--18
SELECT *FROM emp WHERE MOD(empno,2)=0;
--19
SELECT TO_CHAR(hiredate,'YY'),TO_CHAR(hiredate,'mm'),TO_CHAR(hiredate,'dy') FROM emp;
--20
SELECT TO_char(SYSDATE ,'ddd'),SYSDATE -TO_DATE('2023-01-01','yyyy-mm-dd') FROM emp;
--21
SELECT NVL2(MGR,MGR,0) FROM emp;
--22
SELECT ename,sal,DECODE(JOB,'ANALYST',sal+200,'SALESMAN',SAL+180,
'MANAGER',sal+150,'CLERK',sal+100,sal) AS 인상된월급 FROM emp;
--23
SELECT MAX(sal),MIN(sal),SUM(sal), ROUND(AVG(sal)) FROM EMP e ;  
--24
SELECT job, MAX(sal),MIN(sal),SUM(sal), ROUND(AVG(sal)) FROM emp GROUP BY JOB; 
--25
SELECT job, count(*) FROM emp GROUP BY job;
--26
SELECT count(JOB) FROM emp WHERE JOB ='MANAGER';
SELECT * FROM emp;
--27
SELECT MAX(sal),MIN(sal),MAX(sal)-MIN(sal) FROM emp;