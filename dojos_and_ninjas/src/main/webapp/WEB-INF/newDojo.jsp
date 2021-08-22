<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
	<h3>New Dojo</h3>
	
	<form:form action="/dojos" method="post" modelAttribute="dojo">
		<p>
			Name:
			<form:errors path="name"/>
			<form:input path="name" />
		</p>
		
		<input type="submit" value="Create Dojo">
	</form:form>
	
	
	<c:forEach items="${dojos}" var="d">
		<li><a href="dojos/${d.id}"><c:out value="${d.name}"/></a></li>
	</c:forEach>
	
	<a href="/">Dashboard</a>
	
</body>
</html>