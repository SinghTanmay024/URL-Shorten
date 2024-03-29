package com.assignment.urlshortner.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class UserLogout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("user") != null) {
			req.getSession().removeAttribute("user");
			resp.sendRedirect("/UrlShortener/user/login.jsp");
		}
	}
}
