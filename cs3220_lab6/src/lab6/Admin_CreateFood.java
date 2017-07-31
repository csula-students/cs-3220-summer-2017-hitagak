package lab6;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lab6_admin/lab6_foods/new")
public class Admin_CreateFood extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FoodItemDAO dao = new FoodItemDAO();
		request.setAttribute("list", dao.list());

		request.getRequestDispatcher("/WEB-INF/lab6_jdbc/createfood.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		FoodItemDAO dao = new FoodItemDAO();
		int id = dao.list().size();
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		dao.add(new FoodItemEntry(id, name, description, url, price, dtf.format(date)));

		response.sendRedirect(request.getContextPath() + "/lab6_admin/lab6_foods");
	}
}
