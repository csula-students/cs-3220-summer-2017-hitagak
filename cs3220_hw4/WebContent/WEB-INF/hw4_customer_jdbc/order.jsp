<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%-- Import the JSTL --%>
<%@ taglib uri="customer-header-hw4.tld" prefix="myTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/hw4_app.css' />">
<title>Order</title>
</head>
<body>

	<header>
			<myTag:CustomerHeader_hw4/>
		<nav>
			<ul>
			<li><a href="hw4_index">Menu</a></li>
		    <li><a href="hw4_order">Order</a></li>
		    <li><a href="hw4_status">Statuses</a></li>
			</ul>
		</nav>
	</header>

	<main>


	<h2>Order</h2>
	<c:choose>
		<c:when test="${list_cart.size() == 0}">

			<table>
				<tbody>
					<tr>
						<td>
							<h3>There is no orders</h3>
							<h3>
								You can check our special foods from <a href="hw4_index">Menu</a>.
							</h3>
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
				<th>Delete</th>
			</tr>
		</thead>

		<c:forEach items="${list_cart}" var="entry">
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
	<form method="post">
			<label>Your Name:</label><br><input name='customer_name' type='text' /><br><br>
			<button>Place Your order</button>
	</form>
	</c:otherwise>
	</c:choose>
	</main>
	<footer>
		<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>


</body>
</html>