package dao;

import java.awt.print.*;
import java.sql.*;
import java.util.*;

import dto.Book;

public class BookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	List<Book> aList = new ArrayList<Book>();
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		
		return conn;
	}
	
	public int nextbookId() throws Exception{
		conn = getConnection();
		String sql = "select nvl(max(book_id)+1, 101) from books";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		int BookId = 0;
		if( rs.next() ) {
			BookId = rs.getInt(1);
			
		}
		return BookId;
	}
	
	public int insert(Book book) throws Exception {
		conn = getConnection();
		String sql = "insert into books values(?, ?, ?, ?, ?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, book.getBook_id());
		pstmt.setString(2, book.getBook_name());
		pstmt.setInt(3, book.getBook_price());
		pstmt.setInt(4, book.getBook_stock());
		pstmt.setString(5, book.getBook_discount());
		pstmt.setString(6, book.getBook_type());
		pstmt.setString(7, book.getBook_content());
		pstmt.setString(8, book.getBook_reg());
		pstmt.setInt(9, book.getSmallC());
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public List<Book> selectAll() throws Exception{
		conn = getConnection();
		
		String sql = "select bookId, bookName, bookPrice, bookStock, "
				+ "bookDiscount, "
				+ "bookType,"
				+ "bookContent,"
				+ "to_char(bookReg, 'YYYY-MM-DD') as bookReg, "
				+ "smallC from book order by smallC asc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if( rs.next() ) {
			do {
			
			Book book = new Book();
			book.setBook_id(rs.getInt(1));
			book.setBook_name(rs.getString(2));
			book.setBook_price(rs.getInt(3));
			book.setBook_stock(rs.getInt(4));
			book.setBook_discount(rs.getString(5));
			book.setBook_type(rs.getString(6));
			book.setBook_content(rs.getString(7));
			book.setBook_reg(rs.getString(8));
			book.setSmallC(rs.getInt(9));
			aList.add(book);
			
			}while(rs.next());
		}
		
		return aList;
	}
}
