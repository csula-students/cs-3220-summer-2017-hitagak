package hw4_customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hw4_status")
public class Status extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO dao_order = new OrderDAO();

		request.setAttribute("list_order", dao_order.list());
		request.getRequestDispatcher("/WEB-INF/hw4_customer_jdbc/status.jsp").forward(request, response);
	}
}
