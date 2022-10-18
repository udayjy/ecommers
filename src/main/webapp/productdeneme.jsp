<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "Modal.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
	<%
		Product product = (Product) request.getAttribute("product");
		String name = product.getName();
		String desc = product.getDescription();
		float price = product.getPrice();
		int quantity = product.getQuantity();
	%>
	<h1> Product Details </h1>
	<p> Name: <%= name %></p>
	<p> Description: <%= desc %> </p>
	<p> Price : <%= price %> </p>
	<p> Quantity: <%= quantity %></p>
</body>
</html>