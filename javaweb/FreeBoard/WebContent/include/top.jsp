<%@page import="free.board.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	$(function() {
	});
</script>

<!-- top -->																								
	<div class="row">																							
		<div class="col-md-12">																						
			<div class="jumbotron">																					
				<h2>박민지-자유게시판</h2>	
				
				<%
				Object obj = session.getAttribute("memberVo");
				if (obj == null) {
					Cookie[] cookies_ids = request.getCookies();
					for (Cookie ck_id : cookies_ids) {
						String name = ck_id.getName();
						String value = ck_id.getValue(); //&& value.equals("true")
						if (name.equals("name")) {
							%>
							<script type="text/javascript">
							 $(function() {
								$("#m_id").val("<%=ck_id.getValue()%>");
							 });
							</script>
							<%
						}//if
					}//for
				%>
				<!-- 로그인 노노 -->	
					<form action="login_run.jsp" method="post">
						<input type="text" name="m_id" id="m_id" placeholder="아이디"/>
						<input type="checkbox" id="chkId" name="chkId"/>아이디저장<br>
						<input type="password" name="m_pw" id="m_pw_tops" placeholder="패스워드"/><br/>
						<button type="submit" id="btnOk">로그인</button>
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
					<img src="upload_img/<%=memberVo.getM_image()%>" class="rounded-circle" alt="Cinque Terre" height="100">
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