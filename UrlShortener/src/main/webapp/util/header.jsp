<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/stylesheet.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Short-URL</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 w-full">
    <header>
        <nav class="w-full bg-white border-b border-black p-4 flex justify-between items-center">
            <a href="/UrlShortener/user/dashboard.jsp" class="text-xl font-bold">Short-URL</a>

            <div class="flex space-x-4">
            <a href="/UrlShortener/user/dashboard.jsp" class="nav-link bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 transition duration-300">Home</a>
            <a href="/UrlShortener/user/About.jsp" class="nav-link bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 transition duration-300" >About Us</a>
                <%
                if (session.getAttribute("user") == null) {
                %>
                <div class="flex space-x-4">
                    <a href="/UrlShortener/user/login.jsp" class="nav-link bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 transition duration-300">Login</a>
                    <a href="/UrlShortener/user/register.jsp" class="nav-link bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 transition duration-300">Register</a>
                </div>
                <%
                } else {
                %>
                <div class="flex space-x-4">
                    <a href="/UrlShortener/get-analytics" class="nav-link bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 transition duration-300">Details</a>

                    <a href="/UrlShortener/logout" class="nav-link bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 transition duration-300">Logout</a>
                </div>
                <%
                }
                %>
                
            </div>
        </nav>
    </header>
</body>

</html>