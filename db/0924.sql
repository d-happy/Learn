-- USER01

-- unique �������� (�����Ͱ� �ߺ� ���� �ʵ���, null ���)
-- primary key (�����Ͱ� �ߺ� ���� �ʵ��� + not null)
create table emp02(
    empno number(4) unique,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);
insert into emp02
values (1001, '�ű�ȯ', '�븮', 10);
select * from emp02;
insert into emp02
values (1001, 'ȫ��ȯ', '�븮', 10);
select * from emp02;
insert into emp02
values (null, 'ȫ��ȯ', '�븮', 10);
select * from emp02;

-- ������ ���� (user_xxxxs)
select *
from user_constraints;

-- ���� ���ǿ� �̸� �ο�
create table emp03(
    empno number(4) constraint uk_emp03_empno unique,
    ename varchar2(10) constraint nn_emp03_ename not null
);

select *
from user_constraints;

-- üũ ���� ����
create table emp04(
    empno number(4) constraint pk_emp04_empno primary key,
    sal number(7, 2) constraint ck_emp04_empno
        check (sal between 100 and 10000),
    age number(3) constraint ck_emp04_age
        check (age >= 0)
);

select *
from user_constraints;

-- ����Ʈ �� �ο�
create table emp05(
    empno number(4) primary key,
    deptno number(2) default 10
);
insert into emp05(empno)
values (1003);
select * from emp05;

-- ���̺� ���� ������� ���� ���� ����
create table emp06(
    empno number(4),
    ename varchar2(10) not null,
    primary key (empno)
);

-- ����, ������ ���� - update(DML)
-- ���� ���� (alternate) - DDL
desc emp06;
-- �÷� �߰�
alter table emp06
add (sal number(3)); -- add (�÷��� ����������)
desc emp06;

alter table emp06
add (birth date);
desc emp06;

-- �÷����� (���� ������ �͸� ��)
alter table emp06
modify sal number(2);
desc emp06;

-- �÷� ����
alter table emp06
drop column ename;
desc emp06;

-- ���̺�� ����
rename emp06 to emp06_1;

-- ���̺� ����
drop table emp06_1;

-- ���̺� ������ ����
delete from emp05; -- DML
truncate table emp05; -- rollback �ȵ�

-- ���̺� ����
-- emp ���̺��� emp08�� ����
create table emp08
as
select * from emp; -- ���̺� ����, �����͸� ����, ��������x

select * from emp08;

-- ���̺��� ������ ����
create table emp09
as
select * from emp
where 0 = 1; -- ������ ����

select * from emp09;

-- �̹����� ���� �μ����� �ٹ��ϴ� ��� ����
select * from emp
where deptno = (select deptno from emp
                where ename = '�̹���')
and ename != '�̹���';

-- dept ���̺��� �����ؼ� dept01 �� ����
-- dept01 ���̺��� 40�� �μ��� ��ġ(����)��
--                  20�� �μ��� ��ġ(����)���� ����
create table dept01
as
select * from dept;

select * from dept01;

update dept01 set
    loc = (select loc from dept01
           where deptno = 20)
where deptno = 40;

select * from dept01;

-- ���� ����� 14���ε�,
select * from emp;
select rownum, empno, ename
from emp
order by sal desc;

-- ������ (sequence) - ����
-- ����ȣó�� - �۹�ȣ(PK)
create table dept02
as
select * from dept;

select * from dept01;

create sequence seq_dept02; 
insert into dept02
values (seq_dept02.nextval, 'ȫ����', '���');
insert into dept02
values (seq_dept02.nextval, 'ȸ���', '��õ');
select * from dept02;
delete from dept02
where deptno < 10;
select * from dept02;
drop sequence seq_dept02;
create sequence seq_dept02
start with 50   -- 50���� ����
increment by 10; -- 10�� ����
insert into dept02
values (seq_dept02.nextval, 'ȫ����', '���');
insert into dept02
values (seq_dept02.nextval, 'ȸ���', '��õ');
select * from dept02;

-- ��(view, ������ ���̺�)
select * from emp
where deptno = 20;

create view v_emp20
as
select * from emp
where deptno = 20;

select * from v_emp20;

-- �ε���(����) - �˻� �ӵ��� ���̱� ����
-- �⺻Ű(PK) - �ε����� �̹� �Ǿ� ����.
create index idx_ename
on emp08 (ename);



