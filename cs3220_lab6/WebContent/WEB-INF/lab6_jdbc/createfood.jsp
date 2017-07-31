<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/lab6_app.css' />">
<title>Add New Food</title>
</head>
<body class="admin">

	<header>
		<h1>
			<img
				src="http://www.clker.com/cliparts/V/v/E/P/w/D/restaurant-hi.png"
				width="100" height="100"> American's Food Restaurant - Admin
			Site
		</h1>

	</header>
	<main>
		<h2>Add new food</h2>
		<form method="post">
			<label>Food Name:</label><br>
			<input name="name" id="name" type="text"><br><br> 
			<label>Image link: </label><br>
			<input name="url" id="url" type="text"><br><br> 
			<label>Description:</label><br>
			<textarea name='description' rows=4 cols=50 id="description"></textarea><br><br>
			<label>Price:</label><br>
			<input name="price" id="price" type="text"><br><br>
			<button name="Submit" value="Submit">Add Food</button>
		</form>
	</main>

	
	<footer>
		<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>


</body>
</html>