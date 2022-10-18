<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.ArrayList, Modal.Product, Servlet.Controller_Login"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
body {
	margin: 0px;
	background-color: #F3EBF6;
}

.topBar {
	position: relative;
	top: 0px;
	width: 99.8%;
	height: 15%;
	background-color: white;
	text-align: center;
	border-radius: 10px;
	border: 2px solid purple;
}

.home {
	color: purple;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-size: 40px;
	text-decoration: none;
}

.product {
	border: 2px solid purple;
	display: inline-block;
}
#margin{
	margin: 2% 8% 2% 4%;
}
#margin3{
		margin: 2% 0% 2% 2%;
}

img {
	width: 310px;
	height: 310px;
}

a {
	color: purple;
	font-family: 'Times New Roman', Times, serif;
	font-size: 17px;
}
p{
	text-align: center;
}
</style>
</head>
<body>
	<div class="topBar">
		<ul><a class="home" href="./home">Home</a></ul>
	</div>

	<c:forEach items="${prods}" var="item">

		<c:choose>
			<c:when test="${item.get('id') % 3 == '0'}">
				<div class="product" id="margin3">
					<img src="${item.get('url')}">
					<p>
						<a href="Controller_showProduct?id=${item.get('id')}">
							${item.get('name')}--${item.get('price')} TL</a>
					</p>
				</div>
			</c:when>
			<c:otherwise>
				<div class="product" id="margin">
					<img src="${item.get('url')}">
					<p>
						<a href="Controller_showProduct?id=${item.get('id')}">
							${item.get('name')}--${item.get('price')} TL</a>
					</p>
				</div>
			</c:otherwise>
		</c:choose>


	</c:forEach>

</body>
</html>