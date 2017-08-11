package hw4_customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw4_admin.FoodItemDAO;
import hw4_admin.FoodItemEntry;

@WebServlet("/hw4_index")
public class FoodMenu extends HttpServlet {

	// Show menu and add Item in cart
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FoodItemDAO dao = new FoodItemDAO();
		RestaurantCartDAO dao_cart = new RestaurantCartDAO();

		if (request.getParameter("Add") != null) {
			int addfoodID = Integer.parseInt(request.getParameter("Add"));

			FoodItemEntry addFood = dao.get(addfoodID).get();
			dao_cart.add(new FoodItemEntry(addFood.getId(), addFood.getName(), addFood.getDescription(),
					addFood.getUrl(), addFood.getPrice(), addFood.getDate()));
		}

		request.setAttribute("list", dao.list());
		request.setAttribute("list_cart", dao_cart.list());

		request.getRequestDispatcher("/WEB-INF/hw4_customer_jdbc/index.jsp").forward(request, response);
	}
}
