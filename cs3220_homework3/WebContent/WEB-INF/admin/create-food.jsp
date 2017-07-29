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
<title>Add New Food</title>
</head>
<body class="admin">
	<header> <myTag:AdminHeader /> <nav>
	<ul>
		<li><a href="../homework3_statuses">Customer's Order Status</a></li>
		<li><a href="../homework3_foods">Food Menu</a></li>
		<li><a href="new">Add New Food</a></li>
	</ul>
	</nav> </header>

	<main>
	<h2>Add new food</h2>
	<form method="post">
		<label>Food Name: </label><br> <input name="name" id="name"
			type="text"><br> <br> <label>Image link: </label><br>
		<input name="url" id="url" type="text"><br> <br> <label>Description:
		</label><br>
		<textarea name='description' rows=4 cols=50 id="description"></textarea>
		<br> <br> <label>Price:</label><br> <input name="price"
			id="price" type="text"><br> <br>
		<button name="Submit" value="Submit">Add Food</button>
	</form>
	</main>
	<footer>
	<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>
	</footer>
</body>
</html>