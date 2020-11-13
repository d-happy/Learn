<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String m_id = request.getParameter("m_id");
	String m_image = "";

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"JSP01", 
				"1234");
		String sql = "select * from tbl_upload";
		sql += "	  where m_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			m_image = rs.getString("m_image");
		}
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
	<!-- 브라우저로 접근 가능한 경로 (O), 컴퓨터의 실제 경로(x) -->
	<img src="upload/<%=m_image%>" height="100"/>
 	<h1><%=m_id%>님 반가반가</h1>
</body>
</html>