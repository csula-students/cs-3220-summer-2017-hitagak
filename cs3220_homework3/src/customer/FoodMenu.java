package customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.FoodItemEntry;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/homework3_index" })
public class FoodMenu extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FoodItemEntry> entries_food_homework3 = (List<FoodItemEntry>) getServletContext()
				.getAttribute("entries_food_homework3");

		// add food in cart
		List<FoodItemEntry> entries_cart_homework3 = (List<FoodItemEntry>) getServletContext()
				.getAttribute("entries_cart_homework3");

		String addfoodname = (request.getParameter("AddInCart"));

		FoodItemEntry addEntry = null;

		for (FoodItemEntry entries : entries_food_homework3) {
			if (entries.getName().equals(addfoodname)) {
				addEntry = entries;
				entries_cart_homework3.add(new FoodItemEntry(addEntry.getId(), addEntry.getName(),
						addEntry.getDescription(), addEntry.getUrl(), addEntry.getPrice(), addEntry.getDate()));
			}
		}

		getServletContext().setAttribute("entries_cart_homework3", entries_cart_homework3);

		request.getRequestDispatcher("WEB-INF/customer/index.jsp").forward(request, response);
	}

}
