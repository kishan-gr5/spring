<%@page import="com.customer.servlet.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		Customer customer = (Customer)req.getAttribute("customer");
	%>
	
	<table border="1" bgcolor="grey" align="center">
		<tr>
			<td colspan="2" align="center">Welcome + <%= customer.getName() %></td>
		</tr>
		
		<tr>
			<th>NAME</th>
			<td><%= customer.getName()%></td>
		</tr>
		
		<tr>
			<th>ADDRESS</th>
			<td><%= customer.getAddress()%></td>
		</tr>
		
		<tr>
			<th>MOBILE</th>
			<td><%= customer.getMobile()%></td>
		</tr>
		
		<tr>
			<th>EMAILID</th>
			<td><%= customer.getEmailid()%></td>
		</tr>
	
	</table>
</body>
</html>