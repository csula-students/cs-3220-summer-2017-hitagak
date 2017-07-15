package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*A page to delete food item*/

@WebServlet("/admin/foods/delete")
public class DeleteFoodAdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItemEntry> entries_food = (List<FoodItemEntry>) getServletContext().getAttribute("entries_food");
		int index = -1;
		for (int i = 0; i < entries_food.size(); i++) {
			if (entries_food.get(i).getId() == id) {
				index = i;
			}
		}
		entries_food.remove(index);
		getServletContext().setAttribute("entries_food", entries_food);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../app.css\">");
		out.println("<title>Finish Delete Item</title>");
		out.println("<h2>Success to Delete !</h2>");
		out.println("<button onclick=\"location.href='../foods'\">Go back to FoodMenu</button>");

	}

}
