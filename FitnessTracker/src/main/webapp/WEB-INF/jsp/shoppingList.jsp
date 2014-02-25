<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
</head>
<body>
<h1>List of Shopping List items</h1>

<u1>
<c:forEach var="i" items="${items}">
	<li>${i.id} - ${i.name } - ${i.price } </li>
	</c:forEach>
</u1>
</body>
</html>