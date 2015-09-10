 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
</head>
<body>
	<script>
		$(function(){
			$('input[name=dob]').datepicker();	
			});
	</script>
	<form action='UserController' method="post" name="frmAddUser">
		UserId: <input type="text" readonly="readonly"/> <br/>
		FirstName: <input type="text" name="firstname" value="<c:out value="${user.firstname}"/>"/> <br/>
		LastName: <input type="text" name="lastname" value="<c:out value="${user.lastname}"/>"/> <br/>
		DOB: <input type="text" name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}"/>"/> <br/>
		EmailId: <input type="text" name="emailid" value="<c:out value="${user.emailid}"/>"/> <br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>