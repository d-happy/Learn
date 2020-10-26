--�ּ���
--SQL(Sequal):����
--Structured Query Language 
--����ȭ�� ���� (~��?)
--select, SELECT, Select, SeLeCT
--Create, Read, Update, Delete
select grade, losal, hisal
from salgrade; --Statement

--selsct �÷���1, �÷���2, ...
--from ���̺��;

--���̺� ���� ����
--desc ���̺�� (describe)
desc dept;

select deptno, dname, loc
from dept;

--emp ���̺��� ����
desc emp;

--��� �÷� ���� - *
select * --����Ʈ��
from emp; --������

select *
from dept;

select*
from salgrade;

--���������
select ename, sal, sal + 100
from emp;

--���� (����*12 + ���ʽ�)
select ename, sal, comm , sal * 12 + comm
from emp;

--null �������� ���� ��

--Ŀ�̼��� null�̸� 0�̶�� ġ�� ���� ���
--null�� �ƴϸ� Ŀ�̼� �� ���
--nvl -> null value - nvl(comm, 0)

select ename, sal, comm, sal*12+nvl(comm,0)
from emp;

--�÷� ��Ī(����, ALIAS)
--�÷��� �ڿ� ��ĭ ��� ��Ī ����
--�÷��� �ڿ� AS ��� ���� ��Ī ����
--��Ī�� ������ �ְ� �ʹٸ� "" �ȿ� ����
select ename "����� �̸�", sal as ����, 
       comm Ŀ�̼�, sal*12+nvl(comm,0) ����
from emp;

--�츮 ������� ���� Ȯ�� (�ߺ� ����)
select distinct job
from emp;

--�ο�(��)�� �߸��� (����)
--�̸��� �ѿ����� ��� ��ȸ
select *
from emp
where ename = '�ѿ���';

--�޿��� 500�� �̻��� ��� ��ȸ
select *
from emp
where sal>=500;

--�޿��� 500~700�� ������ ��� ��ȸ
-- && : and
select *
from emp
where sal>=500 and sal<=700;

-- || : or
--�޿��� 300���̰ų� 500�� ��� ��ȸ
select *
from emp
where sal=300 or sal=500;

--10�� �μ��� �ٹ��ϴ� ��� ��ȸ
select *
from emp
where deptno = 10;

--20�� �μ��� ���� ��ȸ
select *
from emp
where deptno=20 and job='����';

--10�� �μ��� �ٹ��ϰų� ������ ������ ��� ��ȸ
select *
from emp
where deptno=10 or job = '����';

--10�� �μ����� �ٹ����� �ʴ� ���
select *
from emp
--where deptno != 10;
where deptno <> 10;

--�޿��� 300��~500�� ���̰� �ƴ� ��� ��ȸ
select *
from emp
--where sal < 300 or sal > 500;
where not(sal>=300 and sal<=500);

--A �� B ����
--��Ʈ�� ��
--between A and B
select *
from emp
--where sal between 300 and 500;
--where not(sal between 300 and 500);
where sal not between 300 and 500;

select *
from salgrade;

--Ŀ�̼��� 80�̰ų� 100�̰ų� 200�� ��� ��ȸ
select *
from emp
--where comm = 80 r comm=100 or comm=200;
where comm in (80, 100, 200);

--Ŀ�̼��� 80�� �ƴϰ�, 100�� �ƴϰ�, 200�� �ƴ� ��� ��ȸ
select *
from emp
--where comm !=80 or comm!=100 or comm!=200;
where comm not in(80, 100, 200);

--Ŀ�̼��� null(�������� ����)�� ��� ��ȸ
--���꿡�� null�� ���õ�
select *
from emp
--where comm = null;
where comm is null;

--Ŀ�̼��� ������ ��� ��ȸ
select *
from emp
where comm is not null;

--���ϵ�ī��(%, _)
-- _ : ���� 1��
-- % : ���� 0�� �̻�
--like (~�� ����)
--�̾� ���� ���� ��� ��ȸ
select *
from emp
--where ename = '��'; --������� '��'�� ���
where ename like '��%';

--�̸��� '��'�� ������ ���
select *
from emp
where ename like '%��';

--�̸��� '��'�� ����
select *
from emp
where ename like '%��%';

--�̸��� '����'�� ���
select *
from emp
where ename like '_����';

--����(order by �÷���) : �⺻������ ��������(small->big)
--                               ascending
--                               ��������(desconding)
--��� ������ �޿������� ��ȸ
select *
from emp
order by sal asc; --asc ���� ����
--��� ������ �޿���(������)���� ��ȸ
select *
from emp
order by sal desc;

--n�� ����
--�μ���ȣ, �޿��� ���� ������ ����, 
select *
from emp
order by deptno asc, sal desc;

--�ֱٿ� �Ի��� ������� ��� ����
select *
from emp
order by hiredate desc;

