package com.assignment.urlshortner.shorturl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.urlshortner.user.User;

@SuppressWarnings("serial")
@WebServlet("/delete-url")
public class DeleteShortURL extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null)
			resp.sendRedirect("/UrlShortener/user/login.jsp");

		int urlId = Integer.parseInt(req.getParameter("id"));
		ShortUrlDao dao = new ShortUrlDao();

		ShortURL url = dao.findShortUrlById(urlId);
		if (url != null) {
			dao.deleteURL(url);
		}
		req.setAttribute("urls", dao.findAllShortURLByUser(user));
		req.getRequestDispatcher("user/analytics.jsp").forward(req, resp);
	}
}
