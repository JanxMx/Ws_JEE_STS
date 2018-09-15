<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.even {
	background-color: silver;
}
</style>
<title>Registration Page</title>
</head>
<body>
	<a href="formDelete.htm">Borrar</a>
	<form:form action="add.htm" commandName="contact">
		<table>
			<tr>
				<td>id :</td>
				<td><form:input path="id" /></td>
			</tr>			
			<tr>
				<td>First name :</td>
				<td><form:input path="firstName" /></td>
			</tr>	
			<tr>
				<td>Last name :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>		
		</table>
	</form:form>
	<c:if test="${fn:length(contactList) > 0}">
		<table cellpadding="5">
			<tr class="even">
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${contactList}" var="contact" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td>${contact.id}</td>
					<td>${contact.firstName}</td>
					<td>${contact.lastName}</td>
					<td>${contact.email}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
