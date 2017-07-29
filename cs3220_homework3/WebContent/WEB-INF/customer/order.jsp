<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Import the JSTL --%>
<%@ taglib uri="customer-header-homework3.tld" prefix="myTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/homework3_app.css' />">
<title>Order</title>
</head>
<body>
	<header> <myTag:CustomerHeader /> <nav>
	<ul>
		<li><a href="homework3_index">Menu</a></li>
		<li><a href="homework3_order">Order</a></li>
		<li><a href="homework3_statuses">Statuses</a></li>
	</ul>
	</nav> </header>

	<main>


	<h2>Order</h2>

	<c:choose>
		<c:when test="${entries_cart_homework3.size() == 0}">

			<table>
				<tbody>
					<tr>
						<td>
							<h3>There is no orders</h3>
							<h3>
								You can check our special foods from <a href="homework3_index">Menu</a>.
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
						<th>Item</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach items="${entries_cart_homework3}"
					var="entries_cart_homework3">
					<tbody>
						<tr>
							<td><img src=${entries_cart_homework3.url } width="200"
								height="100"><br>${entries_cart_homework3.name}</td>
							<td>$ ${entries_cart_homework3.price}</td>
							<td></td>
							<td><form method="get">
									<button name="removefromcart"
										value="${entries_cart_homework3.getName()}">Remove</button>
								</form></td>

						</tr>
					</tbody>

				</c:forEach>
			</table>
			<h3>Type Your Name</h3>

			<form method="post">
				<label>Your Name:</label><br> <input name='customer_name'
					type='text' /></br> <br>
				<button>Place Your order</button>
			</form>
		</c:otherwise>
	</c:choose> </main>
	<footer>
	<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>
</body>
</html>