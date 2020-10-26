--���̺� �̸� ����
rename emp06 to emp06_1;

--���̺� ����
drop table emp06_1;

--���̺� ������ ����
delete from emp05; --DML, rollblck ����
truncate table emp05; --rollback �� ��

--���̺� ����
--emp ���̺��� emp08�� ����
create table emp08
as 
select * from emp; --���̺� ����, �����͸� ����, ���� ���� no
select * from emp08;

--���̺��� ������ ���� (�÷� only)
create table emp09
as select * from emp
where 0 = 1; --������ ����
select * from emp09;

--�̹����� ���� �μ����� �ٹ��ϴ� ��� ����
select * from emp
where deptno = (select deptno from emp
                where ename = '�̹���')
and ename != '�̹���';

--dept ���̺��� �����ؼ� dept01�� ����
--dept01 ���̺��� 40�� �μ��� ��ġ(����)��
--                 20�� �μ��� ��ġ(����)���� ����
create table dept01
as select * from dept;
select * from dept01;
select * from dept;

update dept01 set loc = (select loc from dept01
                         where deptno = 20)
where deptno = 40;

--���� ����� 14���ε�, 
select * from emp;
select rownum, empno, ename
from emp
order by sal desc;

--������ (sequence) : ����
--����ȣó�� - �۹�ȣ(PK)
create table dept02
as
select * from dept;

select * from dept01;

create sequence seq_dept02; --�⺻���� i++

insert into dept02
values (seq_dept02.nextval, 'ȫ����', '���');
select * from dept02;
insert into dept02
values (seq_dept02.nextval, 'ȸ���', '����');
select * from dept02;

delete from dept02
where deptno < 10;
select * from dept02;
drop sequence seq_dept02;

create sequence seq_dept02
start with 50    --50���� ����
increment by 10; --10�� ����

insert into dept02
values (seq_dept02.nextval, 'ȫ����', '���');
select * from dept02;

insert into dept02 (deptno, dname, loc) --���� ���� (�׽�Ʈ ���� �ϱ�)
values (seq_dept02.nextval, 'ȸ���', '����');
select * from dept02;
select * from dept02;

--��(view, ������ ���̺�)
select * from emp
where deptno = 20;

create view v_emp20
as
select * from emp
where deptno = 20;

select * from v_emp20;

--�ε���(����) : �˻� �ӵ��� ���̱� ����
--�⺻Ű(PK) : �ε����� �̹� �Ǿ� ����
create index idx_ename
on emp08 (ename);

