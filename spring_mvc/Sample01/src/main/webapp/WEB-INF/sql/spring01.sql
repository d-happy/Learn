-- 사용자 생성
create user spring01 identified by 1234;
grant connect, resource to spring01;
-- 회원 테이블
create table tbl_member(
    user_id varchar2(50) primary key,
    user_pw varchar2(50) not null,
    user_name varchar2(50) not null,
    user_email varchar2(100),
    reg_date timestamp default sysdate,
    update_date timestamp
);
-- 시간 확인?
select sysdate
from dual;
-- 게시판 테이블
create table tbl_board(
	b_bno number primary key,
	b_title varchar2(100) not null,
	b_content varchar2(500),
	user_id varchar2(50) references tbl_member(user_id),
	b_regdate timestamp default sysdate,
	b_viewcnt number default 0,
	re_group number default 0,
	re_seq number default 0,
	re_level number default 0
);
-- 시퀀스
create sequence seq_board_bno;