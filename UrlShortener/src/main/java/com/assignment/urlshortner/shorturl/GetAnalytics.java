package com.assignment.urlshortner.shorturl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.urlshortner.user.User;

@SuppressWarnings("serial")
@WebServlet("/get-analytics")
public class GetAnalytics extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if(user == null) resp.sendRedirect("/UrlShortener/user/login.jsp");
		
		List<ShortURL> urls = new ShortUrlDao().findAllShortURLByUser(user);
		if(urls != null && !urls.isEmpty()) {
			req.setAttribute("urls", urls);
			req.getRequestDispatcher("user/analytics.jsp").forward(req, resp);
		}
	}
}
