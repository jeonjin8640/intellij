<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberDao" class="dao.MemberDao"></jsp:useBean>

<%
	int custno = memberDao.nextCustno();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원등록 시스템</title>
<link href="css/style.css" rel="stylesheet" />

</head>
<body>
<%@ include file="include/header.jsp" %>
<section>
	<div class="container">
		<h1>홈쇼핑 회원 등록</h1>
		<form method="post" action="add_pro.jsp" onsubmit="return frmCheck()">
			<table>
				<tbody>
					<tr>
						<th>회원번호(자동발생)</th>
						<td>
							<input type="text" name="custno" readonly value="<%=custno %>"/>
						</td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td>
							<input type="text" name="custname">
						</td>
					</tr>
					<tr>
						<th>회원전화번호</th>
						<td>
							<input type="text" name="phone">
						</td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td>
							<input type="text" name="address">
						</td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td>
							<input type="text" name="joindate">
						</td>
					</tr>
					<tr>
						<th>고객등급[A:VIP, B:일반, C:직원]</th>
						<td>
							<input type="text" name="grade">
						</td>
					</tr>
					<tr>
						<th>도시코드[서울:01]</th>
						<td>
							<input type="text" name="city">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="회원가입">
							<input type="button" value="목록으로" onclick="loacation.href='list.jsp'">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</section>
<%@ include file="include/footer.jsp" %>
<script src="js/formCheck.js"></script>
</body>
</html>