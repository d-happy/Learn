<%@page import="free.board.MemberVo"%>
<%@page import="free.board.CommentVo"%>
<%@page import="java.util.List"%>
<%@page import="free.board.CommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));

	CommentDao commentDao = CommentDao.getInstance();
	List<CommentVo> list = commentDao.getCommentList(b_no);
	
	// 로그인한 사용자 아이디
	MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
	String login_id = memberVo.getM_id();
%>
<table class="table">
	<tbody>
	<%
	for (CommentVo vo : list) { 
	%>
		<tr>
			<td><%=vo.getC_no() %></td>
			<td><%=vo.getC_content() %></td>
			<td><%=vo.getM_id() %></td>
			<td><%=vo.getC_date() %></td>
			<%
			if (login_id.equals(vo.getM_id())) {
			%>
			<td><button type="button" class="btn btn-warning btn-sm btnCommentModify">수정</button></td>
			<td><button type="button" class="btn btn-danger btn-sm btnCommentDelete">삭제</button></td>
			<%
			} else {
			%>
			<td></td>
			<td></td>
			<%	
			}//if
			%>
		</tr>
	<%
	}//for
	%>
	</tbody>
</table>