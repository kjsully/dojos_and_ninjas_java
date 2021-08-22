<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>New Ninja</h3>
	
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<p>
			First Name:
			<form:errors path="firstName"/>
			<form:input path="firstName" />
		</p>
		<p>
			Last Name:
			<form:errors path="lastName"/>
			<form:input path="lastName" />
		</p>
		<p>
			Age:
			<form:errors path="age"/>
			<form:input path="age" />
		</p>
		
		<p>
			<form:label path="dojo">Select Dojo</form:label>
			<form:errors path="dojo"/>
			<form:select path="dojo">
				
			<c:forEach items="${dojos}" var="doj">
				<form:option value="${doj.id}">
					${doj.name}
				</form:option>
			</c:forEach>
			</form:select>
		</p>
		
		
		
		<input type="submit" value="Submit Ninja">
	</form:form>
	
		<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ninjas}" var="n">
				<tr>
					<td><c:out value="${n.firstName}" /></td>
					<td><c:out value="${n.lastName}" /></td>
					<td><c:out value="${n.age}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/">Dashboard</a>
	
</body>
</html>