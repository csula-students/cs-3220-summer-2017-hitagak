package lab3;

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
		// tell browser this is html document
		response.setContentType("text/html");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">");
		out.println("<title> Food Menu </title>");
		out.println("<h1> Food Menu </h1>");
		out.println("<table>");
		out.println("<thead>"
				+ "<tr>" +
					"<th>" + "Food ID" + "</th>" +
					"<th>" + "Food Name" + "</th>" +
					"<th>"+ "Food Description" + "</th>" +
					"<th>" + "Food Image" +"</th>" +
					"<th>" + "Food Price" + "</th>"
				+ "</tr>" +
				"<thead>" );
		for (FoodItemEntry entry : entries_food) {

					out.println("<tbody>" +
									"<tr>" +
									"<td>" + entry.getId() + "</td>" +
									"<td>"+ entry.getName() + "</td>" +
									"<td>" + entry.getDescription()+ "</td>" +
									"<td><img src=" + "\""+entry.getUrl()+"\"" +" width=\"200\" height=\"100\"></td>" +
									"<td> $" + entry.getPrice() + "</td>" +
									"</tr>" +
								"</tbody>");
		}
		out.println("</table>");

	}
}
