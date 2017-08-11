package hw4_admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hw4_admin/hw4_foods")
public class Inventory_Food extends HttpServlet {

	// show foodMenu
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FoodItemDAO dao = new FoodItemDAO();

		if (request.getParameter("Delete") != null) {
			int id = Integer.parseInt(request.getParameter("Delete"));
			dao.delete(id);
		}

		request.setAttribute("list", dao.list());

		request.getRequestDispatcher("/WEB-INF/hw4_admin_jdbc/fooditem.jsp").forward(request, response);
	}
}
