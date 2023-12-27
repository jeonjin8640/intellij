package dao;

import java.sql.*;

public class MemberDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		
		return conn;
	}
	
	public int nextCustno() throws Exception{
		conn = getConnection();
		String sql = "select nvl(max(custno)+1, 100001) from member_tbl_02";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		int custno = 0;
		if( rs.next() ) {
			custno = rs.getInt(1);
			
		}
		return custno;
	}
}


