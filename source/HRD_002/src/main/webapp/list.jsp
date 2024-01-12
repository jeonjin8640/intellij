<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.*" %>    
<%@ page import = "dto.*" %>
<jsp:useBean id="empDao" class="dao.EmpDao"></jsp:useBean>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" />	
</head>
<body>
<jsp:include page="include/header_inc.jsp"></jsp:include>
<a href="insert.jsp">사원등록</a>
<table border="1" style="width:80%">
	<thead>
		<tr>
			<th>부서명</th>
			<th>사원명</th>
			<th>이메일</th>
			<th>주소</th>
			<th>비고</th>
		</tr>
	</thead>
	<tbody>
	<%
		response.setCharacterEncoding("utf-8");
		List<Employee> list = empDao.getEmployeeAll(request.getParameter("buseo_code"));
		
		if( list.size() > 0 ) {	 		
			for( Employee emp : list) {
	%>
		<tr>
			<td>
				<%=emp.getBuseo_name() %>
			</td>
			<td>
				<%=emp.getEmp_name() %>
			</td>
			<td>
				<%=emp.getEmp_email() %>
			</td>
			<td>
				<%=emp.getEmp_addr() %>
			</td>
			<td>
				<a href="modify.jsp?emp_id=<%=emp.getEmp_id()%>">
					<button>수정</button>
				</a>			
				<a href="#" onclick="deleteEmp(<%=emp.getEmp_id()%>, <%=emp.getBuseo_code()%>)">
					<button>삭제</button>
				</a>	
			</td>	
		</tr>
	<% 
			}
		}else{
	%>		
	
		<tr>
			<td colspan="5" style="text-align:center">등록된 사원이 없습니다.</td>
		</tr>
	
	<% } %>
	</tbody>
</table>
<jsp:include page="include/footer_inc.jsp"></jsp:include>

<script>
	function deleteEmp(emp_id, buseo_code){
		if(confirm("사원정보를 삭제하시겠습니까?")){
			location.href = "delete_pro.jsp?emp_id="+emp_id+"&buseo_code="+buseo_code+";
		}
	}
</script>

</body>
</html>










