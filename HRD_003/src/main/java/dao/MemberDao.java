package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	List<Member> aList = new ArrayList<Member>();
	
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
			custno = rs.getInt(1); //결과의 첫번째 값 가져오기
			
		}
		return custno;
	}
	
	public int insert(Member member) throws Exception {
		conn = getConnection();
		String sql = "insert into member_tbl_02 values(?, ?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, member.getCustno());
		pstmt.setString(2, member.getCustname());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getAddress());
		pstmt.setString(5, member.getJoindate());
		pstmt.setString(6, member.getGrade());
		pstmt.setString(7, member.getCity());
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public List<Member> selectAll() throws Exception{
		conn = getConnection();
		
		String sql = "select custno, custname, phone, address, "
				+ "to_char(joindate, 'YYYY-MM-DD') as joindate, "
				+ "decode(grade, 'A', 'VIP', 'B', '일반', '직원') as grade, "
				+ "city from member_tbl_02 order by custno asc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if( rs.next() ) {
			do {
			
			Member member = new Member();
			member.setCustno(rs.getInt(1));
			member.setCustname(rs.getString(2));
			member.setPhone(rs.getString(3));
			member.setAddress(rs.getString(4));
			member.setJoindate(rs.getString(5));
			member.setGrade(rs.getString(6));
			member.setCity(rs.getString(7));
			aList.add(member);
			
			}while(rs.next());
		}
		
		return aList;
	}
}


