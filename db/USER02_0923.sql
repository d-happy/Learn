-- user02

create table tbl_professor (
    pno char(4) primary key, --char�� �� �ڸ� ���̵� 8�ڸ� ����
    pname varchar2(20) not null
);

create table tbl_student (
    sno char(4) primary key, 
    sname varchar2(20) not null, --varchar�� 3�ڸ� ������ ������ �ڸ� ����
    smajor varchar2(20) not null, 
    score number(3) default 0,
    pno char(4) references tbl_professor(pno)
);

drop table tbl_student;

insert into tbl_professor(pno, pname)
values('1001', '�豳��');
insert into tbl_professor(pno, pname)
values('1002', '�ű���');
insert into tbl_professor(pno, pname)
values('1003', '������');
select * from tbl_professor;
commit;

select * from tbl_student;

update tbl_student set
    sname = 'ü��',
    smajor = 'ȭ�а���',
    score = 100,
    pno = 1002
where sno = '2004';

select * from tbl_student;

delete from tbl_user
where sno = ;