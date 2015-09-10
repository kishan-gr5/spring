<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border=1>
		<thead>
				<tr>
					<th>UserId</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>DOB</th>
					<th>EmailId</th>
					<th colspan=2>Action</th>
				</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" >
				<tr>
					<td><c:out value="${user.userid}"/></td>
					<td><c:out value="${user.firstname}"/></td>
					<td><c:out value="${user.lastname}"/></td>
					<td><fmt:formatDate pattern="yyyy-mm-dd" value="${user.dob}"/></td>
					<td><c:out value="${user.emailid}" /></td>
					<td><a href="UserController?action=edit&userid=<c:out value="${user.userid}"/>">Update</a></td>
					<td><a href="UserController?action=delete&userid=<c:out value="${user.userid}"/>">Delete</a></td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	<p><a href="UserController?action=insert">AddUser</a></p>
</body>
</html>