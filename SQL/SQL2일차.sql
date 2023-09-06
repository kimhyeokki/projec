SELECT *FROM  EMP e; --
SELECT ENAME AS "이름" FROM EMP;
SELECT ename||'==='||job||'입니다'AS "이름 / 직업" FROM EMP;
SELECT ename||'''s'||job AS "이름 / 직업" FROM emp;

SELECT  *FROM  EMP WHERE ENAME  LIKE '%S%';
--SQL 함수() 단일행 /복수행 
--단.1 문자형 함수
SELECT ename, INITCAP(ENAME) AS "첫글자만 대문자"  FROM EMP;
SELECT ename AS "대문자", lower(ENAME) as"소문자"  FROM EMP;
SELECT UPPER(ename)  AS "대문자" FROM EMP ;

SELECT *FROM EMP WHERE LOWER(ENAME)=LOWER('scOtt');
--DUAL 가짜 테이블, dummy용 테이블
SELECT  LENGTH('scott') FROM dual;
-- 한글의 경우 인코딩에 따라 2바이트or3바이트로 출력 지금은 3바이트,영어는 length, lengthb 값이 같음
SELECT  LENGTH('김혁기') AS "문자열 길이",  LENGTHB('김혁기') AS "길이를 바이트로표현"  FROM DUAL ;
--이름의 자릿수 출력 ex 이름,자릿수
SELECT ename , LENGTH(ename) FROM EMP e; 
--concat() :문자열 결합 ,변수는 두개만 허용
SELECT  CONCAT(ename,job) FROM EMP; 
SELECT ename||job FROM EMP ; -- <=이걸 많이 사용
--substr (문자,A,B) : 문자의 A번째에서 B갯수만큼 문자 출력
SELECT job,SUBSTR(job,1,2) FROM EMP e ; 
SELECT SUBSTR('scottbrsdfsdfsdfave',1,10)||'.....' AS "title" FROM DUAL ;
SELECT SUBSTR('scott',-2) FROM DUAL ;
SELECT SUBSTR(job,-3)  FROM EMP; --뒤에서 3개만 출력함
SELECT job, SUBSTR(job,-3)  FROM EMP; --뒤에서 3개만 출력함
SELECT REGEXP_INSTR('oracle database 21c release','ac|ab|ac') FROM dual; -- ac OR ab OR ac
SELECT REGEXP_INSTR('oracle database 21c release','[0-9]') FROM dual; --문자열안에 숫자가 있는지 확인을 위해
SELECT REGEXP_INSTR('oracle database 21c release','.') FROM dual; --.은 모든 문자
SELECT REGEXP_INSTR('oracle 데이터 베이스이다. 21c release','[가-힣]') FROM dual; -- [-] : 범위
SELECT REGEXP_INSTR('oracle database 21c release','[a-z]') FROM dual;
SELECT REGEXP_INSTR('oracle database 21c release','[^a-z]') FROM dual; -- [^a-z] 은 공백을 의미
SELECT REGEXP_INSTR('oracle database [21c] release','\[21c\]') FROM dual; --'\' : 특수문자 찾을 때
SELECT REGEXP_INSTR('oracle database 21c release','^oracle') FROM dual; --^abc.. : abc.. 로 시작하는지 위치
SELECT REGEXP_INSTR('oracle database 21c release','^data') FROM dual; --결과값은 0임
SELECT REGEXP_INSTR('oracle database 21c release','release$') FROM dual; 
-- abc$ : abc로 끝나는지 확인 후 abc중 첫번째 위치가 결과값을가진다

SELECT *FROM EMP e WHERE ENAME LIKE '%S%';
 SELECT INSTR(ENAME,'S') FROM  EMP;
SELECT * FROM  EMP WHERE INSTR(ENAME,'S')>0;

--replace()
SELECT '010-1111-2222' AS "오리지널", REPLACE ('010-1111-2222','-','/') AS "- 를 / 로 대체" FROM dual;
SELECT '010-1111-2222' AS "오리지널", REPLACE ('010-1111-2222','-') AS "- 를 삭제" FROM dual;

--lpad(),rpad()
SELECT 'oracle',LPAD('oracle',10,'*') FROM dual; --LorRPAD('문자 A',숫자 B,'문자 C') : A의 왼쪽/오른쪽 (B-A)크기의 자릿수를 C로 채워넣는다
SELECT 'oracle',RPAD('oracle',10,'*') FROM dual;
SELECT '881122-1122334',RPAD('881122-1',14,'*') FROM dual;
SELECT '010-2222-3214',RPAD('010-2',12,'*') FROM dual;
--ename의 뒤에 두글자만 남기고 앞은 전부 *로 채우기
SELECT ENAME ,LPAD(SUBSTR(ENAME,-2),LENGTH(ENAME),'*') FROM EMP;
SELECT ENAME ,rPAD(SUBSTR(ENAME,1,2),LENGTH(ENAME),'*') FROM EMP;

--trim() :왼쪽이나 오른쪽의 공백을 제거
SELECT '      oracle database    ' AS trim FROM dual;
SELECT TRIM(' oracle database ') FROM dual;
--lefttrim(),righttrim()
SELECT REPLACE('    oracle database   ',' ','') FROM dual;  -- =약간 비슷 trim()
SELECT LTRIM('0001234','0') FROM dual; --왼쪽의 특정문자 제거 ex) 
SELECT RTRIM('0001234','4') FROM dual; --오른쪽 특정문자 제거

--단일 2. 숫자형 함수
SELECT ROUND(32.1164,2) AS round,
	ROUND(1234.5678) AS round_0,
	ROUND(1234.5678,1) AS round_1,
	ROUND(1234.5678,2) AS round_2 FROM dual;
SELECT ROUND(1234.5678,-1) FROM dual; -- -1이면 1230 결과값 -2이면 1200	
SELECT ROUND(1267.5678,-2) FROM dual; -- 마이너스는 정수를 반올림하여 나타낸다.
--TRUNC() : 소수점 아래를 버린다. *주의할 점 오라클 전용 함수입니다.
SELECT TRUNC(1234.5678,2) FROM dual;

WITH JJang as( SELECT TO_DATE('2023-09-06 12:37:50','YYYY_DD_MM HH24:MI:SS') dt FROM dual)
SELECT dt, TRUNC(dt,'DD') FROM JJang; --with는 임시 데이터를 만들 떄 사용 
--'DD' 뒤에 삭제하고 나머지 출력

--CEIL() : 가까운 정수 중 큰수
SELECT CEIL(13.2),FLOOR(13.2)  FROM dual;
--FLOOR() : 가까운 정수 중 작은수
SELECT CEIL(-1.3),FLOOR(-2.5)  FROM dual;

--MOD() : 나머지 ,실수도 되는듯
SELECT MOD(13,3) FROM dual;
SELECT MOD(13.3,3.13) FROM dual;

--- 날짜 함수 알아보기 ---
SELECT SYSDATE FROM dual; --현재시간을 나타내는 
SELECT SYSDATe -1 AS 어제 FROM dual;
--날짜 표현방식은 '-','/','.','120802','_' 등등 왠만한 특수기호는 가능하는 듯?
SELECT TRUNC(MONTHS_BETWEEN(SYSDATE ,'2012.08.11')) FROM dual;  --두 날짜 사이의 개월 수 알려줌 1개월 미만이면 0.23..

SELECT ADD_MONTHS('22/04/03',2) FROM dual; -- 날짜에 개월수를 추가하거나 뺄수 있음 (날짜,숫자)
SELECT ADD_MONTHS('22/04/03',-4) FROM dual;
-- emp 10주년 되는 날
SELECT  ename,HIREDATE  ,ADD_MONTHS(hiredate,120) AS "10주년" FROM emp; 

--근속연수
WITH num As( SELECT 1111 AS NO,'장성호' AS name, TO_DATE('1990-08-02','YYYY-MM-DD') AS hiredate FROM DUAL
			UNION ALL
			SELECT 1111 AS NO, '장동건' AS name, TO_DATE('2001-09-12','YYYY-MM-DD') AS hiredate FROM DUAL)
SELECT name,TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)/12) AS "근속연수",
			TRUNC( SYSDATE -hiredate ) AS "근속일수" FROM num;

SELECT ename, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)/12) AS 근속연수,
		TRUNC( SYSDATE -hiredate ) AS 근속일수 FROM emp;

SELECT SYSDATE , NEXT_DAY(SYSDATE,'월') FROM dual;
SELECT SYSDATE , LAST_DAY(SYSDATE) FROM dual;  --입력한날짜의 해당 월의 마지막 날짜 출력

SELECT trunc(SYSDATE) FROM DUAL;
SELECT round(SYSDATE,'CC') FROM dual;
SELECT round(SYSDATE,'YYYY') FROM dual;

--형변환 함수
--TO_DATE
SELECT 2+'2' FROM dual;
--char 2000byte()
--varchar2() 4000byte
--number 
--date
--long
--clob(4gb)
--blob(4gb)
-- img()

SELECT TO_CHAR(SYSDATE,'YYYY') AS yyyy,
TO_CHAR(SYSDATE,'YY') AS yy,
TO_CHAR(SYSDATE,'YYYY-MM') AS "yyyy-mm",
TO_CHAR(SYSDATE,'MON') AS "MON",
TO_CHAR(SYSDATE,'MONTH','NLS_DATE_LANGUAGE =ENGLISH') AS "MONTH",
TO_CHAR(SYSDATE,'MONTH','NLS_DATE_LANGUAGE =JAPANESE') AS "MONTH",
TO_CHAR(SYSDATE,'DAY','NLS_DATE_LANGUAGE =ENGLISH') AS DAY,
TO_CHAR(SYSDATE,'DY','NLS_DATE_LANGUAGE =ENGLISH') AS DAY,
TO_CHAR(SYSDATE,'D'), --요일을 숫자로 표현 
TO_CHAR(SYSDATE,'DDD') AS "365",
TO_CHAR(SYSDATE,'DD') AS dd FROM dual;
SELECT TO_CHAR(SYSDATE,'WW') AS "몇주차",
 TO_CHAR(SYSDATE,'Q') AS "몇분기" FROM dual;

--87/JUL/13
SELECT TO_CHAR(HIREDATE,'YY/MON/DD','NLS_DATE_LANGUAGE =ENGLISH')  FROM emp;

SELECT TO_CHAR(12345,'9999999') AS "99999 자릿수",
	   TO_CHAR(12345,'0999999') AS "공백을 0으로 채워줌",
	   TO_CHAR(12345,'$999999') AS "앞에 $추가",
	   TO_CHAR(12345,'99999.99') AS "소수점추가",
	   TO_CHAR(12345,'99,999') AS ", 추가",
	   TO_CHAR(0.45,'0.999') AS "소수점",
	   TO_CHAR(12345,'L99999') AS "L은 원(단위)을 추가함"
	   FROM dual; 
	   
-- TO_NUMBER
SELECT TO_NUMBER('43') FROM dual; 
SELECT TO_NUMBER('1234') FROM dual;

SELECT nvl2(comm,'있다','없다') FROM EMP ; --NVL2(comm,'A','B') : NULL값이 없으면 'A'로 NULL값을 'B'로(comm 숫자만 들어갈수 있지만 이함수는 다른 타입도 들어감)
SELECT nvl(comm,0) FROM EMP;             --NVL(comm,'A') 비슷하지만 이 함수는 NULL값을 찾아서 대체함(comm이 숫자 타입이라서 A는 숫자 타입이여야함)
SELECT ename, comm,nvl2(comm,(sal*12)+comm,sal*12) FROM emp;

--QUIZ01
--emp 사원번호의 첫 두글자만 출력하고 나머지는 *로 채워 출력, 사원이름의 첫글자만 출력하고 나머지는 *
SELECT RPAD(SUBSTR(EMPNO,1,2),LENGTH(EMPNO),'*') AS masking_empno,
      RPAD(SUBSTR(Ename,1,1),LENGTH(ENAME),'*') AS masking_ename  FROM EMP;

--QUIZ02
--한달 근무일수를 21.5로 하고 하루 평균 8시간 근무한다고 했을 때 사원들의 일당 과 시급을 구하시오 일당느 소수점 3짜리는 버리고
--시급은 소수점 둘째자리 반올림..
SELECT ENAME ,sal ,TRUNC(SAL/21.5,2) AS 일당,
				   ROUND((sal/21.5)/8,1) AS 시급  FROM emp;

--QUIZ03
--입사일 기준으로 3개월이 지난 후 첫번째 월요일이 정직원 전환 날짜입니다 이 날짜를 YYYY-MM-DD로 출력하시오
SELECT HIREDATE , TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,3),'월'),'YYYY-MM-DD') AS "정직원 전환 날짜" FROM emp; 