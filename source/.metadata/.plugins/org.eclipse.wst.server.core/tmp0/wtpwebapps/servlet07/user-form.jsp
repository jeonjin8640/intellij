<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management System</title>
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
		<form method="post" action="insert">
			<label>User Name : </label>
			<input type="text" name="username" /><br />
			<label>User Email : </label>
			<input type="text" name="email" /><br />
			<label>User Password : </label>
			<input type="text" name="passwd" /><br />
			<input type="submit" value="Add User" />
		</form>
	</main>

</body>
</html>