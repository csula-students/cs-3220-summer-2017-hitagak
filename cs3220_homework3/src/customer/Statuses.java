package customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.FoodItemEntry;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/homework3_statuses" })
public class Statuses extends HttpServlet {
	public void init() {

		List<Order> entries_order_homework3 = new ArrayList<>();
		getServletContext().setAttribute("entries_order_homework3", entries_order_homework3);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> entries_order_homework3 = (List<Order>) getServletContext().getAttribute("entries_order_homework3");

		// send food menu data to index.jsp
		request.getRequestDispatcher("WEB-INF/customer/statuses.jsp").forward(request, response);
	}
}
