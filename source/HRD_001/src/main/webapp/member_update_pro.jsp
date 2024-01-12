<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>    
<%@ page import="db.DBConnect" %>    
    
    
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = DBConnect.getConnection();

	int id = Integer.parseInt(request.getParameter("id"));
	String userid = request.getParameter("userid");
	String username = request.getParameter("username"); 
	String userpwd = request.getParameter("userpwd");
	
	String sql = "update member set userid=?. username=?, userpwd? where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userid);
	pstmt.setString(2, username);
	pstmt.setString(3, userpwd);
	pstmt.setInt(4, id);
	pstmt.executeUpdate();
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="member_list.jsp"></jsp:forward>
<%response.sendRedirect("member_list.jsp");%>
</body>
</html>