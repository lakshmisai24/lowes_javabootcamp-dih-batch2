<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Register</title>
</head>

<body>
<p> ${exception.errorMsg}</p>
<br>
<h2>Register here</h2>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<form:form method="POST" action="${contextPath}/Register">
   <table>
     <tr>
           <td><form:label path="name">Name:</form:label></td>
           <td><form:input path="name"/></td>
       </tr>
         <tr>
            <td><form:label path="password">Password:</form:label></td>
            <td><form:password path="password"/></td>
        </tr>
         <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email"/></td>
         </tr>
     <tr>
        <td colspan="2">
            <input type="submit" value="Register"/>
        </td>
    </tr>

    <tr>
         <td>
         <a href="${contextPath}">Home</a>
         </td>
    </tr>
</table>
</form:form>
</body>
</html>