<%@page import="free.board.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- top -->																								
	<div class="row">																							
		<div class="col-md-12">																						
			<div class="jumbotron">																					
				<h2>박민지-자유게시판</h2>	
				
				<%
				Object obj = session.getAttribute("memberVo");
				if (obj == null) {
				%>
				<!-- 로그인 노노 -->	
					<form action="login_run.jsp" method="post">
						<input type="text" name="m_id" placeholder="아이디"/><br>
						<input type="password" name="m_pw" placeholder="패스워드"/><br/>
						<button>로그인</button>
						<a class="btn btn-primary" href="member_join_form.jsp">회원가입</a>
					</form>	
				<!-- 로그인이 되어 있는 경우 -->	
				<%
				} else {
					MemberVo memberVo = (MemberVo)obj;
					String str = null;
					if (memberVo.getM_id().equals("sgh")) {
						str = "심묘랑 잘 지내니???";
					}
				%>
					<!-- hong(홍길동)님 반가반가 -->	
					<h3><%=memberVo.getM_id()%>(<%=memberVo.getM_name()%>)님 반가반가</h3>
					<h4 style="color:pink; background-color:green;"><%= str %></h4><br/>
					<a class="btn btn-success" href="logout.jsp">로그아웃</a>
				<% 
				} //if
				%>
			</div>																					
		</div>																						
	</div>	
<!-- top -->																				