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
<title>FoodMenu -Admin</title>
</head>
<body class="admin">

	<header>
			<myTag:AdminHeader_hw4/>
		<nav>
			<ul>
			<li><a href="hw4_status">Customer's Order Status</a></li>
			<li><a href="hw4_foods">Food Menu</a></li>
			<li><a href="hw4_foods/new">Add New Food</a></li>
			</ul>
		</nav>
	</header>

	<main>


	<h2>Food Menu - Admin</h2>
	<c:choose>
		<c:when test="${list.size() == 0}">

			<table>
				<tbody>
					<tr>
						<td>
							<h3>There is no FoodMenu</h3>
						</td>
					</tr>
				</tbody>
			</table>
		</c:when>
	<c:otherwise>

	<table>
		<thead>
			<tr>
				<th>Food ID</th>
				<th>Food Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Edit</th>
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
						<a href="<c:url value='/hw4_admin/hw4_foods/edit?id=${entry.id}'/>">Edit</a>
					</form>
				</td>
				<td><form method="get">
						<button name="Delete" value="${entry.id}">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
	</c:otherwise>
	</c:choose>
	<br>
	<button onclick="location.href='hw4_foods/new'">Add New Food</button>
	</main>
	<footer>
		<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>


</body>
</html>