package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.Order;

@WebServlet("/homework3_admin/homework3_statuses")
public class Admin_Order_Status extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Order> entries_order_homework3 = (List<Order>) getServletContext().getAttribute("entries_order_homework3");

		request.getRequestDispatcher("../WEB-INF/admin/admin-order-status.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// edit order status (IN_QUEUE, IN_PROGRESS, COMPLETED)
		List<Order> entries_order_homework3 = (List<Order>) getServletContext().getAttribute("entries_order_homework3");
		String editfoodname = (request.getParameter("edit"));

		Order leEntry = null;
		int index = -1;
		for (int i = 0; i < entries_order_homework3.size(); i++) {
			if (entries_order_homework3.get(i).getFood().getName().equals(editfoodname)) {
				leEntry = entries_order_homework3.get(i);
				index = i;
			}
		}
		
		leEntry.setStatus(request.getParameter("status").toString());
		
		entries_order_homework3.set(index, new Order(leEntry.getId(), leEntry.getFood(), leEntry.getName(),
				leEntry.getStatus(), leEntry.getDate()));

		getServletContext().setAttribute("entries_order_homework3", entries_order_homework3);

		request.getRequestDispatcher("../WEB-INF/admin/admin-order-status.jsp").forward(request, response);
	}
}
