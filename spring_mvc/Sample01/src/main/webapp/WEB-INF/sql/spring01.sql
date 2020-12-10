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

-- 테이블 내용, 시퀀스 삭제 // truncate : 삭제와 커밋 동시
truncate table tbl_board;
drop sequence seq_board_bno;
create sequence seq_board_bno;

-- 글 500개
BEGIN								
	FOR I IN 1..500 LOOP							
		INSERT INTO TBL_BOARD(B_NO, B_TITLE, B_CONTENT, USER_ID, re_group)						
		VALUES (						
			SEQ_BOARD_BNO.NEXTVAL,					
			'제목' || I,					
			'내용' || I,					
			'user01',
            SEQ_BOARD_BNO.NEXTVAL
		);						
	END LOOP;							
END;								
/
-- select
select * from tbl_board
order by re_group desc, re_seq asc;

-- 커밋
commit;

-- 10개 가져오기 // a.* : a 라는 서브 쿼리 내 테이블의 전체 column
select * from 
		(select rownum rnum, a.* from 
								(select * from tbl_board
                             	 order by re_group desc, re_seq asc) a)
where rnum between 1 and 10;

-- 댓글 테이블
create table tbl_comment(
	c_no number primary key,							 -- 댓글번호(PK)
	b_no number references tbl_board(b_no),				 -- 글번호(FK)
	user_id varchar2(50) references tbl_member(user_id), -- 작성자
	c_content varchar2(100) not null,					 -- 댓글 내용
	c_regdate timestamp default sysdate					 -- 날짜
);

create sequence seq_comment_cno;

insert into tbl_comment(c_no, b_no, user_id, c_content)
values (seq_comment_cno.nextval, 500, 'user02', '댓글1');
insert into tbl_comment(c_no, b_no, user_id, c_content)
values (seq_comment_cno.nextval, 500, 'user02', '댓글2');

select * from tbl_comment
where b_no = 500
order by c_no desc;

-- 메시지(쪽지) 테이블
-- 메시지 번호
-- 메시지 내용
-- 보낸 사람
-- 받는 사람
-- 받은 날짜
-- 읽은 날짜
create table tbl_message(
	msg_no number primary key,
	msg_content varchar2(200) not null,
	msg_sender varchar2(20) references tbl_member(user_id),
	msg_receiver varchar2(20) references tbl_member(user_id),
	msg_senddate timestamp default sysdate,
	msg_opendate timestamp
);

create sequence seq_message_no;

-- 포인트 카테고리
-- 포인트 코드 : 1001      1002
-- 포인트 설명 : 쪽지보내기     쪽지읽기
create table tbl_point_cate(
	point_code varchar2(4) primary key,
	point_desc varchar2(30) not null
);

insert into tbl_point_cate (point_code, point_desc)
values ('1001', '쪽지보내기');
insert into tbl_point_cate (point_code, point_desc)
values ('1002', '쪽기읽기');

-- 포인트 테이블
-- 포인트 번호
-- 아이디
-- 포인트 코드
-- 포인트 점수
-- 포인트 생긴 날짜
create table tbl_point(
	point_no number primary key,
	user_id varchar2(20) references tbl_member(user_id),
	point_code varchar2(4) references tbl_point_cate(point_code),
	point_score number default 0,
	point_date timestamp default sysdate
);

create sequence seq_point_no;

-- 사용자 테이블에 포인트 컬럼 추가
alter table tbl_member
add (user_point number default 0);


-- 
select count(*) from tbl_comment
where b_no = 500;

-- 각각의 글에 대해서 댓글 갯수 구함
select b_no, count(*) from tbl_comment
group by b_no;

select * from tbl_comment;

select count(*) from tbl_board; -- 전체 글 500개

select b.*, nvl(c.cnt, 0) comment_cnt -- nvl(c.cnt, 0) : cnt = null, 0으로 표현
from tbl_board b, (select b_no, count(*) cnt from tbl_comment
                   group by b_no) c
where b.b_no = c.b_no(+) -- (+) null 값도 표현
order by b.b_no desc;

-- 회원 테이블에 사용자 사진 컬럼 추가
alter table tbl_member
add (user_pic varchar2(100));

-- 좋아요 테이블
create table tbl_like (
    b_no number references tbl_board(b_no),
    user_id varchar2(20) references tbl_member(user_id)
);

-- 보드 테이블에 좋아요 갯수 컬럼 추가
alter table tbl_board
add (like_count number default 0);

-- 좋아요 테이블 테스트
insert into tbl_like (user_id, b_no)
values ('user01', 521);

commit;

delete from tbl_like;

-- 첨부파일 테이블
create table tbl_attach (
	fileName varchar2(100) primary key,
	b_no references tbl_board(b_no)
);