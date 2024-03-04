<%@page import="com.assignment.urlshortner.user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/user/authenticate.jsp" %>
<%@ include file="/stylesheet.jsp" %>
<%@ include file="/util/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Short-URL</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="wh-full center">
	<div class="w-full center fd-col mt5">
			
			<% 
				String shortURL = (String) request.getAttribute("shortURL");
				if(shortURL != null){
					%>
					<p class="mt5 font-lg"> The Short URL is Here</p>
					<form action="/UrlShortener/user/dashboard.jsp" method="post" class="w-full center fd-col mt5">
						<p class="w-full text-center"><%= shortURL %></p>
						<input type="submit" value="GO" class="btn" style="background-color: green;">
					</form>
					<%
				}else {
					%>
					<p class="mt5 font-lg">Enter the URL</p>
					<form action="/UrlShortener/shorten-url" method="post" class="w-full center fd-col mt5">
						<input type="text" required="required" name="url" placeholder="Enter your URL here: " class="input">
						<input type="submit" value="Confirm" class="btn" style="background-color: green;">

					</form>
					<%
				}
			%> 
		
	</div>
</body>
</html>
 <%@ include file="/util/Footer.jsp" %>