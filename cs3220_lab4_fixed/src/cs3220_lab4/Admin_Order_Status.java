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

@WebServlet("/lab4_admin/lab4_statuses")
public class Admin_Order_Status extends HttpServlet {

	public void init() {

		/**
		 * This data is example order statuses.
		 */

		List<Order> entries_order_lab4 = new ArrayList<>();
		DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		entries_order_lab4.add(new Order(entries_order_lab4.size(), "GrilledChicken",
				"http://23209-presscdn.pagely.netdna-cdn.com/wp-content/uploads/2015/06/IMG_0319edit.jpg", "Hiroko",
				"IN_QUEUE", dtf.format(date)));
		entries_order_lab4.add(new Order(entries_order_lab4.size(), "Cram Chawder",
				"http://assets.simplyrecipes.com/wp-content/uploads/2012/11/clam-chowder-b.jpg", "Hiroko", "IN_QUEUE",
				dtf.format(date)));
		entries_order_lab4.add(new Order(entries_order_lab4.size(), "Apple Pie",
				"http://www.seriouseats.com/recipes/assets_c/2014/11/20141114-cheddar-ice-cream-vicky-wasik-1-thumb-1500xauto-415185.jpg",
				"Hiroko", "IN_QUEUE", dtf.format(date)));
		getServletContext().setAttribute("entries_order_lab4", entries_order_lab4);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("../WEB-INF/admin-order-status.jsp").forward(request, response);
	}
}
