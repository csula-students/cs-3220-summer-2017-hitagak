package hw4_customer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw4_admin.FoodItemEntry;

@WebServlet("/hw4_order")
public class FoodOrder extends HttpServlet {

	// Show Shoppinng Cart and confirm order
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestaurantCartDAO dao_cart = new RestaurantCartDAO();
		OrderDAO dao_order = new OrderDAO();

		if (request.getParameter("Delete") != null) {
			int id = Integer.parseInt(request.getParameter("Delete"));
			dao_cart.delete(id);
		}

		request.setAttribute("list_cart", dao_cart.list());
		request.setAttribute("list_order", dao_order.list());
		request.getRequestDispatcher("/WEB-INF/hw4_customer_jdbc/order.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestaurantCartDAO dao_cart = new RestaurantCartDAO();
		OrderDAO dao_order = new OrderDAO();

		for (FoodItemEntry entry : dao_cart.list()) {

			Date date = new Date();
			java.sql.Date date_sql = new java.sql.Date(date.getTime());
			String name = request.getParameter("customer_name");
			dao_order.add(new Order(entry.getId(), entry.getName(), entry.getUrl(), entry.getPrice(), name, "IN_QUEUE",
					date_sql));

		}

		dao_cart.clear();
		request.setAttribute("list_order", dao_order.list());
		response.sendRedirect(request.getContextPath() + "/hw4_status");
	}
}
