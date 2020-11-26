<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<%@include file="../include/header.jsp"%>

<script>
$(function() {
	var msg = "${msg}";
	if (msg == "writeSuccess") {
		alert("글쓰기 성공2");
	} else if (msg == "deleteSuccess") {
		alert("삭제 성공2");
	}
	
});
</script>

<div>${boardList}</div><br/>

<div class="container-fluid">

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<a type="button" class="btn btn-success" href="/board/writeForm2">글쓰기</a>
		</div>
		<div class="col-md-1"></div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
		
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach var="boardVo" items="${boardList}">
					<tr>
						<td>${boardVo.b_no}</td>
						<td><a href="/board/content2?b_no=${boardVo.b_no}">${boardVo.b_title}</a></td>
						<td>${boardVo.user_id}</td>
						<td>${boardVo.b_regdate}</td>
						<td>${boardVo.b_viewcnt}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
	
</div>
<%@include file="../include/footer.jsp"%>
