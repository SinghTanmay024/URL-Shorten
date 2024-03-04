package com.assignment.urlshortner.shorturl;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.urlshortner.user.User;

@SuppressWarnings("serial")
@WebServlet("/shorten-url")
public class CreateShortUrl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        User user = (User) req.getSession().getAttribute("user");
        if(user == null) resp.sendRedirect("/UrlShortener/user/login.jsp");
        
        if (url != null && !url.isEmpty()) {
            try {
                String shortUrlString = generateShortUrl();
                ShortURL shortURL = new ShortURL();
                shortURL.setUrl(url);
                shortURL.setShortURL(shortUrlString);
                shortURL.setUser(user);
                
                new ShortUrlDao().saveURL(shortURL);
                
                req.setAttribute("shortURL", shortUrlString);
                req.getRequestDispatcher("user/dashboard.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to shorten URL");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "URL parameter is missing or empty");
        }
    }

    private String generateShortUrl() {
    	 String base = UUID.randomUUID().toString();
         Random random = new Random();
         
         StringBuilder builder = new StringBuilder();
         for(int i=0; i<8; i++) {
             builder.append(base.charAt(random.nextInt(base.length())));
         }
         
         return "http://localhost:8080/UrlShortener/rd/"+builder.toString();
         
    }
}

