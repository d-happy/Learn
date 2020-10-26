-- USER01

-- unique 제약조건 (데이터가 중복 되지 않도록, null 허용)
-- primary key (데이터가 중복 되지 않도록 + not null)
create table emp02(
    empno number(4) unique,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);
insert into emp02
values (1001, '신귀환', '대리', 10);
select * from emp02;
insert into emp02
values (1001, '홍귀환', '대리', 10);
select * from emp02;
insert into emp02
values (null, '홍귀환', '대리', 10);
select * from emp02;

-- 데이터 사전 (user_xxxxs)
select *
from user_constraints;

-- 제약 조건에 이름 부여
create table emp03(
    empno number(4) constraint uk_emp03_empno unique,
    ename varchar2(10) constraint nn_emp03_ename not null
);

select *
from user_constraints;

-- 체크 제약 조건
create table emp04(
    empno number(4) constraint pk_emp04_empno primary key,
    sal number(7, 2) constraint ck_emp04_empno
        check (sal between 100 and 10000),
    age number(3) constraint ck_emp04_age
        check (age >= 0)
);

select *
from user_constraints;

-- 디폴트 값 부여
create table emp05(
    empno number(4) primary key,
    deptno number(2) default 10
);
insert into emp05(empno)
values (1003);
select * from emp05;

-- 테이블 레벨 방식으로 제약 조건 지정
create table emp06(
    empno number(4),
    ename varchar2(10) not null,
    primary key (empno)
);

-- 변경, 데이터 변경 - update(DML)
-- 구조 변경 (alternate) - DDL
desc emp06;
-- 컬럼 추가
alter table emp06
add (sal number(3)); -- add (컬럼명 데이터형식)
desc emp06;

alter table emp06
add (birth date);
desc emp06;

-- 컬럼변경 (변경 가능한 것만 됨)
alter table emp06
modify sal number(2);
desc emp06;

-- 컬럼 삭제
alter table emp06
drop column ename;
desc emp06;

-- 테이블명 변경
rename emp06 to emp06_1;

-- 테이블 삭제
drop table emp06_1;

-- 테이블 데이터 삭제
delete from emp05; -- DML
truncate table emp05; -- rollback 안됨

-- 테이블 복사
-- emp 테이블을 emp08로 복사
create table emp08
as
select * from emp; -- 테이블 구조, 데이터만 복사, 제약조건x

select * from emp08;

-- 테이블의 구조만 복사
create table emp09
as
select * from emp
where 0 = 1; -- 거짓인 조건

select * from emp09;

-- 이문세와 같은 부서에서 근무하는 사원 정보
select * from emp
where deptno = (select deptno from emp
                where ename = '이문세')
and ename != '이문세';

-- dept 테이블을 복사해서 dept01 을 생성
-- dept01 테이블에서 40번 부서의 위치(지역)을
--                  20번 부서의 위치(지역)으로 변경
create table dept01
as
select * from dept;

select * from dept01;

update dept01 set
    loc = (select loc from dept01
           where deptno = 20)
where deptno = 40;

select * from dept01;

-- 현재 사원이 14명인데,
select * from emp;
select rownum, empno, ename
from emp
order by sal desc;

-- 시퀀스 (sequence) - 순차
-- 대기번호처럼 - 글번호(PK)
create table dept02
as
select * from dept;

select * from dept01;

create sequence seq_dept02; 
insert into dept02
values (seq_dept02.nextval, '홍보부', '울산');
insert into dept02
values (seq_dept02.nextval, '회계부', '김천');
select * from dept02;
delete from dept02
where deptno < 10;
select * from dept02;
drop sequence seq_dept02;
create sequence seq_dept02
start with 50   -- 50부터 시작
increment by 10; -- 10씩 증가
insert into dept02
values (seq_dept02.nextval, '홍보부', '울산');
insert into dept02
values (seq_dept02.nextval, '회계부', '김천');
select * from dept02;

-- 뷰(view, 가상의 테이블)
select * from emp
where deptno = 20;

create view v_emp20
as
select * from emp
where deptno = 20;

select * from v_emp20;

-- 인덱스(색인) - 검색 속도를 높이기 위함
-- 기본키(PK) - 인덱싱이 이미 되어 있음.
create index idx_ename
on emp08 (ename);



