package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import dto.Buseo;
import dto.Employee;

public class EmpDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBConnect db = new DBConnect();
	List<Buseo> list = new ArrayList<Buseo>();
	List<Employee> empList = new ArrayList<Employee>(); 
	
	public List<Buseo> getBuseoAll() throws SQLException {
		conn = db.getConnection();
		
		String sql = "SELECT B.buseo_name, B.buseo_code, count(emp_id) as cnt FROM \r\n"
				+ "buseo B LEFT JOIN employees E ON B.buseo_code = E.buseo_code \r\n"
				+ "GROUP BY B.buseo_name, B.buseo_code ORDER BY B.buseo_code ASC";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if( rs.next() ) {
			do {
				Buseo buseo = new Buseo();
				buseo.setBuseo_code(rs.getString("buseo_code"));
				buseo.setBuseo_name(rs.getString("buseo_name"));
				buseo.setCnt(rs.getInt("cnt"));
				
				list.add(buseo);
				
			}while(rs.next());
		}
		
		return list;
	}
	
	
	//입력
	public int insertEmployee(Employee emp) throws SQLException {
		conn = db.getConnection();

		String sql = "INSERT INTO employees VALUES(emp_seq.nextval, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmp_name());
		pstmt.setString(2, emp.getEmp_email());
		pstmt.setString(3, emp.getEmp_addr());
		pstmt.setString(4, emp.getBuseo_code());
		int row = pstmt.executeUpdate();
		
		return row;
	}		
	
	//수정
	public int updateEmployee(Employee emp) throws SQLException {
		conn = db.getConnection();
		String sql = "update employees set buseo_code=?, emp_name=?, emp_email=?, emp_addr=? where emp_id=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getBuseo_code());
		pstmt.setString(2, emp.getEmp_name());
		pstmt.setString(3, emp.getEmp_email());
		pstmt.setString(4, emp.getEmp_addr());
		pstmt.setInt(5, emp.getEmp_id());
		pstmt.executeUpdate();
		int result = pstmt.executeUpdate();
		
		return result;
		
	}
	
	//삭제
	public int deleteEmployee(int emp_id) throws SQLException {
		conn = db.getConnection();
		String sql = "delete from employees where emp_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, emp_id);
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	//1명 출력
	public Employee getEmployeeOne(int emp_id) throws SQLException {
		
		conn = db.getConnection();
		String sql = "SELECT B.buseo_name, E.* FROM buseo B INNER JOIN Employees E ON "
				+ "B.buseo_code = E.buseo_code WHERE E.emp_id = ? ORDER BY E.emp_id DESC";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, emp_id);
		rs = pstmt.executeQuery();
		
		Employee emp = new Employee();
		if( rs.next() ) {			
			emp.setBuseo_code(rs.getString("buseo_code"));
			emp.setBuseo_name(rs.getString("buseo_name"));
			
			emp.setEmp_id(rs.getInt("emp_id"));
			emp.setEmp_name(rs.getString("emp_name"));
			emp.setEmp_email(rs.getString("emp_email"));
			emp.setEmp_addr(rs.getString("emp_addr"));
		}
			
		return emp;		
	}
	
	//전체 출력
	public List<Employee> getEmployeeAll(String buseo_code) throws SQLException {
		conn = db.getConnection();
		String sql = "SELECT B.buseo_name, E.* FROM buseo B INNER JOIN Employees E ON "
				+ "B.buseo_code = E.buseo_code WHERE B.buseo_code = ? ORDER BY E.emp_id DESC";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, buseo_code);
		rs = pstmt.executeQuery();
		
		if( rs.next() ) {
			
			do {
				Employee emp = new Employee();
				emp.setEmp_id( rs.getInt("emp_id") );
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_email(rs.getString("emp_email"));
				emp.setEmp_addr(rs.getString("emp_addr"));
				emp.setBuseo_code(rs.getString("buseo_code"));
				emp.setBuseo_name(rs.getString("buseo_name"));
				
				empList.add(emp);
				
			}while(rs.next());
			
		}
		
		return empList;
	}
	
}








