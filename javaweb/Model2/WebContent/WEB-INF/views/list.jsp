<%@page import="com.kh.domain.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
.span-mid{
	cursor : pointer;
	color : LightCoral;
}
</style>
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
		} else if (message == "login_success") {
			alert("로그인 성공");
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
		
		// 아이디 클릭
		/*$(".td-mid").click(function(e) {
			var left = $(this).position().left;
			var top = $(this).position().top;
			console.log("left :" + left + " || top :" + top);
			$("#mid-popup").offset({ // 위치 지정?
				"left" : left + 400,
				"top" : top + 480,
			}).show(); // display:none X 이제 보임
			// 이벤트 전파 중단 (이벤트 버블링 무력화) : body에 걸린 이벤트 X
			// body - div - td 있을때 td 이벤트 생기면, td->div->body 순으로 이벤트 다 걸림 : 이벤트 버블링
			// 레이어0 - 레이어1 - 레이어2 이런식으로 밑의 레이어들도 다 걸림
			e.stopPropagation();
		}); */
		/*$("body").click(function() {
			console.log("body click");
			$("#mid-popup").hide();
		});*/
		
		// 회원 정보 : 화면 이동 말고 모달
		$(".show-mid").click(function(e) {
			e.preventDefault(); // <a href> 막아두기
			$("#modal-memberInfo").click(); // 모달 여는 버튼 클릭
			var url = "show_member_info.kh";
			var m_id = $(".span-mid").attr("mid"); // mid라는 태그 만들어서 값 넣어두기
			var sendData = {
				"m_id" : m_id
			};
			// 받는 data_memberInfo.jsp 위치!!!!!!!!!
			$.get(url, sendData, function(data) { // 모달 바디에 넣기
				console.log(data); // <div>, <br/>, ... 태그랑 \${ } 표현식 사용해서 틀 잡아두기? 
				$(".modal-body").empty().append(data); // 미리 비우고 자식으로 넣기
			});
		});
		
		// 쪽지 보내기
		$(".send-message").click(function(e) {
			e.preventDefault();
			var m_id = $(this).attr("data-mid");
			$("#btnSendMemo").attr("data-mid", m_id);
			$("#modal-sendMessage-btn").trigger("click");
		});
		
		$("#btnSendMemo").click(function() {
			var memo = $("#txtMemo").val();
			var m_id = $(this).attr("data-mid");
			var url="send_message.kh";
			var sendData = {
				"m_id" : m_id,
				"memo" : memo
			};
			$.post(url, sendData, function(data) {
				var point = data.trim();
				$("#m_point").text(point);
				$("#modal-container-sendMessage").modal("hide"); // 모달 사라짐
			});
		});
	});
</script>
<title>글목록</title>
</head>
<body>

<!-- 쪽지 보내기 -->
	<div class="row">
		<div class="col-md-12">
			 <a id="modal-sendMessage-btn" href="#modal-container-sendMessage" style="display:none;"
			 role="button" class="btn" data-toggle="modal">쪽지보내기</a>
			
			<div class="modal fade" id="modal-container-sendMessage" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">쪽지 보내기</h5>
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<input id="txtMemo" type="text" class="form-control"/>
						</div>
						<div class="modal-footer">
							<button id="btnSendMemo" type="button" class="btn btn-primary">쪽지 보내기</button>
							<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
<!-- // 쪽지 보내기 -->

<!-- 회원 정보 모달 -->
	<div class="row">
		<div class="col-md-12">
			 <a id="modal-memberInfo" href="#modal-container-memberInfo" style="display:none;"
			 role="button" class="btn" data-toggle="modal">Launch demo modal</a>
			
			<div class="modal fade" id="modal-container-memberInfo" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">회원 정보</h5>
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
<!-- 								아이디 :  -->
<%-- 								<input type="text" class="form-control" value="${memberVo_another.m_id}" readonly/> --%>
<!-- 								이름 :  -->
<%-- 								<input type="text" class="form-control" value="${sessionScope.memberVo.m_name}" readonly/> --%>
<!-- 								포인트 :  -->
<%-- 								<input type="text" class="form-control" value="${sessionScope.memberVo.m_point}" readonly/> --%>
						</div>
						<div class="modal-footer">
<!-- 							<button type="button" class="btn btn-primary"></button> -->
							<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
<!-- // 회원 정보 모달 -->

<!-- 아이디 팝업 메뉴 -->
<!-- position:absolute; 절대 위치? / z-index:100; 레이어0 위로 100? 항상 맨 위 레이어 /  display:none; 일단 안 보임 -->
<!-- <ul id="mid-popup" class="list-group" style="width:150px; position:absolute; z-index:100; display:none;"> -->
<!-- 	<li class="list-group-item"><a href="show_member_info.kh">회원 정보</a></li> -->
<!-- 	<li class="list-group-item"><a href="send_message.kh">쪽지 보내기</a></li> -->
<!-- </ul> -->
<!-- //아이디 팝업 메뉴 -->

<!-- Paging form : method="get" 으로 해서 주소창으로 넘어감 -->
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
					<p class="text-muted">
						<span style="background-color:WhiteSmoke;">
						${sessionScope.memberVo.m_id}(${sessionScope.memberVo.m_name})님</span>
						<span id="m_point" class="badge badge-light">${sessionScope.memberVo.m_point} 포인트</span>
						<span class="far fa-envelope" style="color:SeaGreen;">${notReadMemoCount}</span>
					</p>
					<p>
						<a class="btn btn-success" href="write_form.kh">글쓰기</a>
						<a class="btn btn-outline-warning" href="logout.kh">로그아웃</a>
					</p>
				</div>
			</div>
		</div>
		<!-- // 상단 배너 -->
		
		${pagingDto.toString()}<br/>
		${sessionScope.memberVo.toString()}<br/><br/>
		
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
							<th class="text-muted">글번호</th>
							<th class="text-muted">이미지</th>
							<th class="text-muted" style="">제목</th>
							<th class="text-muted">아이디</th>
							<th class="text-muted">조회수</th>
							<th class="text-muted">날짜</th>
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
							<!-- 아이디 -->
							<td class="text-muted">
								<div class="dropdown">
									<c:choose>
										<c:when test="${sessionScope.memberVo.m_id != boardVo.m_id}">
											<span class="span-mid" mid="${boardVo.m_id}" data-toggle="dropdown">${boardVo.m_id}</span>
											<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
<!-- 										 	<a class="dropdown-item disabled" href="#">Action</a>  -->
												 <!-- GET 방식으로 m_id 값 보내고 / show_member_info.kh=### command 에 등록된 서비스로 고고-->
												 <a class="show-mid dropdown-item" href="#">회원 정보 보기</a> 
												 <a class="send-message dropdown-item" data-mid="${boardVo.m_id}" href="#">쪽지 보내기</a>
											</div>
										</c:when>
										<c:otherwise>
											<span>${boardVo.m_id}</span>
										</c:otherwise>
									</c:choose>
								</div>
							</td>
							<!-- // 아이디 -->
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