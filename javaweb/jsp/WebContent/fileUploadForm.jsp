<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileUploadForm.jsp</title>
<script></script>
</head>
<body>
	<!-- enctype="multipart/form-data" : 폼 데이터를 바이너리 데이터로 보냄 // 파일은 무조건 post 방식, 원래 바이너리 -->
	<form action="fileUploadRun.jsp" method="post" enctype="multipart/form-data">
		아이디 : <input type="text" name="m_id"/><br/>
		패스워드 : <input type="password" name="m_pass"/><br/>
		파일1 : <input type="file" name="m_file1"/><br/>
		파일2 : <input type="file" name="m_file2"/><br/>
		<button>완료</button>
	</form>
</body>
</html>