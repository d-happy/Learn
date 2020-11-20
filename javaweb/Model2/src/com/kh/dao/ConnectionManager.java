package com.kh.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	
	// context.xml 커넥션풀에서 총 10개, 다오마다 1개씩 빼서 사용함
	public static Connection getConnection() {
		try {
			// javax.naming.Context
			Context ctx = new InitialContext(); // /META-INF/context.xml
			// javqx.sql.DataSource
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB"); // context.xml 에서 name="jdbc/OracleDB"
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} //getConnection
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} //close
	
} //ConnectionManager
