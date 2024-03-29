package servlet06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import servlet06.dto.Register;

public class RegisterDao {
	
	public int registerEmp(Register reg) throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		
		String INSERT_SQL = "insert into emp values(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
		pstmt.setString(1, reg.getUserid());
		pstmt.setString(2, reg.getPasswd());
		pstmt.setString(3, reg.getUsername());
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
}
