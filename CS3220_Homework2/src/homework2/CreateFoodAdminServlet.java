package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*A page to create an information of a food item*/

@WebServlet("/admin/foods/create")
public class CreateFoodAdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../app.css\">");
		out.println("<title> Create Food Item </title>");
		out.println("<h2> Create Food Item Form</h2><br>");

		out.println("<form method=\"post\">");
		out.println("<label>Food Name:</label><br>");
		out.println("<input name='name' type='text'/></br><br>");
		out.println("<label>Food Description:</label><br>");
		out.println("<textarea name='description' rows=\"4\" cols=\"50\"></textarea></br><br>");
		out.println("<label>Food Picture URL:</label><br>");
		out.println("<input name='url' type='text'/></br><br>");
		out.println("<label>Food Price:</label><br>");
		out.println("<input name='price' type='text'/></br><br><br>");
		out.println("<button>Add in Food List</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FoodItemEntry> entries_food = (List<FoodItemEntry>) getServletContext().getAttribute("entries_food");

		entries_food.add(new FoodItemEntry(entries_food.size(), request.getParameter("name"),
				request.getParameter("description"), request.getParameter("url"), request.getParameter("price")));
		getServletContext().setAttribute("entries_food", entries_food);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../app.css\">");
		out.println("<title> Create Food Item </title>");
		out.println("<h2>Added new Food Item in the list !</h2>");
		out.println("<button onclick=\"location.href='../foods'\">Go back to FoodMenu</button>");

	}

}
