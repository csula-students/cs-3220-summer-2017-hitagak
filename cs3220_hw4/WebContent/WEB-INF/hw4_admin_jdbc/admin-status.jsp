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
<title>Order Status -Admin</title>
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


	<h2>Order Status -Admin</h2>
	<c:choose>
		<c:when test="${list_order.size() == 0}">

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
		</thead>
		<c:forEach items="${list_order}" var="entry">
			<tr>
				<td>${entry.date}</td>
				<td><img src=${entry.food_url } width="200" height="100"><br>
					${entry.food_name}</td>
				<td>${entry.customer}</td>
				<td>${entry.status}</td>
				<td><form method="post">
					<select id="status" name="status">
					<option value="IN_QUEUE">In_QUEUE</option>
					<option value="IN_PROGRESS">IN_PROGRESS</option>
					<option value="COMPLETED">COMPLETED</option>
					</select>
					<button name="edit"
					value="${entry.id}">Update
					statuses</button>
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
	</c:otherwise>
	</c:choose>

	
	</main>
	<footer>
		<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>


</body>
</html>