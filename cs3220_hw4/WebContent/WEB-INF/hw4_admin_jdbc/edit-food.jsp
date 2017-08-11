<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%-- Import the JSTL --%>
<%@ taglib uri="admin-header-hw4.tld" prefix="myTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/hw4_app.css' />">
<title>Edit Food</title>
</head>
<body class="admin">

	<main>
		<h2>Edit Food</h2>
		<form method="post">
			<label>Food Name:</label><br>
			<input name="name" id="name" type="text" value="${edit_item.name}"><br><br> 
			<label>Image link: </label><br>
			<input name="url" id="url" type="text" value="${edit_item.url}"><br><br> 
			<label>Description:</label><br>
			<textarea name='description' id="description">${edit_item.description}</textarea><br><br>
			<label>Price:</label><br>
			<input name="price" id="price" type="text" value="${edit_item.price}"><br><br>
			<button name="Submit" value="Submit">Edit Food</button>
		</form>
		
	</main>

	
	<footer>
		<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>


</body>
</html>