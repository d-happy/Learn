create table t_professor (
        p_no char(4) primary key,
        p_name varchar2(20) not null
);
commit;
drop table t_professor;

select * from t_professor;

insert into t_professor(p_no, p_name)
values (1001, '°û±³¼ö');
insert into t_professor(p_no, p_name)
values (1002, 'ÆØ±³¼ö');
insert into t_professor(p_no, p_name)
values (1003, 'ÇÑ±³¼ö');
commit;

create table t_student (
            s_no char(4) primary key,
            s_name varchar2(20) not null,
            s_major varchar2(20) not null, 
            s_score number(3) default 0, 
            p_no char(4) REFERENCES t_professor(p_no)
);
commit;
--drop table t_student;

select * from t_student;