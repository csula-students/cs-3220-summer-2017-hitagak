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

/*Add Food In a cart. */

@WebServlet("/menu/add")
public class AddFoodInCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItemEntry> entries_food = (List<FoodItemEntry>) getServletContext().getAttribute("entries_food");

		FoodItemEntry addEntry = null;

		for (FoodItemEntry entries : entries_food) {
			if (entries.getId() == id) {
				addEntry = entries;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<FoodItemEntry> entries_cart = (List<FoodItemEntry>) getServletContext().getAttribute("entries_cart");

		entries_cart.add(new FoodItemEntry(id, addEntry.getName(), addEntry.getDescription(), addEntry.getUrl(),
				addEntry.getPrice()

		));

		getServletContext().setAttribute("entries_cart", entries_cart);

		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">");
		out.println("<title>Shopping Cart </title>");
		out.println("<h2>You put " + addEntry.getName() + " in your cart.</h2>");
		out.println("<button onclick=\"location.href='../menu'\">Go back to FoodMenu</button>");
		out.println("<button onclick=\"location.href='../shopping-cart'\">See a Shopping Cart </button>");

	}

}
