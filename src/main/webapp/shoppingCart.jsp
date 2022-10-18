<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
	<c:forEach items="${shoppingProducts}" var="item">
		<a href="Controller_showProduct?id=${item.get('id')}"><c:out value="${item.get('name')}"></c:out></a>
		<a href="./Controller_shoppingCart?id=${item.get('id')}">Delete</a>
<br>
	</c:forEach>
</body>
</html>