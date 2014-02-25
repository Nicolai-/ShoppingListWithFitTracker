<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
</head>
<body>
	<h1>List of Shopping List items</h1>
	<form:form commandName="item">
		<table border="3">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Bought</th>
				<th>Delete</th>
			</tr>
			<u1> <c:forEach var="i" items="${items}">
				<tr>
					<td>${i.id}</td>
					<td>${i.name }</td>
					<td>${i.price }</td>

					<td align="center"><input type="checkbox" name="bought"
						value="${i.id}"
						<c:if test="${i.bought == true}" > checked="${i.bought}"</c:if> /></td>


					<td align="center"><input type="checkbox" name="delete"
						value="${i.id}" /></td>
				</tr>
			</c:forEach> </u1>
		</table>
		<input type="submit" value="Update" />
	</form:form>
	<br>
	<form name="addNew" action="addItem.html">
		<input type="submit" value="Add New Item" />
	</form>
</body>
</html>