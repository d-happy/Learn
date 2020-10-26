--주석문
--SQL(Sequal):씨퀄
--Structured Query Language 
--구조화된 질의 (~노?)
--select, SELECT, Select, SeLeCT
--Create, Read, Update, Delete
select grade, losal, hisal
from salgrade; --Statement

--selsct 컬럼명1, 컬럼명2, ...
--from 테이블명;

--테이블 구조 보기
--desc 테이블명 (describe)
desc dept;

select deptno, dname, loc
from dept;

--emp 테이블의 구조
desc emp;

--모든 컬럼 보기 - *
select * --셀렉트절
from emp; --프롬절

select *
from dept;

select*
from salgrade;

--산술연산자
select ename, sal, sal + 100
from emp;

--연봉 (월급*12 + 보너스)
select ename, sal, comm , sal * 12 + comm
from emp;

--null 정해지지 않은 값

--커미션이 null이면 0이라고 치고 연봉 계산
--null이 아니면 커미션 값 계산
--nvl -> null value - nvl(comm, 0)

select ename, sal, comm, sal*12+nvl(comm,0)
from emp;

--컬럼 별칭(별명, ALIAS)
--컬럼명 뒤에 한칸 띄고 별칭 지정
--컬럼명 뒤에 AS 라고 쓰고 별칭 지정
--별칭에 공백을 넣고 싶다면 "" 안에 지정
select ename "사원의 이름", sal as 월급, 
       comm 커미션, sal*12+nvl(comm,0) 연봉
from emp;

--우리 사원들의 직급 확인 (중복 제거)
select distinct job
from emp;

--로우(행)를 추리기 (조건)
--이름이 한예슬인 사원 조회
select *
from emp
where ename = '한예슬';

--급여가 500원 이상인 사원 조회
select *
from emp
where sal>=500;

--급여가 500~700원 사이인 사원 조회
-- && : and
select *
from emp
where sal>=500 and sal<=700;

-- || : or
--급여가 300원이거나 500원 사원 조회
select *
from emp
where sal=300 or sal=500;

--10번 부서에 근무하는 사원 조회
select *
from emp
where deptno = 10;

--20번 부서의 과장 조회
select *
from emp
where deptno=20 and job='과장';

--10번 부서에 근무하거나 직급이 과장인 사원 조회
select *
from emp
where deptno=10 or job = '과장';

--10번 부서에서 근무하지 않는 사원
select *
from emp
--where deptno != 10;
where deptno <> 10;

--급여가 300원~500원 사이가 아닌 사원 조회
select *
from emp
--where sal < 300 or sal > 500;
where not(sal>=300 and sal<=500);

--A 와 B 사이
--비트윈 앱
--between A and B
select *
from emp
--where sal between 300 and 500;
--where not(sal between 300 and 500);
where sal not between 300 and 500;

select *
from salgrade;

--커미션이 80이거나 100이거나 200인 사원 조회
select *
from emp
--where comm = 80 r comm=100 or comm=200;
where comm in (80, 100, 200);

--커미션이 80이 아니고, 100도 아니고, 200도 아닌 사원 조회
select *
from emp
--where comm !=80 or comm!=100 or comm!=200;
where comm not in(80, 100, 200);

--커미션이 null(정해지지 않은)인 사원 조회
--연산에서 null은 무시됨
select *
from emp
--where comm = null;
where comm is null;

--커미션이 정해진 사원 조회
select *
from emp
where comm is not null;

--와일드카드(%, _)
-- _ : 문자 1개
-- % : 문자 0개 이상
--like (~와 같은)
--이씨 성을 가진 사원 조회
select *
from emp
--where ename = '이'; --사원명이 '이'인 사원
where ename like '이%';

--이름이 '슬'로 끝나는 사원
select *
from emp
where ename like '%슬';

--이름에 '병'이 들어가는
select *
from emp
where ename like '%병%';

--이름이 '예슬'인 사원
select *
from emp
where ename like '_예슬';

--정렬(order by 컬럼명) : 기본적으로 오름차순(small->big)
--                               ascending
--                               내림차순(desconding)
--사원 정보를 급여순으로 조회
select *
from emp
order by sal asc; --asc 생략 가능
--사원 정보를 급여순(많은순)으로 조회
select *
from emp
order by sal desc;

--n차 정렬
--부서번호, 급여가 많은 순으로 정렬, 
select *
from emp
order by deptno asc, sal desc;

--최근에 입사한 순서대로 사원 정보
select *
from emp
order by hiredate desc;

