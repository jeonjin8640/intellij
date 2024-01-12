package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Member;
import dto.Money;

public class MemberDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	List<Member> aList = new ArrayList<Member>();
	List<Money> mList = new ArrayList<Money>();
	
	public static Connection getConnetion() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
				"system", "1234");		
		return conn;		
	}
	
	public int nextCustno() throws Exception {
		conn = getConnetion();
		String sql = "SELECT NVL(MAX(custno)+1, 100001) FROM member_tbl_02";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		int custno = 0;
		if( rs.next() )
			custno = rs.getInt(1); //결과의 첫번째 값 가져오기
		
		
		return custno;
	}
	
	public int insert(Member member) throws Exception {
		conn = getConnetion();
		String sql = "INSERT INTO MEMBER_TBL_02 VALUES(?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
		
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
	
	public List<Member> selectAll() throws Exception {
		conn = getConnetion();
		
		String sql = "SELECT custno, custname, phone, address, "
				+ "TO_CHAR(joindate, 'YYYY-MM-DD') AS joindate, "
				+ "DECODE(grade, 'A', 'VIP', 'B', '일반', '직원') AS grade, "
				+ "city FROM MEMBER_TBL_02 ORDER BY custno ASC";
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
	
	public List<Money> salesResult() throws Exception {
		conn = getConnetion();
		String sql = "SELECT A.custno, A.custname, \r\n"
				+ "DECODE(A.grade, 'A', 'VIP', 'B', '일반', '직원') AS grade,\r\n"
				+ "SUM(B.price) AS price\r\n"
				+ "FROM MEMBER_TBL_02 A, MONEY_TBL_02 B \r\n"
				+ "WHERE A.custno = B.custno GROUP BY A.custno, A.custname, A.grade \r\n"
				+ "ORDER BY price DESC";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if( rs.next() ) {
			do {
				Money money = new Money();
				money.setCustno(rs.getInt(1));
				money.setCustname(rs.getString(2));
				money.setGrade(rs.getString(3));
				money.setPrice(rs.getInt(4));
				
				mList.add(money);								
			}while(rs.next());
		}
		
		return mList;
	}
}

















