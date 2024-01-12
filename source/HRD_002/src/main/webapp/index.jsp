<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.*" %>
<jsp:useBean id="buseoDao" class="dao.EmpDao"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코리아아이티 > 부서</title>
<link href="css/style.css" rel="stylesheet" />	
</head>
<body>
<jsp:include page="include/header_inc.jsp"></jsp:include>
	<%
		response.setCharacterEncoding("utf-8");
		for( Buseo b : buseoDao.getBuseoAll() ) {
	%>
	<span style="margin-left: 20px">
		<a href="list.jsp?buseo_code=<%=b.getBuseo_code()%>"><%=b.getBuseo_name() %>(<%=b.getCnt() %>)</a>
	</span>
	<% } %>	
<jsp:include page="include/footer_inc.jsp"></jsp:include>	
</body>
</html>










