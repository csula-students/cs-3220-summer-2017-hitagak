<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Import the JSTL --%>
<%@ taglib uri="admin-header.tld" prefix="myTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/admin_app.css' />">
<title>Food Menu -Admin</title>
</head>
<body class="admin">
	<header> <myTag:AdminHeader /> <nav>
	<ul>
		<li><a href="lab4_statuses">Customer's Order Status</a></li>
		<li><a href="lab4_foods">Food Menu</a></li>
		<li><a href="lab4_foods/new">Add New Food</a></li>
	</ul>
	</nav> </header>

	<main>


	<h2>Food Menu - Admin</h2>

	<c:choose>
		<c:when test="${entries_food_lab4.size() == 0}">

			<table>
				<tbody>
					<tr>
						<td>
							<h3>Food menu is Empty.</h3>
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
						<th>Created</th>
						<th>Item</th>
						<th>Action</th>
					</tr>
				<thead>
					<c:forEach items="${entries_food_lab4}" var="entries_food_lab4">
						<tbody>
							<tr>
								<td>${entries_food_lab4.id}</td>
								<td>${entries_food_lab4.date}</td>
								<td><img src=${entries_food_lab4.url } width="200"
									height="100"><br>${entries_food_lab4.name}<br>$
									${entries_food_lab4.price}</td>
								<td><form method="get">
										<button name="Submit" value="${entries_food_lab4.getName()}">Delete</button>
									</form></td>

							</tr>
						</tbody>

					</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

	<button onclick="location.href='lab4_foods/new'">Add New Food</button>
	</main>
	<footer>
	<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>
</body>
</html>