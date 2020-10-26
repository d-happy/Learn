package student.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "USER02";
	private final String PW = "1234";
	
	private static StudentDao instance;
	private StudentDao() {/* singleton */}
	public static StudentDao getInstance() {
		if (instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);  //����Ŭ ����̹��� �޸𸮿� �ε�
			Connection conn = DriverManager.getConnection(URL, ID, PW); 
			//�޸𸮿� �ε��� Ŭ������ �̿��ؼ� ����
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	//�ڿ� �ݳ�
	private void close(PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
	}
	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null)    try { rs.close(); }    catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
	}
	
	//Input
	public int inputStudent(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into tbl_student(sno, sname, smajor, score, pno)"
					+ "   values(?,?,?,?,?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSno()); 
			//1��° ?�� vo.getSno()=String 'value' input //DataBase index 1~
			pstmt.setString(2, vo.getSname());
			pstmt.setString(3, vo.getSmajor());
			pstmt.setInt(4, vo.getScore()); // 4 ? <- vo.getScore()=int input
			pstmt.setString(5, vo.getPno());
			//insert, update, delete - executeUpdate(), select - executiveQuery()
			int count = pstmt.executeUpdate(); //1 �� ��(��) ���ԵǾ����ϴ�. 1=count
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
			if (conn != null)  try { conn.close(); }  catch (Exception e) { }
		}
		return 0; //count �� �Ǹ� 0 �������� ���� �� ��
	}
	
	//update
	public int updateStudent(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update tbl_student set"
					+ "			sname = ?,"
					+ "			smajor = ?,"
					+ "			score = ?, "
					+ "			pno = ?"
					+ "	  where sno = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i,vo.getSname()); //����, i+1 �ڿ� pstmt.setString() ����
			pstmt.setString(++i,vo.getSmajor());
			pstmt.setInt   (++i,vo.getScore());
			pstmt.setString(++i,vo.getPno());
			pstmt.setString(++i,vo.getSno());
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//updateStudent
	
	//delete
	public int deleteStudent(String sno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from tbl_student"
					+ "	  where sno = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;	
	}//delete
	
	/*//searchAll
	public List<StudentVO> searchStudent() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		//DataBase�� �ִ� �����͸� �ҷ��;� �ϴ�
		//sql
		
		try {
			String sql = "select * from tbl_student"
					+ "	  order by sno";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<StudentVO> list = new ArrayList<>();
			while (rs.next() == true) {
				String sno    = rs.getString("sno");
				String sname  = rs.getString("sname");
				String smajor = rs.getString("smajor");
				int score     = rs.getInt("score");
				String pno    = rs.getString("pno");
				
				StudentVO vo = new StudentVO(sno, sname, smajor, score, pno);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}*/
	
	//searchNotAll, searchAll
	public List<StudentVO> searchStudent(String keyword) { //searchStudent() �����ε�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		//sql�� ���� ���ؼ� DataBase�� �ִ� ������ �߿���
		//���ǿ� �´� ������(���)�� rs�� ����
		try {
			String sql = "select s.sno, s.sname, s.smajor, s.score, p.pname"
					+ "   from tbl_student s, tbl_professor p"
					+ "	  where s.pno = p.pno";
			if (keyword != null && !keyword.trim().equals(""))  {
				sql+= "	  and s.sname like ?";
			} 
			//��ü�˻�, �κа˻��� �������� where�� �ϳ��ϱ� �������� keyword �޾Ƽ�
			//if�� where�� �ϳ� �� �ϳ� Ȯ��
			sql	+= "	  order by s.sno";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if (keyword != null && !keyword.trim().equals(""))  {
				pstmt.setString(1, "%" + keyword + "%"); 
				//string�� �ڵ����� '', int�� ������ ��� �������
			}
			rs = pstmt.executeQuery();
			List<StudentVO> list = new ArrayList<>();
			while (rs.next() == true) {
				String sno    = rs.getString("sno");
				String sname  = rs.getString("sname");
				String smajor = rs.getString("smajor");
				int score     = rs.getInt("score");
				String pname  = rs.getString("pname");
				
				StudentVO vo = new StudentVO(sno, sname, smajor, score, null, pname);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//searchStudent
	
	
}//class
