package com.assignment.urlshortner.shorturl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/rd/*")
public class RedirectURL extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		ShortUrlDao dao =  new ShortUrlDao();
		ShortURL shortURL = dao.findUrlByshortURL(url);
		
		if(shortURL != null) {
			shortURL.setClickCount(shortURL.getClickCount()+1);
			dao.updateURL(shortURL);
		}
		
		resp.sendRedirect(shortURL.getUrl());
	}
	
}
