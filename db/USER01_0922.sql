--decode : if~else, switch~case
--/workspace/db/0922.sql
--decode (ǥ����, ����1, ���1,
--               ����2, ���2,
--               ����3, ���3, 
--               ����n) 
select * from emp;
select * from dept;

select ename as �����, deptno as �μ���ȣ, 
       decode(deptno, 10, '�渮��',
                      20, '�λ��',
                      30, '������',
                      40, '�����') as �μ���
from emp;

--����� ����
--create user user01 identified by 1234
--���̺� ����
--DDL (Data Definition Language, ������ ���Ǿ�)
create table dept01 (
    deptno number(2), --depnno
    dname varchar2(20),
    loc varchar2(20)
);

--������ �߰�
--insert into ���̺��(�÷���1, �÷���2, ...)
--values (��1, ��2, ...)
insert into dept01(depnno, dname, loc)
values (10, '�渮��', '���');
insert into dept01(deptno, dname, loc)
values (20, '�λ��', '����');

--DQL (Data Query Language, ������ ���Ǿ�)
select * from dept01;

--insert, update, delete - DML 

--delete from ���̺�� -�����Ͱ� ��� ����
--where���� ���������δ� ��� ������, �ִٰ� ����
delete from emp01
where

--update ���̺�� set
--    �÷���1 = ��1,
--    �÷���2 = ��2

update dept01 set
    loc = '���'
where deptno=20; --������ ��ü ������ ������

--DML�� ���� �Ǹ� ���ο� Ʈ�����(tranjaction)�� ���۵�
--commit, rollback

delete from dept01;
insert into dept01(deptno, dname, loc)
values (10, '�渮��', '����');
insert into dept01(deptno, dname, loc)
values (20, '�λ��', '���');
commit; --commit���� �� �Ǹ� commit
select * from dept01;
delete from dept01
where deptno=10;
select * from dept01;
rollback; --commit �ڿ� 63~66 ���¼� 
select * from dept01;

create table tbl_account(
    user_name varchar2(20),
    user_money number
);

insert into tbl_account(user_name, user_money)
values ('�ű�ȯ', 1000000);
insert into tbl_account(user_name, user_money)
values ('�����', 1000000);
commit;
select * from tbl_account;

--commit, rollback - DCL (Data Control Language)

--delete from dept01; --�����͸� ����
drop table dept01; --���̺� ����
ROLLBACK;

--�׷� �Լ�
select sum(sal) as '�޿� �Ѿ�',
       round(avg(sal), 2) as '�޿� ���',
       max(sal) as '�ִ� �޿�',
       min(sal) as '�ּ� �޿�'
from emp;

select count(*) from emp;

select sum(comm) from emp;

select ename, max(sal) --ename�� ���� 14��, max(sal)�� ���� 1��
from emp;

--��������(sub query)
select ename, sal
from emp
where sal = (select max(sal) from emp);

--����(����)�� ��
select count(distinct job) from emp; --distinct �ߺ� ����

--Ŀ�̼��� ������ ����� ��
select count(comm) from emp;

--group by

--�μ��� �޿� �հ�
select deptno, sum(sal) from emp
group by deptno;

select deptno, ename, avg(sal)
from emp
group by deptno;

--���Ἲ ���� ����(constraint)
--not null (NN) - �ش� �÷��� �� ���� ������� �ʰڴ�.
--primary key (PK) - �⺻Ű - null(x), �ߺ�(x)
--foreign key (FK) - ����Ű - �ٸ� ���̺��� �����͸� �����ϵ���
--unique key (UK, UQ) - null(o), �ߺ�(x)
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

--���̺� ����(��ġ��)
--�����(ename), ����(job), �μ���ȣ(deptno), �μ���(dname)
--equi -join  (��������)
select ename, job, dept.dname --�����ͺ��̽��� 14*4 ������ ������ �ʿ�� 14��
from emp, dept
where emp.deptno = dept.deptno --���̺� n��, ������ n-1��
order by ename;

select e.ename, e.job, d.dname 
from emp e, dept d --��Ī���� ��� �÷����� ���� ����
where e.deptno = d.deptno --���̺� n��, ���� ������ n-1��
order by e.ename;

select * from dept;

--�����, �޿�, �޿���� (non-equil join)
select *
from emp e, salgrade s
--where e.sal between s.losal and s.hisal
where e.sal >= s.losal and e.sal <=s.hisal
order by e.ename;

--�����, �μ��̸�, �޿�, �޿���� ��ȸ
select * from emp e, salgrade s, dept d
where (e.sal >= s.losal and e.sal <=s.hisal) and (e.deptno = d.deptno)
--���� ���� ��������, (~~) �ȿ� �ְ� and, or ���
order By e.ename;

--�޿������ 3��� �̻��� �����
--�����, �μ��̸�, �޿�, �޿���� ��ȸ
select e.ename, d.dname, e.sal, s.grade
from emp e, salgrade s, dept d
where (e.sal between s.losal and s.hisal) 
       and (e.deptno = d.deptno)
       and (s.grade >=3)
order By e.sal desc;

--�ڰ� ����(Self Join)
select e.empno, e.ename, m.empno, m.ename  
from emp e, emp m --�ڰ� ������ ��Ī �� �ʿ�
where e.mgr = m.empno
order by e.empno;

--�̹����� ���� �μ����� �ٹ��ϴ� ����� �����, �޿� ��ȸ
select * from emp;

select e.ename, e.sal
from emp e, dept d
where (substr(e.deptno, 1, 2) = '10') 
      and (e.ename != '�̹���')
      and (e.deptno = d.deptno);
