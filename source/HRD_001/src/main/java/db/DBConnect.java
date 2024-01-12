package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "system";
			String pwd = "1234";
			
			Class.forName("oracle.jdbc.OracleDriver"); //ojdbc.jar 호출하기
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공");
			
		}catch(Exception e) {}
		
		return conn;
	}
	
	
}
