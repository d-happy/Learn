--사용자 생성
create user USER03 identified by 1234;
--권한 부여 - 접속, 자원사용
grant connect, resource to user03;

--녹십자 버튼 눌러서 user03 접속 생성
--테이블(t_professor, t_student)
--s_no, s_name, s_major, s_score, p_no
--p_no, p_name
--교수테이블 2명 정도 미리 insert 하고
--커밋
--vo
-- 1.필드: 테이블 컬럼 / 2.생성자: 디폴트 필드 / 3.게터, 세터 / 4.투스트링
--DAO
--1. 드라이버, URL, ID, PW - 필드 상수
--2. 겟커넥션
--3. 클로즈: 2개 오버로딩
--Frame
--1. UI 작업
--2. 리스너 설정: 확인
--3. 이벤트에 맞는 기능 정의(메서드)
--4. DAO에 기능정의
--5. DAO에서 결과 얻어오기
--6. UI에 반영