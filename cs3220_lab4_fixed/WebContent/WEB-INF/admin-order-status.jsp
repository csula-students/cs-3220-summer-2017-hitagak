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
<title>Order Status - Admin</title>
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

	<h2>Order Status - Admin</h2>

	<table>
		<thead>
			<tr>
				<th>Food ID</th>
				<th>Created</th>
				<th>Item</th>
				<th>Customer</th>
				<th>Status</th>
			</tr>
		</thead>
		<c:forEach items="${entries_order_lab4}" var="entries_order_lab4">
			<tbody>
				<tr>
					<td>${entries_order_lab4.id}</td>
					<td>${entries_order_lab4.date}</td>
					<td><img src=${entries_order_lab4.foodimage } width="200"
						height="100"><br>${entries_order_lab4.foodname}</td>
					<td>${entries_order_lab4.customername}</td>
					<td><form name="status" method="get" action="#">
							<select>
								<option>In_QUEUE</option>
								<option>IN_PROGRESS</option>
								<option>COMPLETED</option>

							</select>
						</form></td>

				</tr>
			</tbody>

		</c:forEach>

	</table>
	<button>Update statuses</button>
	</main>
	<footer>
	<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>
</body>
</html>