package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.examples.GuestBookEntry;

/*A page to edit food item*/
@WebServlet("/admin/foods/edit/")
public class EditFoodAdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItemEntry> entries_food = (List<FoodItemEntry>) getServletContext().getAttribute("entries_food");
		FoodItemEntry leEntry = null;

		for (FoodItemEntry entries : entries_food) {
			if (entries.getId() == id) {
				leEntry = entries;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../../app.css\">");
		out.println("<title>Food Item Editing</title>");
		out.println("<h2>Editing Food Item</h2>");
		out.println("<form method=\"post\">");
		out.println("<label>Food Name:</label><br>");
		out.println("<input name='name' type='text' value='" + leEntry.getName() + "'/></br>");
		out.println("<label>Food Description:</label><br>");
		out.println(
				"<textarea name='description'rows=\"4\" cols=\"50\"'>" + leEntry.getDescription() + "</textarea></br>");
		out.println("<label>Food Picture URL:</label><br>");
		out.println("<input name='url' value='" + leEntry.getUrl() + "'/></br>");
		out.println("<label>Food Price:</label><br>");
		out.println("<input name='price' type='text' value='" + leEntry.getPrice() + "'/></br>");
		out.println("<button>Edit</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItemEntry> entries_food = (List<FoodItemEntry>) getServletContext().getAttribute("entries_food");
		FoodItemEntry leEntry = null;
		int index = -1;
		for (int i = 0; i < entries_food.size(); i++) {
			if (entries_food.get(i).getId() == id) {
				leEntry = entries_food.get(i);
				index = i;
			}
		}
		entries_food.set(index, new FoodItemEntry(leEntry.getId(), request.getParameter("name"),
				request.getParameter("description"), request.getParameter("url"), request.getParameter("price")

		));
		getServletContext().setAttribute("entries", entries_food);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../../app.css\">");
		out.println("<title>Food Item Editing</title>");
		out.println("<h2>Finish Editing !</h2>");
		out.println("<button onclick=\"location.href='../../foods'\">Go back to FoodMenu</button>");

	}
}
