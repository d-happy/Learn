package free.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

	private static CommentDao instance;
	private CommentDao() { /* singleton */ }
	public static CommentDao getInstance() {
		if (instance == null) {
			instance = new CommentDao();
		}
		return instance;
	}
	
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "JSP02";
	private final String PW = "1234";
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
	}
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (rs != null)    try { rs.close(); }    catch (Exception e) { }
	}
	
	
}//CommentDao
