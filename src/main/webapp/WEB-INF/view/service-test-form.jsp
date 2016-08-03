<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="serviceTestForm">
		<form:label path="expression"></form:label>
		<br>
		<form:input path="expression" />
		<form:errors path="expression">expression has errors!</form:errors>
		<input type="submit">
	</form:form>

	<c:if test="${not empty serviceTestResult.result}">
	result: ${serviceTestResult.result}
	</c:if>

	
	<c:if test="${not empty serviceTestError}">
		<c:choose>
			<c:when test="${serviceTestError.errorType eq 'CLIENT_ERROR'}">
				calculator service error: client error
			</c:when>
			<c:when test="${serviceTestError.errorType eq 'SERVER_ERROR'}">
				calculator service error: server error
			</c:when>
			<c:otherwise>
				calculator service error
			</c:otherwise>	
		</c:choose>
	</c:if>

</body>
</html>