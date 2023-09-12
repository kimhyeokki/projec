CREATE USER kimhk11 identified BY 1234;
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--DROP USER kimhk11 계정 삭제

-- 접속 권한 부여
-- CREATE SESSION은 접속권한
-- CREATE TABLE  테이블 생성권한
-- unlimited TABLESPACE 인서트 권한 
GRANT CREATE SESSION, CREATE ANY TABLE, unlimited TABLESPACE, CONNECT ,resource, CREATE VIEW 
TO kimhk11;

GRANT SELECT ON scott.emp TO kimhk11;
GRANT INSERT ON scott.emp TO kimhk11;
GRANT UPDATE ON scott.emp TO kimhk11;
GRANT DELETE ON scott.emp TO kimhk11;

--권한 부여 제거
REVOKE SELECT, INSERT,UPDATE,DELETE ON scott.emp FROM kimhk11;

-- role (역할)
-- 권한을 묶어서 사용할때....
CREATE ROLE myRole;
--GRANT CREATE SESSION, CREATE ANY TABLE, unlimited TABLESPACE TO myRole;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE SYNONYM TO myRole;

CREATE USER  kimhk12 IDENTIFIED BY 1234;
GRANT myRole TO kimhk12;
REVOKE myRole FROM kimhk12; 

DROP USER kimhk12;

--사용자가 부여한 권한 조회
SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'kimhk11'; 

