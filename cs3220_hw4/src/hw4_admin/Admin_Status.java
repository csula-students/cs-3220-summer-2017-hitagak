package hw4_admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw4_customer.Order;
import hw4_customer.OrderDAO;

/** Show Status and Edit Status */

@WebServlet("/hw4_admin/hw4_status")
public class Admin_Status extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OrderDAO dao_order = new OrderDAO();

		request.setAttribute("list_order", dao_order.list());
		request.getRequestDispatcher("/WEB-INF/hw4_admin_jdbc/admin-status.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date date = new Date();
		java.sql.Date date_sql = new java.sql.Date(date.getTime());
		
		OrderDAO dao_order = new OrderDAO();
		int id = Integer.parseInt(request.getParameter("edit"));

		Order edit_item = dao_order.get(id).get();
		String updateStatus = request.getParameter("status");

		Order updated = new Order(id, edit_item.getFood_name(), edit_item.getFood_url(), edit_item.getFood_price(),
				edit_item.getCustomer(), updateStatus, date_sql);
		edit_item.setStatus(updateStatus);

		dao_order.update(updated);
		request.setAttribute("list_order", dao_order.list());
		request.getRequestDispatcher("/WEB-INF/hw4_admin_jdbc/admin-status.jsp").forward(request, response);
	}

}
