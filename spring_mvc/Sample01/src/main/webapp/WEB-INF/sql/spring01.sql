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


