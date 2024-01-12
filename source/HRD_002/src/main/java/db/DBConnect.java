package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	
	//데이터베이스 연결 객체
	public Connection getConnection() {
		Connection conn = null;
		
		String url 	= "jdbc:oracle:thin:@localhost:1521:xe";
		String id 	= "system";
		String pwd 	= "1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("오라클 데이터베이스 연결...");
			
		}catch(Exception e) {}
		
		return conn;
	}	
}







