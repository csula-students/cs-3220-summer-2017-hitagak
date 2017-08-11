package hw4_admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hw4_admin/hw4_foods/new")
public class CreateFood extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FoodItemDAO dao = new FoodItemDAO();
		request.setAttribute("list", dao.list());

		request.getRequestDispatcher("/WEB-INF/hw4_admin_jdbc/create-food.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date date = new Date();
		java.sql.Date date_sql = new java.sql.Date(date.getTime());

		FoodItemDAO dao = new FoodItemDAO();
		int id = dao.list().size();
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		dao.add(new FoodItemEntry(id, name, description, url, price, date_sql));

		response.sendRedirect(request.getContextPath() + "/hw4_admin/hw4_foods");
	}
}
