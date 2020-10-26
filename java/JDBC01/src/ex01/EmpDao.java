package ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	//�̷��Ŵ� ������ Ŭ������ ������ �Է¹��
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//�� ��ǻ�Ϳ� ����
	private final String ID = "USER01";
	private final String PW = "1234"; 
	//������ �ʵ�, ������ ������ ��ü�� �־�� �ϳ� ��ü �ϳ��� �ʿ��ϸ� �̱���
	
	
	private Connection conn; //������ ��
	
	private PreparedStatement pstmt; //SQL ������ ������ ��
	
	private ResultSet rs; //���� ���� ����� ������ ��
	
	
	private static EmpDao instance;
	private EmpDao() { /*singleton*/ }
	public static EmpDao getInstance() {
		if (instance == null) {
			instance = new EmpDao();
		}
		return instance;
	}
	
	
	private void doConnect() {
		try {
			Class.forName(DRIVER); //�ڹٿ��� ����� ����Ŭ���� �ִ� ����̹� 
			//Ŭ������ �޸𸮿� �ε��Ѵ�
			conn = DriverManager.getConnection(URL, ID, PW);
			//���� ���, ���̵�, ��� �Է��ؼ� ����
		} catch (Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}
	
	public List<EmpVO> selectAll() { //List<EmpVO> return�ϴ� �Լ�
		doConnect();
		String sql = "select * from emp order by empno";
		try {
			pstmt = conn.prepareStatement(sql); //sql �Է��ؼ� ����
			rs = pstmt.executeQuery(); //���� ġ�� ����� rs�� ����
			List<EmpVO> list = new ArrayList<>(); //java.util.List, java.util.ArrayList
			while (rs.next() == true) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate"); //java.sql.Date;
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
//				System.out.printf("%d | %s | %s | %d | %s | %d | %d | %d\n", 
//						empno, ename, job, mgr, hiredate, sal, comm, deptno);
				EmpVO vo = new EmpVO();
				vo.setEmpno(empno);
				vo.setEname(ename);
				vo.setJob(job);
				vo.setMgr(mgr);
				vo.setHiredate(hiredate);
				vo.setSal(sal);
				vo.setComm(comm);
				vo.setDeptno(deptno);
				list.add(vo);
			}//while
			return list; 
			//vo �ϳ��ϳ��� �ݷ� ����Ÿ �� �����ؼ� list ����Ÿ �ϳ� ����� while �� ������ list �ϼ� �� return
		} catch (Exception e) {
			System.out.println("���� ���� ����");
			e.printStackTrace();
		}
		return null; //list �ݷ� ���� �� ���� �� �Ǹ� ���� ������ ���� null ������
	}
	
	public List<EmpVO> searchEname(String name) {
		doConnect(); //SQL�̶� ����?!
//		selectAll(); //������ ���� �� ���� ���� ����, searchEname�� �˻��� ��� ������ �Լ�		
		
		String sqlSearch = "select * from emp where ename like "+ "'%" + name + "%'";
		//"select * from emp where ename like '%" + serchName + "%'";
		//"~~" �ȿ� SQL�� ���� ���� java�� ���ϴ� serchName �������� +�� ���� ������ �ؾ� ��
		
//		System.out.println("Ȯ�� : "+sqlSearch); //searchEname ���� �Ƴ�??
		try {
			pstmt = conn.prepareStatement(sqlSearch);
			rs = pstmt.executeQuery();
			List<EmpVO> list = new ArrayList<>(); //sqlSearch �������� �����ϰ� �˻�?!?!
			
			while (rs.next() == true) {
//				System.out.println("���� - "+serchName); //while�� �ȿ� ���Գ�??
				
				int empno     = rs.getInt("empno"); //rs.getInt(1)�� ���������� column�� �˾ƺ��� ����
				String ename  = rs.getString("ename");
				String job    = rs.getString("job");
				int mgr       = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate"); //java.sql.Date;
				int sal       = rs.getInt("sal");
				int comm      = rs.getInt("comm");
				int deptno    = rs.getInt("deptno"); //rs���� ������ �� ���⼭ ���ο� ������ ����
				
				EmpVO vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				//���ο� ������ ������ �� vo�� set �� //�ʵ� �� ���� ������ ���
				list.add(vo); //vo�� ����Ʈ �ȿ� ����
			}
			return list;
			//sqlSearch ���� �´� vo�� column �����ؼ� list ����Ÿ ����� 
			//while �� ������ ���� �´� vo���� �����  list �ϼ� �� return
		} catch (Exception e) {
			System.out.println("�˻��� �̸� �� ã��!?!?!?!?!!!!!");
			e.printStackTrace();
		}
		return null; //����� �� �Ǹ� null ����
	}//searchEname
	
	public void delete(String name) {
		doConnect();
		String sqlDelete = "delete from emp where ename = '" + name + "'";
		
//		System.out.println("Ȯ�� : "+sqlDelete+" | "+name);
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			rs = pstmt.executeQuery();
			
			System.out.println(name+"���� �����Ͱ� �����Ǿ����ϴ�.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//delete
	

	
	public void inputData() {
//		String[] inputData = new String[]{empno, ename, job, hiredate, sal, comm, deptno};
		
		doConnect();
		String sqlDelete = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)" + 
				"values ("+empno+", "+ename+", "+job+", "+mgr+", "+hiredate+", "+sal+", "+comm+", "+deptno+")";
		
	}

	
}//class
