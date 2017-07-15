package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Delete Food From Cart */

@WebServlet("/shopping-cart/delete")
public class DeleteFoodInCart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItemEntry> entries_cart = (List<FoodItemEntry>) getServletContext().getAttribute("entries_cart");
		int index = -1;
		for (int i = 0; i < entries_cart.size(); i++) {
			if (entries_cart.get(i).getId() == id) {
				index = i;
			}
		}
		entries_cart.remove(index);
		getServletContext().setAttribute("entries_cart", entries_cart);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">");
		out.println("<title>Remove Item</title>");
		out.println("<h2>Your item is removed</h2>");
		out.println("<button onclick=\"location.href='../shopping-cart'\">Go back to Shopping Cart</button>");

	}

}