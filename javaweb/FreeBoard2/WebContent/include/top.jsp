<%@page import="free.board.MemberDao"%>
<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- top -->
<div class="container-fluid">
	<div class="jumbotron">
		<div class="row">
			<div class="col-md-12">
					<h1 style="color:pink;">게시판 2 self ?!?!?!?!?!</h1>
			</div>
		</div><br/>

		<!-- 로그인 여부 -->
		<div class="row">
			<div class="col-md-3">
				<form role="form" action="login_run.jsp" method="post">
				<%
					Object obj_top = session.getAttribute("memberVo");
					MemberVo memberVo_top = (MemberVo)obj_top;
					
					if (obj_top == null) {
				%>
					<!-- 로그인 No -->
						<div class="form-group">
							<input type="text" class="form-control" 
							id="m_id" name="m_id" required placeholder="ID"/>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" 
							id="m_pw" name="m_pw" required placeholder="PW"/>
						</div>
						<button id="btnLogin" type="submit" class="btn btn-primary">Login</button><br/>
						<a href="member_join_form.jsp" class="btn btn-success">Join</a>
				<% 	
					} else {
				%>
					<!-- 로그인 Yes -->
						<h4><%=memberVo_top.getM_id()%>(<%=memberVo_top.getM_name() %>)님 반가반가</h4><br/>
						<a href="logout.jsp" class="btn btn-warning">Logout</a>			
				<% 	
					} //if
				%>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- top -->