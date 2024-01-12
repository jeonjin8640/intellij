<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
       
<%@ page import="java.util.*" %>    
<%@ page import="dto.Book" %>
        
<jsp:useBean id="bookDao" class="dao.BookDao"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리 시스템</title>
<link href="css/style.css" rel="stylesheet" />

</head>
<body>
<%@ include file="include/header.jsp" %>
<section>
	<div class="container">
		<h1>▶도서 목록</h1>
		<table>
			<form method="post" action="list.jsp" onsubmit="return frmDeleteCheck()">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>가격</th>
					<th>재고</br>수량</th>
					<th>할인율</th>
					<th>도서유형</th>
					<th>등록일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			<%
				List<Book> list = bookDao.selectAll(); 
				for(int i = 0; i < list.size(); ++i) {
			%>
				<tr>
					<td>
						<%= list.get(i).getSmallC() %>
					</td>
					<td>
						<%= list.get(i).getBook_id() %>
					</td>
					<td>
						<%= list.get(i).getBook_name() %>
					</td>
					<td>
						<%= list.get(i).getBook_price() %>
					</td>
					<td>
						<%= list.get(i).getBook_stock() %>
					</td>
					<td>
						<select>
							<option><%= list.get(i).getBook_discount() %></option>
						</select>
					</td>
					<td>
						<select>
							<option><%= list.get(i).getBook_type() %></option>
						</select>
					</td>
					<td>
						<%= list.get(i).getBook_reg() %>
					</td>
					<td>
						<input type="submit" value="보기">
						<input type="submit" value="수정">
						<input type="submit" value="삭제" onclick="location.href='list.jsp'">
					</td>
				</tr>
			<% } %>	
			</tbody>
			</form>
		</table>
				
	</div>	
</section>
<%@ include file="include/footer.jsp" %>
<script src="js/formDeleteCheck.js"></script>
</body>
</html>








