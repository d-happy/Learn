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
	//이런거는 정해진 클래스에 정해진 입력방식
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//이 컴퓨터에 접속
	private final String ID = "USER01";
	private final String PW = "1234"; 
	//관리할 필드, 데이터 있으면 객체가 있어야 하나 객체 하나만 필요하면 싱글턴
	
	
	private Connection conn; //접속할 놈
	
	private PreparedStatement pstmt; //SQL 문장을 수행할 놈
	
	private ResultSet rs; //문장 수행 결과를 저장할 놈
	
	
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
			Class.forName(DRIVER); //자바에서 쓰라는 오라클에서 주는 드라이버 
			//클래스를 메모리에 로드한다
			conn = DriverManager.getConnection(URL, ID, PW);
			//접속 경로, 아이디, 비번 입력해서 접속
		} catch (Exception e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
	}
	
	public List<EmpVO> selectAll() { //List<EmpVO> return하는 함수
		doConnect();
		String sql = "select * from emp order by empno";
		try {
			pstmt = conn.prepareStatement(sql); //sql 입력해서 엔터
			rs = pstmt.executeQuery(); //엔터 치고 결과값 rs에 저장
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
			//vo 하나하나에 콜롬 데이타 다 저장해서 list 데이타 하나 만들고 while 다 끝나면 list 완성 후 return
		} catch (Exception e) {
			System.out.println("문장 수행 오류");
			e.printStackTrace();
		}
		return null; //list 콜롬 전부 다 저장 안 되면 동작 멈추지 말고 null 보낸다
	}
	
	public List<EmpVO> searchEname(String name) {
		doConnect(); //SQL이랑 연결?!
//		selectAll(); //데이터 전부 다 보낼 이유 없음, searchEname는 검색한 결과 보내는 함수		
		
		String sqlSearch = "select * from emp where ename like "+ "'%" + name + "%'";
		//"select * from emp where ename like '%" + serchName + "%'";
		//"~~" 안에 SQL만 적고 여기 java에 속하는 serchName 넣으려면 +로 따로 나눠서 해야 함
		
//		System.out.println("확인 : "+sqlSearch); //searchEname 연결 됐나??
		try {
			pstmt = conn.prepareStatement(sqlSearch);
			rs = pstmt.executeQuery();
			List<EmpVO> list = new ArrayList<>(); //sqlSearch 조건으로 저장하고 검색?!?!
			
			while (rs.next() == true) {
//				System.out.println("맞음 - "+serchName); //while문 안에 들어왔나??
				
				int empno     = rs.getInt("empno"); //rs.getInt(1)도 가능하지만 column이 알아보기 쉬움
				String ename  = rs.getString("ename");
				String job    = rs.getString("job");
				int mgr       = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate"); //java.sql.Date;
				int sal       = rs.getInt("sal");
				int comm      = rs.getInt("comm");
				int deptno    = rs.getInt("deptno"); //rs에서 가져온 걸 여기서 새로운 변수로 저장
				
				EmpVO vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				//새로운 변수로 저장한 걸 vo에 set 함 //필드 값 들어가는 생성자 사용
				list.add(vo); //vo를 리스트 안에 저장
			}
			return list;
			//sqlSearch 조건 맞는 vo에 column 저장해서 list 데이타 만들고 
			//while 다 끝나면 조건 맞는 vo들이 저장된  list 완성 후 return
		} catch (Exception e) {
			System.out.println("검색한 이름 못 찾음!?!?!?!?!!!!!");
			e.printStackTrace();
		}
		return null; //제대로 안 되면 null 보냄
	}//searchEname
	
	public void delete(String name) {
		doConnect();
		String sqlDelete = "delete from emp where ename = '" + name + "'";
		
//		System.out.println("확인 : "+sqlDelete+" | "+name);
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			rs = pstmt.executeQuery();
			
			System.out.println(name+"님의 데이터가 삭제되었습니다.");
			
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
