<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
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
		<h1>▶상품등록</h1>
		<form method="post" action="add_pro.jsp" onsubmit="return frmCheck()">
			<table>
				<tbody>
					<tr>
						<th>도서분류</th>
						<select name="smallC">
							<option>소설/시</option>
							<option>인문</option>
							<option>예술</option>
							<option>사회</option>
							<option>IT모바일</option>
							<option>ELT사전</option>
							<option>문학/소설</option>
							<option>경제/경영</option>
						</select>
					</tr>
					<tr>
						<th>도서번호</th>
						<td>
							<input type="text" name="bookId" readonly value="<%=bookDao.nextbookId() %>" />
						</td>
					</tr>
					<tr>
						<th>도서명</th>
						<td>
							<input type="text" name="bookName" />
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>
							<input type="text" name="bookPrice" />
						</td>
						<th>재고수량</th>
						<td>
							<input type="text" name="bookStock" />
						</td>
						<th>할인율</th>
						<td>
							<select name="bookDiscount">
								<option>0%</option>
								<option>10%</option>
								<option>20%</option>
								<option>30%</option>
								<option>40%</option>
								<option>50%</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>도서유형</th>
						<td>
							<select name="bookType">
								<option>신상품</option>
								<option>베스트</option>
								<option>이벤트</option>
								<option>일반</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>도서내용</th>
						<td>
							<input type="text" name="BookContent" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="도서등록">
							<input type="button" value="도서목록" onclick="location.href='list.jsp'">
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








