<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/lab6_app.css' />">
<title>FoodMenu</title>
</head>
<body class="admin">

	<header>
		<h1>
			<img
				src="http://www.clker.com/cliparts/V/v/E/P/w/D/restaurant-hi.png"
				width="100" height="100"> American's Food Restaurant - Admin
			Site
		</h1>
		<nav>
			<ul>

				<li><a href="lab6_foods">Food Menu</a></li>

			</ul>
		</nav>
	</header>

	<main>


	<h2>Food Menu - Admin</h2>


	<table>
		<thead>
			<tr>
				<th>Food ID</th>
				<th>Food Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Delete</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="entry">
			<tr>
				<td>${entry.id}</td>
				<td><img src=${entry.url } width="200" height="100"><br>
					${entry.name}</td>
				<td>${entry.description}</td>
				<td>$ ${entry.price}</td>
				<td><form method="get">
						<button name="Delete" value="${entry.id}">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>


	<button onclick="location.href='lab6_foods/new'">Add New Food</button>
	</main>
	<footer>
		<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>


</body>
</html>