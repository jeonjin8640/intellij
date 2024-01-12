<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.Book" %>
<jsp:useBean id="bookDao" class="dao.BookDao"></jsp:useBean>
    
<%
	request.setCharacterEncoding("UTF-8");

	int bookId 		= Integer.parseInt(request.getParameter("bookId"));
	String bookName = request.getParameter("bookName");
	int bookPrice 	= Integer.parseInt("bookPrice");
	int bookStock 	= Integer.parseInt("bookStock");
	String bookDiscount	= request.getParameter("bookDiscount");
	String bookType 	= request.getParameter("bookType");
	String bookContent 	= request.getParameter("bookContent");
	String bookReg 	= request.getParameter("bookReg");
	int smallC 	= Integer.parseInt("smallC");
	
	Book book = new Book();
	book.setBook_id(bookId);
	book.setBook_name(bookName);
	book.setBook_price(bookPrice);
	book.setBook_stock(bookStock);
	book.setBook_discount(bookDiscount);
	book.setBook_type(bookType);
	book.setBook_content(bookContent);
	book.setBook_reg(bookReg);
	book.setSmallC(smallC);
	
	bookDao.insert(book);
	
	response.sendRedirect("list.jsp");
	
%>    








