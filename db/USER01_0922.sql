--decode : if~else, switch~case
--/workspace/db/0922.sql
--decode (표현식, 조건1, 결과1,
--               조건2, 결과2,
--               조건3, 결과3, 
--               조건n) 
select * from emp;
select * from dept;

select ename as 사원명, deptno as 부서번호, 
       decode(deptno, 10, '경리부',
                      20, '인사부',
                      30, '영업부',
                      40, '전산부') as 부서명
from emp;

--사용자 생성
--create user user01 identified by 1234
--테이블 생성
--DDL (Data Definition Language, 데이터 정의어)
create table dept01 (
    deptno number(2), --depnno
    dname varchar2(20),
    loc varchar2(20)
);

--데이터 추가
--insert into 테이블명(컬럼명1, 컬럼명2, ...)
--values (값1, 값2, ...)
insert into dept01(depnno, dname, loc)
values (10, '경리부', '울산');
insert into dept01(deptno, dname, loc)
values (20, '인사부', '서울');

--DQL (Data Query Language, 데이터 질의어)
select * from dept01;

--insert, update, delete - DML 

--delete from 테이블명 -데이터가 모두 삭제
--where절이 문법상으로는 없어도 되지만, 있다고 생각
delete from emp01
where

--update 테이블명 set
--    컬럼명1 = 값1,
--    컬럼명2 = 값2

update dept01 set
    loc = '울산'
where deptno=20; --없으면 전체 데이터 수정됨

--DML이 시작 되면 새로운 트랙잭션(tranjaction)이 시작됨
--commit, rollback

delete from dept01;
insert into dept01(deptno, dname, loc)
values (10, '경리부', '서울');
insert into dept01(deptno, dname, loc)
values (20, '인사부', '울산');
commit; --commit까지 잘 되면 commit
select * from dept01;
delete from dept01
where deptno=10;
select * from dept01;
rollback; --commit 뒤에 63~66 없는셈 
select * from dept01;

create table tbl_account(
    user_name varchar2(20),
    user_money number
);

insert into tbl_account(user_name, user_money)
values ('신귀환', 1000000);
insert into tbl_account(user_name, user_money)
values ('김봉규', 1000000);
commit;
select * from tbl_account;

--commit, rollback - DCL (Data Control Language)

--delete from dept01; --데이터를 지움
drop table dept01; --테이블 삭제
ROLLBACK;

--그룹 함수
select sum(sal) as '급여 총액',
       round(avg(sal), 2) as '급여 평균',
       max(sal) as '최대 급여',
       min(sal) as '최소 급여'
from emp;

select count(*) from emp;

select sum(comm) from emp;

select ename, max(sal) --ename은 값이 14개, max(sal)은 값이 1개
from emp;

--서브쿼리(sub query)
select ename, sal
from emp
where sal = (select max(sal) from emp);

--직급(업무)의 수
select count(distinct job) from emp; --distinct 중복 제거

--커미션이 정해진 사람의 수
select count(comm) from emp;

--group by

--부서별 급여 합계
select deptno, sum(sal) from emp
group by deptno;

select deptno, ename, avg(sal)
from emp
group by deptno;

--무결성 제약 조건(constraint)
--not null (NN) - 해당 컬럼에 널 값을 허용하지 않겠다.
--primary key (PK) - 기본키 - null(x), 중복(x)
--foreign key (FK) - 참조키 - 다른 테이블의 데이터를 참조하도록
--unique key (UK, UQ) - null(o), 중복(x)
--check ( > 0)

create table emp01 (
        user_name varchar2(20) not null,
        deptno number(2) 
);

insert into emp01(ename, deptno) 
values ('banana', 20);
insert into emp01(ename, deptno) 
values ('apple', 20);

drop table emp01;

create table emp01 (
        user_id varchar(20) primary key,
        user_name varchar(20) not null,
);

select* from user_constraints;

drop table emp01;

create table emp01 (
        empno number(4) primary key,
        ename varchar(20) not null,
        deptno number(2) references dept(deptno)
);

insert into emp01 (empno, ename, hiredate)
values (1003, 'banana', sysdate);

select * from emp01;

--테이블 조인(합치기)
--사원명(ename), 직급(job), 부서번호(deptno), 부서명(dname)
--equi -join  (이퀴조인)
select ename, job, dept.dname --데이터베이스는 14*4 식으로 하지만 필요는 14개
from emp, dept
where emp.deptno = dept.deptno --테이블 n개, 조건이 n-1개
order by ename;

select e.ename, e.job, d.dname 
from emp e, dept d --별칭으로 어디 컬럼인지 구분 쉽게
where e.deptno = d.deptno --테이블 n개, 조인 조건이 n-1개
order by e.ename;

select * from dept;

--사원명, 급여, 급여등급 (non-equil join)
select *
from emp e, salgrade s
--where e.sal between s.losal and s.hisal
where e.sal >= s.losal and e.sal <=s.hisal
order by e.ename;

--사원명, 부서이름, 급여, 급여등급 조회
select * from emp e, salgrade s, dept d
where (e.sal >= s.losal and e.sal <=s.hisal) and (e.deptno = d.deptno)
--조인 조건 여러개면, (~~) 안에 넣고 and, or 사용
order By e.ename;

--급여등급이 3등급 이상인 사원의
--사원명, 부서이름, 급여, 급여등급 조회
select e.ename, d.dname, e.sal, s.grade
from emp e, salgrade s, dept d
where (e.sal between s.losal and s.hisal) 
       and (e.deptno = d.deptno)
       and (s.grade >=3)
order By e.sal desc;

--자가 조인(Self Join)
select e.empno, e.ename, m.empno, m.ename  
from emp e, emp m --자가 조인은 별칭 꼭 필요
where e.mgr = m.empno
order by e.empno;

--이문세와 같은 부서에서 근무하는 사원의 사원명, 급여 조회
select * from emp;

select e.ename, e.sal
from emp e, dept d
where (substr(e.deptno, 1, 2) = '10') 
      and (e.ename != '이문세')
      and (e.deptno = d.deptno);
