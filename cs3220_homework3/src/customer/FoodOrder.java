package customer;

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

import admin.FoodItemEntry;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/homework3_order" })
public class FoodOrder extends HttpServlet {

	public void init() {
		// create shopping cart list
		List<FoodItemEntry> entries_cart_homework3 = new ArrayList<>();
		getServletContext().setAttribute("entries_cart_homework3", entries_cart_homework3);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// delete items from menu
		List<FoodItemEntry> entries_cart_homework3 = (List<FoodItemEntry>) getServletContext()
				.getAttribute("entries_cart_homework3");
		String removefoodname = (request.getParameter("removefromcart"));

		int index = -1;
		for (int i = 0; i < entries_cart_homework3.size(); i++) {
			if (entries_cart_homework3.get(i).getName().equals(removefoodname)) {
				index = i;
				entries_cart_homework3.remove(index);
			}
		}

		getServletContext().setAttribute("entries_cart_homework3", entries_cart_homework3);

		request.getRequestDispatcher("WEB-INF/customer/order.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// confirm order
		List<Order> entries_order_homework3 = (List<Order>) getServletContext().getAttribute("entries_order_homework3");
		List<FoodItemEntry> entries_cart_homework3 = (List<FoodItemEntry>) getServletContext()
				.getAttribute("entries_cart_homework3");

		for (FoodItemEntry entry : entries_cart_homework3) {
			DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String name = request.getParameter("customer_name");
			entries_order_homework3
					.add(new Order(entries_order_homework3.size(), entry, name, "IN_QUEUE", dtf.format(date)));
			getServletContext().setAttribute("entries_order_homework3", entries_order_homework3);

		}

		entries_cart_homework3.clear();
		request.getRequestDispatcher("WEB-INF/customer/statuses.jsp").forward(request, response);

	}
}
