package admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/homework3_admin/homework3_foods/new")
public class CreateFood extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// create food form
		request.getRequestDispatcher("../../WEB-INF/admin/create-food.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// add new food
		List<FoodItemEntry> entries_food_homework3 = (List<FoodItemEntry>) getServletContext()
				.getAttribute("entries_food_homework3");

		DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		String name = request.getParameter("name");
		String url = request.getParameter("url");
		Double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");

		entries_food_homework3
				.add(new FoodItemEntry(entries_food_homework3.size(), name, description, url, price, dtf.format(date)));

		request.setAttribute("entries_food_homework3", entries_food_homework3);

		response.sendRedirect(request.getContextPath() + "/homework3_admin/homework3_foods");

	}

}