--select - 필수절 / 콜롬, 
--from - 필수절
--where - not 필수절 / from ■■, select ◆◆ 중에서 <조건> 맞는 데이타 
--order by - not 필수절
--20번 부서에서 근무하는 사람들을 급여가 많은 순으로 정렬
select *
from emp
where deptno = 20
order by sal desc;
--sysdate (현재 시각 구하기)
select sysdate
from dual; --더미 테이블

desc dual;
select *
from dual;

select 24*60
from dual;

--숫자 관련 함수(기능)
--절대값(absolute) 
select abs(-100)
from dual;
--버림(floor) 
select floor(3.14)
from dual;
--반올림(round) 
select round(3.14), round(3.56)
from dual;
--특정 자릿수에서 잘라내기(truncate : trunc)
select trunc(3.14, 1), trunc(3.1415, 2)
       trunc(34.5678, -1)    
from dual;
--사칙연산(+, -, ,*, /)
--나머지 - modular - mod
select mod (7,3)
from dual;

--문자 함수
--대문자로 변경, 소문자로 변경, 첫글자만 대문자
select 'Oracle DataBase', 
       upper('Oracle DataBase'),
       lower('Oracle DataBase'),
       initcap('Oracle DataBase')
from dual;

--문자열 길이 (length)
select length('Oracle'), length('오라클'),
       lengthb('Oracle'), lengthb('오라클')
from dual;

--문자열 연결 : + -> ||
select 'Oracle' || ' DateBase'
from dual;
select concat('오라클', ' 데이터베이스')
from dual;

--부분 문자열(sub string, subdtr)
--오라클에서의 인덱스는 1부터, substr(대상문자열, 인덱스, 갯수)
select substr('Oracle', 4, 2)
from dual;

--해당 문자의 위치 Index String
-- instr (대상문자열, 찾을 문자)
-- instr (대상문자열, 찾을 문자, 시작위치, 몇 번째)
select instr('Oracle', 'a')
from dual;

select instr('WELCOME TO ORACLE', 'O', 6, 2)
from dual; --ORACLE의  O

--패딩 - 안쪽 채우기
--LPAD - 왼쪽 채우기, RPAD - 오른쪽 채우기
--lpad(대상문자열, 자릿수, 채울 문자)
select lpad('Oracle', 20, '#'),
       rpad('Oracle', 20, '$')
from dual;

--형변환 함수
--3가지 : 문자형, 숫자형, 날짜형
--데이터 표현 : 숫자는 그냥, 문자/날짜는 좌우에 ''표시
select * from emp;
--2005년 3월 1일 이후에 입사한 직원
--날짜 정보 -> 숫자, System.currnetTimeMills
select * from emp
where hiredate > '2005/03/01';
-- to_char : 문자로, to_number : 숫자로, to_date : 날짜로
-- Y : 년도 / M : 월 / D : 날짜 / DAY : 요일
select sysdate, to_char(sysdate, 'YYYY-MM-DD'),
       to_char(sysdate, 'YYYY.MM.DD')
from dual;

select ename, to_char(hiredate, 'YYYY.MM.DD DAY'),
       to_char(hiredate, 'YYYY.MM.DD DY'),
       to_char(sysdate, 'YYYY.MM.DD/DY AM HH:mm:ss')
from emp;

--입사일이 2007년 4월 2일인 사원
select * from emp
--where hiredate = to_date('2007.4.2');
where hiredate = to_date('04022007', 'MMDDYYYY');
------------------------------------------------------------------
--1.substr 함수를 사용하여 9월에 입사한 사원 조회
select *
from emp
where subStr(hiredate, 6, 2) = '09';
--where subStr(to_char(hiredate, 'YYYY/MM/DD'), 6, 2) = '09'; 
--버전에 따라 안 될 수 있으니 정확하게 문자열로 만든 뒤에

--2.substr 함수를 사용하여 2003년도에 입사한 사원 조회
select * from emp
where substr(hiredate, 1, 4)='2003';

--3.substr 함수를 사용하여 "기"로 끝나는 사원 조회
select * from emp
--where substr(ename, 3, 1)='기';
where substr(ename, -1, 1)='기';

--4.instr 함수를 사용하여 이름의 두번째 글자에 "동"이 있는 사원 조회
select * from emp
where instr(ename, '동', 2, 1) = 2;
--instr(ename, '동')으로 인덱스 2 알고, 2 맞냐고 where에서 확인
--where ename like '_동_';
----------------------------------------------------------------------

select * from emp;

insert into ()
values ()





