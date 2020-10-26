-- user02

create table tbl_professor (
    pno char(4) primary key, --char은 몇 자리 값이든 8자리 차지
    pname varchar2(20) not null
);

create table tbl_student (
    sno char(4) primary key, 
    sname varchar2(20) not null, --varchar은 3자리 들어오면 나머지 자리 삭제
    smajor varchar2(20) not null, 
    score number(3) default 0,
    pno char(4) references tbl_professor(pno)
);

drop table tbl_student;

insert into tbl_professor(pno, pname)
values('1001', '김교수');
insert into tbl_professor(pno, pname)
values('1002', '신교수');
insert into tbl_professor(pno, pname)
values('1003', '곽교수');
select * from tbl_professor;
commit;

select * from tbl_student;

update tbl_student set
    sname = '체리',
    smajor = '화학공업',
    score = 100,
    pno = 1002
where sno = '2004';

select * from tbl_student;

delete from tbl_user
where sno = ;