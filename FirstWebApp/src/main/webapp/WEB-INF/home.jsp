<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    

<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addAlien" method="post" modelAttribute="alien5">
	aid : <sform:input  path="aid" /><br>
	aname : <sform:input  path="aname" /><br>
	age : <sform:input  path="age"/><br>
	<input type="submit">
</sform:form>
<hr>
<form action="divide" method="get">
	<input type="text" name="t1"><br>
	<input type="text" name="t2"><br>

	<input type="submit">
</form>


</body>
</html>