--select - �ʼ��� / �ݷ�, 
--from - �ʼ���
--where - not �ʼ��� / from ���, select �ߡ� �߿��� <����> �´� ����Ÿ 
--order by - not �ʼ���
--20�� �μ����� �ٹ��ϴ� ������� �޿��� ���� ������ ����
select *
from emp
where deptno = 20
order by sal desc;
--sysdate (���� �ð� ���ϱ�)
select sysdate
from dual; --���� ���̺�

desc dual;
select *
from dual;

select 24*60
from dual;

--���� ���� �Լ�(���)
--���밪(absolute) 
select abs(-100)
from dual;
--����(floor) 
select floor(3.14)
from dual;
--�ݿø�(round) 
select round(3.14), round(3.56)
from dual;
--Ư�� �ڸ������� �߶󳻱�(truncate : trunc)
select trunc(3.14, 1), trunc(3.1415, 2)
       trunc(34.5678, -1)    
from dual;
--��Ģ����(+, -, ,*, /)
--������ - modular - mod
select mod (7,3)
from dual;

--���� �Լ�
--�빮�ڷ� ����, �ҹ��ڷ� ����, ù���ڸ� �빮��
select 'Oracle DataBase', 
       upper('Oracle DataBase'),
       lower('Oracle DataBase'),
       initcap('Oracle DataBase')
from dual;

--���ڿ� ���� (length)
select length('Oracle'), length('����Ŭ'),
       lengthb('Oracle'), lengthb('����Ŭ')
from dual;

--���ڿ� ���� : + -> ||
select 'Oracle' || ' DateBase'
from dual;
select concat('����Ŭ', ' �����ͺ��̽�')
from dual;

--�κ� ���ڿ�(sub string, subdtr)
--����Ŭ������ �ε����� 1����, substr(����ڿ�, �ε���, ����)
select substr('Oracle', 4, 2)
from dual;

--�ش� ������ ��ġ Index String
-- instr (����ڿ�, ã�� ����)
-- instr (����ڿ�, ã�� ����, ������ġ, �� ��°)
select instr('Oracle', 'a')
from dual;

select instr('WELCOME TO ORACLE', 'O', 6, 2)
from dual; --ORACLE��  O

--�е� - ���� ä���
--LPAD - ���� ä���, RPAD - ������ ä���
--lpad(����ڿ�, �ڸ���, ä�� ����)
select lpad('Oracle', 20, '#'),
       rpad('Oracle', 20, '$')
from dual;

--����ȯ �Լ�
--3���� : ������, ������, ��¥��
--������ ǥ�� : ���ڴ� �׳�, ����/��¥�� �¿쿡 ''ǥ��
select * from emp;
--2005�� 3�� 1�� ���Ŀ� �Ի��� ����
--��¥ ���� -> ����, System.currnetTimeMills
select * from emp
where hiredate > '2005/03/01';
-- to_char : ���ڷ�, to_number : ���ڷ�, to_date : ��¥��
-- Y : �⵵ / M : �� / D : ��¥ / DAY : ����
select sysdate, to_char(sysdate, 'YYYY-MM-DD'),
       to_char(sysdate, 'YYYY.MM.DD')
from dual;

select ename, to_char(hiredate, 'YYYY.MM.DD DAY'),
       to_char(hiredate, 'YYYY.MM.DD DY'),
       to_char(sysdate, 'YYYY.MM.DD/DY AM HH:mm:ss')
from emp;

--�Ի����� 2007�� 4�� 2���� ���
select * from emp
--where hiredate = to_date('2007.4.2');
where hiredate = to_date('04022007', 'MMDDYYYY');
------------------------------------------------------------------
--1.substr �Լ��� ����Ͽ� 9���� �Ի��� ��� ��ȸ
select *
from emp
where subStr(hiredate, 6, 2) = '09';
--where subStr(to_char(hiredate, 'YYYY/MM/DD'), 6, 2) = '09'; 
--������ ���� �� �� �� ������ ��Ȯ�ϰ� ���ڿ��� ���� �ڿ�

--2.substr �Լ��� ����Ͽ� 2003�⵵�� �Ի��� ��� ��ȸ
select * from emp
where substr(hiredate, 1, 4)='2003';

--3.substr �Լ��� ����Ͽ� "��"�� ������ ��� ��ȸ
select * from emp
--where substr(ename, 3, 1)='��';
where substr(ename, -1, 1)='��';

--4.instr �Լ��� ����Ͽ� �̸��� �ι�° ���ڿ� "��"�� �ִ� ��� ��ȸ
select * from emp
where instr(ename, '��', 2, 1) = 2;
--instr(ename, '��')���� �ε��� 2 �˰�, 2 �³İ� where���� Ȯ��
--where ename like '_��_';
----------------------------------------------------------------------

select * from emp;

insert into ()
values ()





