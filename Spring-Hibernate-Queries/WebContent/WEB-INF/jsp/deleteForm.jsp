<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
	<a href="list.htm">Insertar</a>
	<form:form action="delete.htm" commandName="contact">
		<table>
			<tr>
				<td>id :</td>
				<td><form:input path="id" /></td>
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Delete"></td>
			</tr>		
		</table>
	</form:form>
</body>
</html>