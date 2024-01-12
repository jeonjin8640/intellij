package servlet06.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet06.dao.RegisterDao;
import servlet06.dto.Register;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	
	RegisterDao rd = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		rd = new RegisterDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String passwd = req.getParameter("passwd");
		String username = req.getParameter("username");
		
		Register r = new Register();
		r.setUserid(userid);
		r.setPasswd(passwd);
		r.setUsername(username);
		
		try {
			rd.registerEmp(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("list.jsp");
	}
	
	
	

}
