package lab6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lab6_admin/lab6_foods")
public class Admin_Inventory_Food extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FoodItemDAO dao = new FoodItemDAO();

		if (request.getParameter("Delete") != null) {
			int id = Integer.parseInt(request.getParameter("Delete"));
			dao.delete(id);
		}

		request.setAttribute("list", dao.list());

		request.getRequestDispatcher("/WEB-INF/lab6_jdbc/fooditem.jsp").forward(request, response);
	}
}