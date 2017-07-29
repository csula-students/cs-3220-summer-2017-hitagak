<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Import the JSTL --%>
<%@ taglib uri="admin-header-homework3.tld" prefix="myTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/homework3_app.css' />">
<title>Order Status - Admin</title>
</head>
<body class="admin">
	<header> <myTag:AdminHeader /> <nav>
	<ul>
		<li><a href="homework3_statuses">Customer's Order Status</a></li>
		<li><a href="homework3_foods">Food Menu</a></li>
		<li><a href="homework3_foods/new">Add New Food</a></li>
	</ul>
	</nav> </header>

	<main>


	<h2>Customer's Statuses - Admin</h2>

	<c:choose>
		<c:when test="${entries_order_homework3.size() == 0}">

			<table>
				<tbody>
					<tr>
						<td>
							<h3>
								There is no customer's order.<br>
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
						<th>Created</th>
						<th>Item</th>
						<th>Customer</th>
						<th>Status</th>
						<th>Change Status</th>
					</tr>
				<thead>

					<c:forEach items="${entries_order_homework3}"
						var="entries_order_homework3">
						<tbody>
							<tr>
								<td>${entries_order_homework3.date}</td>
								<td><img src=${entries_order_homework3.food.url }
									width="200" height="100"><br>${entries_order_homework3.food.name}</td>
								<td>${entries_order_homework3.name}</td>
								<td>${entries_order_homework3.status}</td>
								<td><form method="post">
										<select id="status" name="status">
											<option value="IN_QUEUE">In_QUEUE</option>
											<option value="IN_PROGRESS">IN_PROGRESS</option>
											<option value="COMPLETED">COMPLETED</option>
										</select>
										<button name="edit"
											value="${entries_order_homework3.food.name}">Update
											statuses</button>
									</form></td>
							</tr>
						</tbody>

					</c:forEach>
			</table>

		</c:otherwise>
	</c:choose> </main>
	<footer>
	<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>
</body>
</html>