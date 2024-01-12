<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h2>
			<a href="new">Add User</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="list">List Users</a>
		</h2>
	</header>
	
	<main>
		<table border="1" style="width:100%">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>비밀번호</th>
				<th>비고</th>
			</tr>
			
			<c:forEach var="user" items="${users}">
			
			<tr>
				<td>
					<c:out value="${user.id}"></c:out>
				</td>
				<td>
					<c:out value="${user.username}"></c:out>
				</td>
				<td>
					<c:out value="${user.email}"></c:out>
				</td>
				<td>
					<c:out value="${user.passwd}"></c:out>
				</td>
				<td>수정/삭제</td>
			</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>