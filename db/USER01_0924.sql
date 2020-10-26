--테이블 이름 변경
rename emp06 to emp06_1;

--테이블 삭제
drop table emp06_1;

--테이블 데이터 삭제
delete from emp05; --DML, rollblck 가능
truncate table emp05; --rollback 안 됨

--테이블 복사
--emp 테이블을 emp08로 복사
create table emp08
as 
select * from emp; --테이블 구조, 대이터만 복사, 제약 조건 no
select * from emp08;

--테이블의 구조만 복사 (컬럼 only)
create table emp09
as select * from emp
where 0 = 1; --거짓인 조건
select * from emp09;

--이문세와 같은 부서에서 근무하는 사원 정보
select * from emp
where deptno = (select deptno from emp
                where ename = '이문세')
and ename != '이문세';

--dept 테이블을 복사해서 dept01을 생성
--dept01 테이블에서 40번 부서의 위치(지역)을
--                 20번 부서의 위치(지역)으로 변경
create table dept01
as select * from dept;
select * from dept01;
select * from dept;

update dept01 set loc = (select loc from dept01
                         where deptno = 20)
where deptno = 40;

--현재 사원이 14명인데, 
select * from emp;
select rownum, empno, ename
from emp
order by sal desc;

--시퀀스 (sequence) : 순차
--대기번호처럼 - 글번호(PK)
create table dept02
as
select * from dept;

select * from dept01;

create sequence seq_dept02; --기본으로 i++

insert into dept02
values (seq_dept02.nextval, '홍보부', '울산');
select * from dept02;
insert into dept02
values (seq_dept02.nextval, '회계부', '경주');
select * from dept02;

delete from dept02
where deptno < 10;
select * from dept02;
drop sequence seq_dept02;

create sequence seq_dept02
start with 50    --50부터 시작
increment by 10; --10씩 증가

insert into dept02
values (seq_dept02.nextval, '홍보부', '울산');
select * from dept02;

insert into dept02 (deptno, dname, loc) --생략 가능 (테스트 때만 하기)
values (seq_dept02.nextval, '회계부', '경주');
select * from dept02;
select * from dept02;

--뷰(view, 가상의 테이블)
select * from emp
where deptno = 20;

create view v_emp20
as
select * from emp
where deptno = 20;

select * from v_emp20;

--인덱스(색인) : 검색 속도를 높이기 위해
--기본키(PK) : 인덱싱이 이미 되어 있음
create index idx_ename
on emp08 (ename);

