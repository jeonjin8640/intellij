package servlet01.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {


	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("톰켓 시작");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET 방식 실행");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("userid");
		
		System.out.println("입력한 아이디" + userid);
	}

	@Override
	public void destroy() {
		System.out.println("톰켓 종료");
	}
	
}
