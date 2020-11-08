<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
// 	int b_no     = Integer.parseInt(request.getParameter("b_no")); // 굳이 필요 없음...
	int re_group = Integer.parseInt(request.getParameter("re_group"));
	int re_seq   = Integer.parseInt(request.getParameter("re_seq"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));
	
	String b_title = request.getParameter("b_title");
	String b_content = request.getParameter("b_content");
	String m_id = ((MemberVo)session.getAttribute("memberVo")).getM_id();
	String b_ip = request.getRemoteAddr();
	
	BoardVo boardVo = new BoardVo();
	// content.jsp : b_no -> reply_form.jsp : b_no로 얻은 BoardVo로 
	// re_group, re_seq, re_level 얻어서 인풋 히든으로 보내고 
	// -> reply_run.jsp : 값 받아와서 새로운 boardVo에 세터
	boardVo.setRe_group(re_group);
	boardVo.setRe_seq(re_seq);
	boardVo.setRe_level(re_level);
	// reply_form.jsp 에서 얻어온 값 
	boardVo.setB_title(b_title);
	boardVo.setB_content(b_content);
	// m_id 는 session에 저장된 값 (브라우저 내에서 확인 가능함)
	boardVo.setM_id(m_id);
	boardVo.setB_ip(b_ip);
	
	BoardDao boardDao = BoardDao.getInstance();
	int count = boardDao.reply(boardVo);
	
	if (count > 0) { // 답글 등록 여부 알려주고 list.jsp 이동
%>
		<script>
			alert("답글 등록 완료 짝짝짝짜짝짝짝");
			location.href="list.jsp";
		</script>
<%
	} else {
%>
		<script>
			alert("답글 등록 실패...!!!!!");
			location.href="list.jsp";
		</script>
<%		
	}//if
%>