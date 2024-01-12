<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<form method="post" action="member_join_pro.jsp" onsubmit="return frmCheck();">
	사용자 아이디 : <input type="text" name="userid" /><br />
	사용자 이름 : <input type="text" name="username" /><br />
	사용자 비밀번호 : <input type="password" name="userpwd" /><br />
	<input type="submit" value="회원가입" />
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