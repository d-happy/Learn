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
    updata_date timestamp
);