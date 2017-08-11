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

@WebServlet("/hw4_admin/hw4_foods/edit")
public class EditFood extends HttpServlet {

	// show foodMenu
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FoodItemDAO dao = new FoodItemDAO();

		int id = Integer.parseInt(request.getParameter("id"));

		FoodItemEntry edit_item = dao.get(id).get();

		request.setAttribute("edit_item", edit_item);

		request.getRequestDispatcher("/WEB-INF/hw4_admin_jdbc/edit-food.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date date = new Date();
		java.sql.Date date_sql = new java.sql.Date(date.getTime());

		FoodItemDAO dao = new FoodItemDAO();

		FoodItemEntry updated = new FoodItemEntry(Integer.parseInt(request.getParameter("id")),
				request.getParameter("name"), request.getParameter("description"), request.getParameter("url"),
				Double.parseDouble(request.getParameter("price")), date_sql);
		dao.update(updated);

		response.sendRedirect(request.getContextPath() + "/hw4_admin/hw4_foods");

	}

}