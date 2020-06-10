<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
<style type="text/css">
.error {
	color: red
}
</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">

	First Name (*): <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br>
		<br>
	
	Last Name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br>
		<br>
	
	Free Passes (*): <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		<br>
		<br>
	
	PostalCode (*): <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br>
		<br>
	
	CourseCode (*): <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />
		<br>
		<br>

		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>