package cs3220_lab4;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** show food menu */
@WebServlet("/lab4_admin/lab4_foods")
public class Admin_Inventory_Food extends HttpServlet {

	public void init() {

		// add food menu
		List<FoodItemEntry> entries_food_lab4 = new ArrayList<>();
		DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		entries_food_lab4
				.add(new FoodItemEntry(entries_food_lab4.size(), "GrilledChicken", "Grilled Chiken, with spicy source ",
						"http://23209-presscdn.pagely.netdna-cdn.com/wp-content/uploads/2015/06/IMG_0319edit.jpg",
						17.00, dtf.format(date)));
		entries_food_lab4.add(
				new FoodItemEntry(entries_food_lab4.size(), "Cram Chawder", "Hot Cram Chawder with bacon and cheese ",
						"http://assets.simplyrecipes.com/wp-content/uploads/2012/11/clam-chowder-b.jpg", 8.00,
						dtf.format(date)));
		entries_food_lab4.add(new FoodItemEntry(entries_food_lab4.size(), "Apple Pie", "American Taste, with Ice cream",
				"http://www.seriouseats.com/recipes/assets_c/2014/11/20141114-cheddar-ice-cream-vicky-wasik-1-thumb-1500xauto-415185.jpg",
				10.50, dtf.format(date)));
		getServletContext().setAttribute("entries_food_lab4", entries_food_lab4);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// delete items from menu
		List<FoodItemEntry> entries_food_lab4 = (List<FoodItemEntry>) getServletContext()
				.getAttribute("entries_food_lab4");
		String deletefoodname = (request.getParameter("Submit"));

		int index = -1;
		for (int i = 0; i < entries_food_lab4.size(); i++) {
			if (entries_food_lab4.get(i).getName().equals(deletefoodname)) {
				index = i;
				entries_food_lab4.remove(index);
			}
		}

		getServletContext().setAttribute("entries_food_lab4", entries_food_lab4);

		// send food menu data to inventory.jsp
		request.getRequestDispatcher("../WEB-INF/admin-inventory.jsp").forward(request, response);
	}
}
