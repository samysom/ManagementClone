<%@page import="com.mgmt.clone.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Employee emp =  (Employee)request.getAttribute("emp"); %>
<h1>Welcome<%= emp.getName() %></h1><br>
<%=emp.getId() %><br>
<%=emp.getSalary() %>
</body>
</html>