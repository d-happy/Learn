<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="include/header.jsp" %>	

<script type="text/javascript">
$(function() {
	$("#btnWrite").click(function() {
		location.href = "write_form.jsp";
	});
	
	$("#btnCookie").click(function() {
		var chk = $("#chkCookie").prop("checked");
		var chk_val = $("#chkCookie").val();
		console.log("chk -"+ chk);
		console.log("chk_val -"+ chk_val);
		// 자바 스크립트 -> 자료형 : 스트링, 바이너리(2진수) 밖에 없어서 
		// 체크 여부 상관없이 다 val()이 on 으로 나오나????
		// request.getParameter("chkId"); 로 하면
		// 체크 함 : on // 체크 노노 : null 로 나옴
		
		if (chk == true) {
			var url = "receive_cookie.jsp";
			var sendData = {
					"chk" : chk
			};
			$.post(url, sendData, function(data) {
				console.log("data : "+ data);
				console.log("data -"+ data.trim());
				if (data.trim() == "true") { // data = true : 공백 무시하고 의미가 맞으면 // data.trim() == "true" : 따져가며
					$("#divNoti").slideUp(1000);
				}
			});
		}
	});
})
</script>
<title>글목록</title>
</head>
<body>
	<%
		BoardDao dao = BoardDao.getInstance();
		List<BoardVo> list = dao.getList();
	%>

	<%
		boolean isNotshow = true; // 처음엔 보이게 -> if (isNotishow == true) 가고 -> 체크박스 건드리고 for문
		Cookie[] cookies = request.getCookies(); // 브라우저가 보내는 요청 정보에서 쿠키 데이터를 얻어댐
		
		for (Cookie cookie : cookies) {
			String name = cookie.getName(); // Cookie cookie = new Cookie("chk", "true"); 해서 chk
			if (name.equals("chk")) {
				String value = cookie.getValue(); // true
				if (value.equals("true")) {// cookie 값이 true 면 (체크박스 체크 하면)
					isNotshow = false; // 쿠키에 "chk" : "true" 정보라면 안보이게 (공지 안 보임)
					break;
				}//if
			}//if
		}//for
		
		if (isNotshow == true) {
	%>
					<!-- 공지 사항 -->
					<div class="row" id="divNoti">
						<div class="col-md-12">
							<h1>공지사항</h1>
							<h2>날씨 쌀쌀 건강 조심</h2>
							<input type="checkbox" id="chkCookie"/>1분 동안 공지 노노
							<button type="button" id="btnCookie">확인</button>
						</div>
					</div>
					<!-- // 공지 사항 -->
	<%			
		}//if
	%>
	<div class="container-fluid">
		
		<%@ include file="include/top.jsp" %>
		
		<div class="row">
			<div class="col-md-12">
				<button type="button" id="btnWrite" 
				class="btn btn-danger">글쓰기</button>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>글번호</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
					<%
					for(BoardVo vo : list) {
						
						// 글 존재
						if (vo.getB_exists().equals("true")) {
					%>
							<tr>
								<td><%= vo.getB_no() %></td>
								<td>
								<%
								if (vo.getB_readcount() > 100) {
									out.print("[HOT]");
								} 
								%>
								<a href="content.jsp?b_no=<%= vo.getB_no() %>">
								<img src="images/white.png" width="<%=vo.getRe_level()*50%>" height="1"/>
								<%= vo.getB_title() %></a></td>
								<td><%= vo.getM_id() %></td>
								<td><%= vo.getB_readcount() %></td>
								<td><%= vo.getB_date() %></td>
							</tr>
					<%
						// 글 존재 노노
						} else if (vo.getB_exists().equals("false")) {
					%>
							<tr>
								<td><%= vo.getB_no() %></td>
								<td colspan="4">삭제된 글입니다.</td>
<%-- 								<td><%= vo.getM_id() %></td> --%>
<%-- 								<td><%= vo.getB_readcount() %></td> --%>
<%-- 								<td><%= vo.getB_date() %></td> --%>
							</tr>
					<%
						}
					} //for
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@ include file="include/footer.jsp" %>

