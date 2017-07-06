package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*A page to edit food item including a link to create and delete*/

@WebServlet(loadOnStartup=1, urlPatterns={"/admin/foods"})
public class FoodItemListAdminServlet extends HttpServlet{
	public void init() {
		// init the application scope to have pre-set values
		List<FoodItemEntry> entries_food = new ArrayList<>();
		entries_food.add(new FoodItemEntry(entries_food.size(), "GrilledChicken", "Grilled Chiken, with spicy source ",
				"http://23209-presscdn.pagely.netdna-cdn.com/wp-content/uploads/2015/06/IMG_0319edit.jpg", "17.00"));
		entries_food.add(new FoodItemEntry(entries_food.size(), "Cram Chawder", "Hot Cram Chawder with bacon and cheese ",
				"http://assets.simplyrecipes.com/wp-content/uploads/2012/11/clam-chowder-b.jpg", "8.00"));
		entries_food.add(new FoodItemEntry(entries_food.size(), "Apple Pie", "American Taste, with Ice cream",
				"http://www.seriouseats.com/recipes/assets_c/2014/11/20141114-cheddar-ice-cream-vicky-wasik-1-thumb-1500xauto-415185.jpg", "10.50"));

		getServletContext().setAttribute("entries_food", entries_food);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FoodItemEntry> entries_food = (List<FoodItemEntry>) getServletContext().getAttribute("entries_food");
		// tell browser this is html document
		response.setContentType("text/html");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">");
		out.println("<title> Food Menu - Admin</title>");
		out.println("<h1> Food Menu - Admin</h1>");
		out.println("<table>");
		out.println("<thead>"
				+ "<tr>" +
					"<th>" + "Food ID" + "</th>" +
					"<th>" + "Food Name" + "</th>" +
					"<th>"+ "Food Description" + "</th>" +
					"<th>" + "Food Image" +"</th>" +
					"<th>" + "Food Price" + "</th>"+
					"<th>" + "Edit Button" + "</th>"+
					"<th>" + "Delete Button" + "</th>"+
					"</tr>" +
				"<thead>" );
		for (FoodItemEntry entry : entries_food) {

					out.println("<tbody>" +
									"<tr>" +
										"<td>" + entry.getId() + "</td>" +
										"<td>"+ entry.getName() + "</td>" +
										"<td>" + entry.getDescription()+ "</td>" +
										"<td><img src=" + "\""+entry.getUrl()+"\"" +" width=\"200\" height=\"100\"></td>" +
										"<td> $" + entry.getPrice() + "</td>" +
										"<td><a href='foods/edit/?id=" + entry.getId() + "'>Edit</a>" + "</td>"+
										"<td><a href='foods/delete?id=" + entry.getId() + "'>Delete</a>" +"</td>"+
									"</tr>" +
								"</tbody>");
		}
		out.println("</table>");
		out.println("<button onclick=\"location.href='foods/create'\">Add New Food</button>");
	}

}
