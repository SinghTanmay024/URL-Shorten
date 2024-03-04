<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/stylesheet.jsp" %>
<%@ include file="/util/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Short-URL</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="bg-gray-100 flex items-center justify-center h-screen">
    <div class="bg-white p-8 rounded shadow-md w-full max-w-md">
        <h1 class="text-2xl font-bold mb-4">Register</h1>
        <form action="/UrlShortener/register" method="post" class="flex flex-col space-y-4">
            <input type="text" required="required" name="username" placeholder="Enter Name:" class="p-2 border border-gray-300 rounded">
            <input type="email" required="required" name="email" placeholder="Enter Email:" class="p-2 border border-gray-300 rounded">
            <input type="password" required="required" name="password" placeholder="Enter Password:" class="p-2 border border-gray-300 rounded">
            <input type="text" name="Mobile Number" placeholder="Enter Mob Number:" class="p-2 border border-gray-300 rounded">
            <input type="text"  name="Address" placeholder="Enter Enter Address" class="p-2 border border-gray-300 rounded">
            <button type="submit" class="bg-blue-500 text-white py-2 rounded hover:bg-blue-600 focus:outline-none focus:shadow-outline-blue">
                Submit
            </button>
        </form>
    </div>
</html>
 <%@ include file="/util/Footer.jsp" %>