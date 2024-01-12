<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "dto.*" %>
<jsp:useBean id="empDao" class="dao.EmpDao"></jsp:useBean>

<%
	request.setCharacterEncoding("utf-8");
	String buseo 		= request.getParameter("buseo_code");
	String emp_name 	= request.getParameter("emp_name");
	String emp_email 	= request.getParameter("emp_email");
	String emp_addr 	= request.getParameter("emp_addr");
	int emp_id          = Integer.parseInt(request.gerParameter("emp_id"));
	
	Employee emp = new Employee();
	emp.setBuseo_code(buseo);
	emp.setEmp_name(emp_name);
	emp.setEmp_email(emp_email);
	emp.setEmp_addr(emp_addr);
	emp.setEmp_id(emp_id);
	
	
	int result = empDao.updateEmployee(emp);
	
	//1. 파라미터 전송 : <% sendRedirect() %
	//response.sendRedirect("list.jsp?buseo_code=" + buseo);
	
	
	//2. 파라미터 : jsp:forward -> 액션태그 : <% 바깥에 사용해야함
	
	
	
	//3.자바스크립트
	/*
	if( result > 0 ) {
		out.println("<script>");
		out.println("alert('사원정보가 변경되었습니다.');");
		out.println("location.href='list.jsp?buseo_code="+buseo+"'");
		out.println("</script>");
	}*/
%>    

	<jsp:forward page="list.jsp">
		<jsp:param value="<%=buseo %>" name="buseo_code"/>
	</jsp:forward>

	
















