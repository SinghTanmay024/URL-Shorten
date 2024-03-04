<%@page import="com.assignment.urlshortner.shorturl.ShortURL"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/user/authenticate.jsp"%>
<%@ include file="/stylesheet.jsp"%>
<%@ include file="/util/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Short-URL</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
</head>
<body class="wh-full center">
	<div class="w-full center fd-col mt5">
	<div class="w-80 center end"><a href="/UrlShortener/user/dashboard.jsp" class="btn">Back</a></div>
		<table class="w-80" cellspacing="0">
			<tr class="bg1">
				<th class="p1">Short-URL</th>
				<th class="p1"> Count</th>
				<th  class="p1">Remove</th>
			</tr>
			<% 
				List<ShortURL> urls = (List<ShortURL>) request.getAttribute("urls");
				if(urls != null && !urls.isEmpty()){
					for(ShortURL url : urls){
			%>
						<tr>
							<td class="bb1 p1"> <a href="<%= url.getShortURL() %>"><%= url.getShortURL() %></a> </td>
							<td class="bb1 p1 text-center"><%= url.getClickCount() %></td>
							<td class="bb1 p1 text-center"> 
								<a  href="/UrlShortener/delete-url?id=<%=url.getUrlId()%>" class="nav-link link-hover">Delete</a> 
							</td>
						</tr>
					<%
					}
				}
			%>
		</table>
	</div>
</body>
</html>
 <%@ include file="/util/Footer.jsp" %>