<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "dto.Buseo" %>
<%@ page import = "dto.Employee" %>
<jsp:useBean id="dao" class="dao.EmpDao"></jsp:useBean>

<%
	Employee emp 
		= dao.getEmployeeOne(Integer.parseInt(request.getParameter("emp_id")));
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form  method="post" action="modify_pro.jsp" onsubmit="return frmCheck()">


<table border="1" style="width:80%">
	<tr>
		<th style="width:30%">부서명</th>
		<td><select name="buseo_code">
			<option>선택하세요</option>
			<%
				request.setCharacterEncoding("utf-8");
				for( Buseo b : dao.getBuseoAll() ) {
			%>			
				<option value="<%=b.getBuseo_code()%>" <% if(emp.getBuseo_code().equals(b.getBuseo_code())){ out.println("selected"); } %> >
				<%=b.getBuseo_name()%>
				</option>
			<%
				}
			%>				
			</select></td>
	</tr>	
	<tr>
		<th style="width:30%">사원명</th>
		<td>
			<input type="text" name="emp_name" maxlength="20" value="<%=emp.getEmp_name()%>">
		</td>
	</tr>
	<tr>
		<th style="width:30%">이메일</th>
		<td>
			<input type="text" name="emp_email" value="<%=emp.getEmp_email()%>">
		</td>
	</tr>
	<tr>
		<th style="width:30%">주소</th>
		<td>
			<input type="text" name="emp_addr" value="<%=emp.getEmp_addr()%>">
			<input type="hidden" name="emp_id" value="<%=emp.getEmp_id()%> ">			
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center">
			<input type="submit" value="사원정보변경">
			<input type="reset" value="새로고침">
		</td>		
	</tr>
</table>
</form>

<script>
	function frmCheck() {
		let emp_name = document.querySelector("input[name=emp_name]"); 
		if( emp_name.value == "" ) {
			alert("사원명을 입력하세요.");
			emp_name.focus();
			return false;
		}
	}
</script>

</body>
</html>













