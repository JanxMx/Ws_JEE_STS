<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>

<body>
<h2>Spring MVC file upload example</h2>

<form:form action="${contextPath}/fileUploadSuccess.htm" enctype="multipart/form-data" method="POST">

	<form:errors path="*" cssClass="errorblock" element="div"/>

	Please select a file to upload : <input type="file" name="file" /> 
					<!-- form:input path="fileData" /-->
	<input type="submit" value="upload" />
	<span><form:errors path="file" cssClass="error" /></span>

</form:form>

</body>
</html>