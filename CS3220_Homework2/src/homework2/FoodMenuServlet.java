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

/* Show all food menu which guests can see. */

@WebServlet(loadOnStartup = 1, urlPatterns = { "/menu" })
public class FoodMenuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		List<FoodItemEntry> entries_food = (List<FoodItemEntry>) getServletContext().getAttribute("entries_food");

		response.setContentType("text/html");

		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">");
		out.println("<title> Food Menu </title>");
		out.println("</head>");

		out.println("<body>");

		out.println("<header>");

		out.println("<h1><img src=" + "\"" + "http://www.clker.com/cliparts/V/v/E/P/w/D/restaurant-hi.png" + "\""
				+ " width=\"100\" height=\"100\"> American's Food Restaurant </h1>");
		out.println("<nav>");
		out.println("<ul>");
		out.println("<li><a href=\"orders\">HomePage(Order Status)</a></li>");
		out.println("<li><a href=\"menu\">Menu</a></li>");
		out.println("<li><a href=\"shopping-cart\">Cart</a></li>");
		out.println("</ul>");
		out.println("</nav>");

		out.println("</header>");

		out.println("<main>");

		out.println("<h2> Food Menu </h2>");

		out.println("<table>");
		out.println("<thead>" + "<tr>" + "<th>" + "Food ID" + "</th>" + "<th>" + "Food Name" + "</th>" + "<th>"
				+ "Food Description" + "</th>" + "<th>" + "Food Image" + "</th>" + "<th>" + "Food Price" + "</th>"
				+ "<th>" + "Add In a Cart" + "</th>" + "</tr>" + "<thead>");

		for (FoodItemEntry entry : entries_food) {

			out.println("<tbody>" + "<tr>" + "<td>" + entry.getId() + "</td>" + "<td>" + entry.getName() + "</td>"
					+ "<td>" + entry.getDescription() + "</td>" + "<td><img src=" + "\"" + entry.getUrl() + "\""
					+ " width=\"200\" height=\"100\"></td>" + "<td> $" + entry.getPrice() + "</td>"
					+ "<td><a href='menu/add?id=" + entry.getId() + "'>Add In Cart</a>" + "</td>" + "</tr>"
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