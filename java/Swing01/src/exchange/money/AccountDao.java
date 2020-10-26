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
	
	private Connection conn; //������ ��
	
	private PreparedStatement pstmt; //SQL ������ ������ ��
	
	private ResultSet rs; //���� ���� ����� ������ ��
	
	
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
			Class.forName(DRIVER); //�ڹٿ��� ����� ����Ŭ���� �ִ� ����̹� 
			//Ŭ������ �޸𸮿� �ε��Ѵ�
			conn = DriverManager.getConnection(URL, ID, PW);
			//���� ���, ���̵�, ��� �Է��ؼ� ����
		} catch (Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}
	
	//��ȯ���� ���Ծ����� �� �۱�
	public void sendMoney(int Money) {
		//10,000
		//��ȯ�� ���� -10,000, ���Ծ� ��� +10,000
		doConnect();
		//JDBC�� ����Ŀ��
		String sqlShin= "update tbl_account set "
				+ "				user_money = user_money - 10000 "
				+ "		where user_name = '�ű�ȯ'";
		String sqlKim = "update tbl_account set "
				+ "				user_money = user_money + 10000 "
				+ "		where user_name = '�����'";
		try { //sql �� �ϳ��� �׳� Ŀ�� �Ѵ� �� �Ѵٷ� ������ Ŀ��, �ѹ� �ʿ� ���� (�۾� 1��)
			  //�ΰ����� <�� ����>�� ����� �ϴ� Ŀ��, �ѹ� �ʿ��� (�۾� 2��)
			conn.setAutoCommit(false);
			PreparedStatement psShin = conn.prepareStatement(sqlShin);
			PreparedStatement psKim = conn.prepareStatement(sqlKim);
			psShin.executeUpdate();
			psKim.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback(); 
				//setAutoCommit(false) �������� �ڵ� Ŀ�� ����
				//�׷��� �ѹ� ������ setAutoCommit(false) ������
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
