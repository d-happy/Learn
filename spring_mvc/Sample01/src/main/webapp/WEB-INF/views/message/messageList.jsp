<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 이미 헤더에, jsp 있는 주소로? c, fmt 둘 다? --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../include/header.jsp"%>

<style>
.tr_bold {
	font-weight : bold;
}
.display_none {
	display : none;
}
.span_content {
	cursor : pointer;
}
</style>
<script src="/resources/js/myScript.js"></script>
<script type="text/javascript" >
$(function() {
	// 체크박스 전체
	$("#chkAll").click(function() {
		var isChecked = $(this).prop("checked");
		console.log(isChecked);
		if (isChecked) {
			$(".chkMessage").prop("checked", true);
		} else {
			$(".chkMessage").prop("checked", false);
		}
	});
	
	function checkLength() {
		var len = $(".chkMessage:checked").length;
		if (len == 0) {
			alert("선택된 쪽지가 없습니다.")
			return false;
		} else {
			return true;
		}
	}
	
	// 삭제 버튼
	$("#btnMessageDelete").click(function() {
		if (checkLength()) {
			$("#frmMessage").attr("action", "/message/delete").submit();
		}
	});
	
	// 읽은 상태로 표시 버튼
	$("#btnMessageStateChange").click(function() {
		if (checkLength()) {
			$("#frmMessage").attr("action", "/message/stateChange").submit();
		}
	});
	
	// 쪽지 내용 보기 // 비동기, 테이블 정보 수정은 메세지 서비스, 트랜잭션 다 함
	// 여기, 메세지컨트롤러 에서는 로그인할 때 받은 세션 멤버브이오(로그인 당시 디비에서 받은 정보)를
	// 서비스랑 같은 포인트 값 만들려고 수정하는 거임??? 눈에 보이는 부분하고 서버 데이터가 다르니까
	// 뷰에 보이는 부분을 서버 데이터에 맞춤
	$(".span_content").click(function() {
		var msg_no = $(this).attr("data-msg-no");
		var url = "/message/readMessage/" + msg_no;

		var that = $(this);
		var td = that.parent().next().next();
		
		// 읽지 않은 쪽지일 경우에만 서버로 전송
		if (td.text().trim() == "읽지않음") {
			// 서버로 전송
			$.get(url, function(data) {
				console.log(data);
				if (data != "") {
					that.parent().parent().removeClass("tr_bold");
					var d = getNowTime();
					console.log(d);
					td.text(d);
					$("#user_point").text(data);
					var count = parseInt($("#notReadCount").text());
					$("#notReadCount").text(count - 1);
				}
			}); //get
		} //if
		that.addClass("display_none");
		that.next().removeClass("display_none");
	});
	
});
</script>

<%-- <h3>${messageList}</h3> --%>

<div class="container-fluid">

	<div class="row">
		<div class="col-md-12">
			<ul class="nav nav-tabs">
				<li
				<c:if test="${param.type == 'receive'}">
					class="active"
				</c:if>
				><a href="/message/messageList?type=receive">받은쪽지함</a></li>
				<li
				<c:if test="${param.type == 'send'}">
					class="active"
				</c:if>
				><a href="/message/messageList?type=send">보낸쪽지함</a></li>
			</ul>
		</div>
	</div><br/>

	<div class="row">
		<div class="col-md-12">
			<span>선택한 쪽지를</span>
			<button type="button" id="btnMessageDelete">삭제</button>
			<button type="button" id="btnMessageStateChange">읽은상태로 표시</button>
		</div>
	</div><br/>

	<div class="row">
		<div class="col-md-12">
		<form id="frmMessage" method="post">
		<input type="hidden" name="type" value="${param.type}"/>
			<table class="table">
				<thead>
					<tr style="color:LightSalmon; background-color:FloralWhite;">
						<th><input type="checkbox" id="chkAll"/></th>
						<th>보낸사람</th>
						<th>받는사람</th>
						<th>내용</th>
						<th>보낸날짜</th>
						<th>읽은날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="messageVo" items="${messageList}">
					<tr 
					<c:if test="${messageVo.msg_opendate == null}">
					class="tr_bold"
					</c:if>
					>
						<td><input type="checkbox" class="chkMessage"
							name="msg_no" value="${messageVo.msg_no}"/></td>
						<td>${messageVo.msg_sender}</td>
						<td>${messageVo.msg_receiver}</td>
						<td>
							<span class="span_content" data-msg-no="${messageVo.msg_no}">${fn:substring(messageVo.msg_content, 0, 3)}...</span>
							<span class="display_none">${messageVo.msg_content}</span>
						</td>
						<td><fmt:formatDate value="${messageVo.msg_senddate}" 
							pattern="yyyy-mm-dd HH:mm:ss"/></td>
						<td>
						<c:choose>
							<c:when test="${messageVo.msg_opendate == null}">
								읽지않음
							</c:when>
							<c:otherwise>
								${messageVo.msg_opendate}
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		</div>
	</div>
	
</div>

<%@include file="../include/footer.jsp"%>