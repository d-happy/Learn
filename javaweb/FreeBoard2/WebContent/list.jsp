<%@page import="java.util.List"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp" %> 
<!-- html / head 열고, 부트스트랩4 링크 : 각 파일마다 중복 제거하려고 따로 생성 후 사용-->

<script type="text/javascript"> 
	$(function() { // 버튼 클릭했을때 자바스크립트로 클릭 메소드 or <a> 태그 링크로 바로 보내기
// 		$("#btnWrite").click(function() {
// 			location.href = "write_form.jsp"
// 		}); 
	});
</script>
<title>게시판2-LIST</title>
</head>
<body>
	<div class="container-fluid">
		<%
			BoardDao dao = BoardDao.getInstance(); 
			List<BoardVo> list = dao.getList(); // 글 목록 리스트로 받아두고
		%>
		
		<%@ include file="include/top.jsp" %>
		<!--  -->
		
		<div class="row">
			<div class="col-md-12">
				<a href="write_form.jsp" class="btn btn-primary">글쓰기</a><br/><br/>
				<table class="table table-striped">
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
						for(BoardVo vo : list) { // 리스트 안에 있는 vo 갯수만큼 반복
						%>
						<tr>
							<td><%=vo.getB_no() %></td>
							<td>
							<!-- <%=vo.getRe_level()*50%> 해야지 너비 나옴 -->
							<!-- <td>들여쓰기 이미지 / 상세보기 앵커 / 제목 </td> -->
							<img src="images/white.png" width="<%=vo.getRe_level()*50%>" height="1"/>
							<a href="content.jsp?b_no=<%=vo.getB_no()%>">
							<%
							if (vo.getB_readcount() > 100) {
								out.print("[HOT]");
							} 
							%>
							<%=vo.getB_title() %></a></td>
							<td><%=vo.getM_id() %></td>
							<td><%=vo.getB_readcount()%></td>
							<td><%=vo.getB_date() %></td>
						</tr>
						<%
						}//for
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
		
	<%@ include file="include/footer.jsp" %>
	<!-- 저작권? 달고, body / html 닫기 -->
	