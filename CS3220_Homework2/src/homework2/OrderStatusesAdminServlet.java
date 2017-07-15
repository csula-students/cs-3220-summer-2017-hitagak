package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Admin can see customer's order status */

@WebServlet(loadOnStartup = 1, urlPatterns = { "/admin/orders" })
public class OrderStatusesAdminServlet extends HttpServlet {
	public void init() {

		List<Order> entries_order = new ArrayList<>();
		getServletContext().setAttribute("entries_order", entries_order);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FoodItemEntry> entries_cart = (List<FoodItemEntry>) getServletContext().getAttribute("entries_cart");
		// tell browser this is html document
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">");
		out.println("<title> Order Status -Admin </title>");
		out.println("</head>");

		out.println("<body>");

		out.println("<header>");

		out.println("<h1><img src=" + "\"" + "http://www.clker.com/cliparts/V/v/E/P/w/D/restaurant-hi.png" + "\""
				+ " width=\"100\" height=\"100\"> American's Food Restaurant - Admin Site</h1>");
		out.println("<nav>");
		out.println("<ul>");
		out.println("<li><a href=\"orders\">Customer's Order Status</a></li>");
		out.println("<li><a href=\"foods\">Food Menu</a></li>");
		out.println("</ul>");
		out.println("</nav>");

		out.println("</header>");

		out.println("<main>");

		out.println("<h2> Customer's Order Statuses </h2>");

		List<Order> entries_order = (List<Order>) getServletContext().getAttribute("entries_order");

		if (entries_order.size() == 0) {
			out.println("<table>" + "<tbody>" + "<tr>" + "<td>");

			out.println("<h3>There is no order from customers.</h3>");

			out.println("</td>" + "</tr>" + "<tbody>" + "</table>");

		} else {
			out.println("<table>");
			out.println("<thead>" + "<tr>" + "<th>" + "Order ID" + "</th>" + "<th>" + "Food Name" + "</th>" + "<th>"
					+ "Food Image" + "</th>" + "<th>" + "Customer Name" + "</th>" + "<th>" + "Order Status" + "</th>"
					+ "<th>" + " Order Date " + "</th>" + "<th>" + "Edit Order" + "</th>" + "</tr>" + "<thead>");

			for (Order order : entries_order)

				out.println("<tbody>" + "<tr>" + "<td>" + order.getId() + "</td>" + "<td>" + order.getFood().getName()
						+ "</td>" + "<td><img src=" + "\"" + order.getFood().getUrl() + "\""
						+ " width=\"200\" height=\"100\"></td>" + "<td>" + order.getName() + "</td>" + "<td>"
						+ order.getStatus().toString() + "</td>" + "<td>" + order.getDate() + "</td>"
						+ "<td><a href='../admin/order/?id=" + order.getId() + "'>Edit</a>" + "</td>" + "</tr>"
						+ "</tbody>");

		}

		out.println("</table>");

		out.println("</main>");

		out.println("<footer>");
		out.println("<p>@2017 American's Food Restaurant Inc. All Rights Reserved</p>");
		out.println("</footer>");

		out.println("</body>");
	}

}
