package com.assignment.urlshortner.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class UserLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new UserDao().findByEmail(email);
		if(user.getPassword().equals(password))
		req.getSession().setAttribute("user", user);
		
//		req.getRequestDispatcher("user/dashboard.jsp").forward(req, resp);
		resp.sendRedirect("user/dashboard.jsp");
	}

}
