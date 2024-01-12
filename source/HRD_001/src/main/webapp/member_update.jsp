<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%@ page import="db.DBConnect" %>

    
<%
	int id = Integer.parseInt(request.getParameter("id"));

	request.setCharacterEncoding("UTF-8");
	Connection conn = DBConnect.getConnection();
	
	String sql = "select * from member where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, id);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 페이지</title>
</head>
<body>
<form method="post" action="member_update_pro.jsp" onsubmit="return frmCheck();">
	사용자 아이디 : <input type="text" name="userid" value="<%=rs.getString("userid") %>"/><br />
	사용자 이름 : <input type="text" name="username" value="<%=rs.getString("username") %>"/><br />
	사용자 비밀번호 : <input type="password" name="userpwd" value="<%=rs.getString("userpwd") %>"/><br />
	<input type="submit" value="회원가입" />
	<input type="hidden" name="id" value="<%=rs.getInt("id") %>">
</form>
<script>
	function frmCheck(){
		if(document.querySelector("input[name=userid]").value ==''){
			alert("사용자 아이디를 입력하세요.");
			document.querySelector("input[name=userid]").focus();
			return false;
		}
	}
</script>

</body>
</html>