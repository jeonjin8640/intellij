<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%@ page import="db.DBConnect" %>    
    
<%
	int id = Integer.parseInt(request.getParameter("id"));

	request.setCharacterEncoding("UTF-8");
	Connection conn = DBConnect.getConnection();
	
String sql = "delete from member where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, id);
	pstmt.executeUpdate();
	
	response.sendRedirect("member_list.jsp");
	
 %>    
