SELECT * FROM v$version;
--계정생성시 앞에 붙는 접두어 생략하는 명령어

ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
--ALTER USER scott IDENTIFIED BY tiger account unlock;

--계정 만들기

CREATE USER scott IDENTIFIED BY tiger;

--권한 부여하기

GRANT CONNECT, resource, unlimited TABLESPACE TO scott;
