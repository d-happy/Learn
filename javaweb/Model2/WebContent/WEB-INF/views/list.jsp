<%@page import="com.kh.domain.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp" %>
<script type="text/javascript">
	$(function() {
		
// 		var message = "${param.message}"; // 글목록 새로고침 할 때 마다 반복
		// 세션 사용 해서 불러오고 사용하면 "% session.removeAttribute("message"); %" 해서 끈다 // 주소 노노
		var message = "${sessionScope.message}";
		if (message == "write_run_success") {
			alert("글쓰기 성공")
		} else if (message == "delete_success"){
			alert("삭제 완료");
		} else if (message == "reply_success") {
			alert("답글 달기 완료");
		}
		
		$(".content_link").click(function(e) {
			e.preventDefault(); // 브라우저의 기본 기능 막기 -> a 태그 무력화
			var b_no = $(this).attr("data-bno");
			$("#frmPaging > input[name=b_no]").val(b_no);
			$("#frmPaging").attr("action", "content.kh");
			$("#frmPaging").submit();
		});
		
		$(".page-link").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href");
			$("#frmPaging > input[name=page]").val(page);
			$("#frmPaging").submit();
		});
		
		$("#perPage").change(function() {
			var perPage = $(this).val();
			$("#frmPaging > input[name=perPage]").val(perPage); 
			$("#frmPaging > input[name=page]").val(1);
			$("#frmPaging").submit();
		});
	});
</script>
<title>글목록</title>
</head>
<body>

<!-- Paging form -->
<form id="frmPaging" action="list.kh" method="get">
	<input type="hidden" name="b_no"/>
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
	<input type="hidden" name="searchType" value="${pagingDto.searchType}"/>
	<input type="hidden" name="keyword" value="${pagingDto.keyword}"/>
</form>
<!-- // Paging form -->

	<div class="container-fluid">
	
		<!-- 상단 배너 -->
		<div class="row">
			<div class="col-md-12">
				<div style="background : rgb(255, 230, 230)" class="jumbotron">
					<h2 class="text-muted font-weight-bold">모델 2 게시판 - 수업</h2>
					<p class="text-muted font-weight-bold">MVC 패턴을 이용한 새 게시판</p>
					<p>
						<a class="btn btn-success" href="write_form.kh">글쓰기</a>
					</p>
				</div>
			</div>
		</div>
		<!-- // 상단 배너 -->
		
		${pagingDto.toString()}<br/><br/>
		
		<div class="row">
			<div class="col-md-2"></div>
			<!-- 검색 -->
			<div class="col-md-4" style="float:left">
				<form action="list.kh" method="get">
				
					<div style="float : left">
						<select name="searchType" class="form-control">
							<option value="b_title"
								<c:if test="${pagingDto.searchType == 'b_title'}">selected
								</c:if>
							>제목</option>
							<option value="b_content"
								<c:if test="${pagingDto.searchType == 'b_content'}">selected
								</c:if>
							>내용</option>
							<option value="m_id"
								<c:if test="${pagingDto.searchType == 'm_id'}">selected
								</c:if>
							>작성자</option>
						</select>
					</div>
					
					<div style="float : left">
						<input type="text" name="keyword" value="${pagingDto.keyword}" class="form-control"/>
			     	</div>
			     	
			     	<div style="float : left;">
						<button type="submit" class="btn btn-outline-secondary">검색</button>
					</div>
					
				</form>
			</div>
			<!-- // 검색 -->
			<!-- 얼만큼 보나? -->
			<div class="col-md-4" style="float:right">
				<div style="float:right">
					<select id="perPage" class="form-control">
					<c:forEach var="i" begin="5" end="30" step="5">
						<option value="${i}"
						<c:if test="${pagingDto.perPage == i}"> selected</c:if>
						>${i}줄씩 보기</option>
					</c:forEach>	
					</select>
				</div>
			</div>
			<!-- // 얼만큼 보나? -->
			<div class="col-md-2"></div>
		</div><br/>
		
		<!-- 글 목록 -->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table">
					<thead>
						<tr>
							<th class="table-info text-muted">글번호</th>
							<th class="table-active text-muted">이미지</th>
							<th style="background:rgb(51, 255, 204)">제목</th>
							<th class="table-success text-muted">아이디</th>
							<th class="table-active text-muted">조회수</th>
							<th class="table-primary text-muted">날짜</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="boardVo" items="${list}">
						<tr>
							<td class="text-muted">${boardVo.b_no}</td>
							<td><img alt="이미지"
							<c:choose>
								<c:when test="${not empty boardVo.b_file_path}">
									src="upload/${boardVo.b_file_path}"
								</c:when>
								<c:otherwise>
									src="upload/default.png"
								</c:otherwise>
							</c:choose>
							height="20"/></td>
							<td class="text-muted" style="padding-left:${boardVo.re_level * 50}px"> <!-- re_level 간격 -->
							<a class="content_link" data-bno="${boardVo.b_no}" href="#">${boardVo.b_title}</a></td>
							<td class="text-muted">${boardVo.m_id}</td>
							<td class="text-muted">${boardVo.b_readcount}</td>
							<td class="text-muted">${boardVo.b_date}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- // 글 목록 -->
		
		<!-- 페이징 -->
		<div class="row">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<nav>
					<ul class="pagination justify-content-center">
						<c:if test="${pagingDto.startPage >= 10 }">
						<li class="page-item">
							<a class="page-link" href="${pagingDto.startPage-1}">이전</a>
						</li>
						</c:if>
						<c:forEach var="i" begin="${pagingDto.startPage}" end="${pagingDto.endPage}">
						<li
							<c:choose>
								<c:when test="${i == pagingDto.page}"> 
									class="page-item active"
								</c:when>
								<c:otherwise>
									class="page-item"
								</c:otherwise>
							</c:choose>
						>
							<a class="page-link" href="${i}">${i}</a>
						</li>
						</c:forEach>
						<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
						<li class="page-item">
							<a class="page-link" href="${pagingDto.endPage+1}">다음</a>
						</li>
						</c:if>
					</ul>
				</nav>
			</div>
			<div class="col-md-2">
			</div>
		</div>
		<!-- // 페이징 -->
	
	</div>
</body>
</html>
<% session.removeAttribute("message"); %>