package exchange.money;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "USER01";
	private final String PW = "1234"; 
	
	private Connection conn; //접속할 놈
	
	private PreparedStatement pstmt; //SQL 문장을 수행할 놈
	
	private ResultSet rs; //문장 수행 결과를 저장할 놈
	
	
	private static AccountDao instance;
	private AccountDao() { /*singleton*/ }
	public static AccountDao getInstance() {
		if (instance == null) {
			instance = new AccountDao();
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
	
	//귀환씨과 봉규씨한테 얼마 송금
	public void sendMoney(int Money) {
		//10,000
		//귀환씨 계좌 -10,000, 봉규씨 계과 +10,000
		doConnect();
		//JDBC는 오토커밋
		String sqlShin= "update tbl_account set "
				+ "				user_money = user_money - 10000 "
				+ "		where user_name = '신귀환'";
		String sqlKim = "update tbl_account set "
				+ "				user_money = user_money + 10000 "
				+ "		where user_name = '김봉규'";
		try { //sql 이 하나면 그냥 커밋 한다 안 한다로 끝나니 커밋, 롤백 필요 없음 (작업 1개)
			  //두가지를 <한 단위>로 묶어야 하니 커밋, 롤백 필요함 (작업 2개)
			conn.setAutoCommit(false);
			PreparedStatement psShin = conn.prepareStatement(sqlShin);
			PreparedStatement psKim = conn.prepareStatement(sqlKim);
			psShin.executeUpdate();
			psKim.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback(); 
				//setAutoCommit(false) 이전에는 자동 커밋 됐음
				//그러니 롤백 범위는 setAutoCommit(false) 이후임
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
	}
	
	

	
}//class
