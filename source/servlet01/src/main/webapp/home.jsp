<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/servlet01/login">로그인 페이지로 이동</a>
<br />
<br />

<form method="post" action="/servlet01/login">
	<div>
				Servlet -> httpServlet 상속(extends) - servlet-api.jar<br/>
		<br/>
		1. Servlet, ejb -> spring framework -> spring boot<br/>
		     xml, @              xml, @                  @<br/>
		     tomcat x            tomcat x               +tomcat<br/>
		<br/>
		web, xml -> context.xml server.xml : application.properties<br/>
		                  실제 서비스                        작업<br/>
		<br/>
		shell script : c<br/>
		<br/>
		controller : servlet + web.xml<br/>
	</div>
	<input type="text" name="userid">
	<input type="submit" value="로그인">
</form>

</body>
</html>