package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(loadOnStartup = 1, urlPatterns = { "/suggest/restaurants/random/list" })
public class RandomRestaurantListServlet extends HttpServlet{
	/** Initialize the chart */
	public void init() {

		List<RestaurantList> entries_rest = new ArrayList<>();
		entries_rest.add(new RestaurantList("Student1",
				"http://cs3.calstatela.edu:8080/cs3220xstu01/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student2",
				"http://cs3.calstatela.edu:8080/cs3220xstu02/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student3",
				"http://cs3.calstatela.edu:8080/cs3220xstu03/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student4",
				"http://cs3.calstatela.edu:8080/cs3220xstu04/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student5",
				"http://cs3.calstatela.edu:8080/cs3220xstu05/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student6",
				"http://cs3.calstatela.edu:8080/cs3220xstu06/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student7",
				"http://cs3.calstatela.edu:8080/cs3220xstu07/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student8",
				"http://cs3.calstatela.edu:8080/cs3220xstu08/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student9",
				"http://cs3.calstatela.edu:8080/cs3220xstu09/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student10",
				"http://cs3.calstatela.edu:8080/cs3220xstu10/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student11",
				"http://cs3.calstatela.edu:8080/cs3220xstu11/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student12",
				"http://cs3.calstatela.edu:8080/cs3220xstu12/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student13",
				"http://cs3.calstatela.edu:8080/cs3220xstu13/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student14",
				"http://cs3.calstatela.edu:8080/cs3220xstu14/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student15",
				"http://cs3.calstatela.edu:8080/cs3220xstu15/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student16",
				"http://cs3.calstatela.edu:8080/cs3220xstu16/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student17",
				"http://cs3.calstatela.edu:8080/cs3220xstu17/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student18",
				"http://cs3.calstatela.edu:8080/cs3220xstu18/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student19",
				"http://cs3.calstatela.edu:8080/cs3220xstu19/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student20",
				"http://cs3.calstatela.edu:8080/cs3220xstu20/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student21",
				"http://cs3.calstatela.edu:8080/cs3220xstu21/menu", 0.0, 0.0,0));
		entries_rest.add(new RestaurantList("Student22",
				"http://cs3.calstatela.edu:8080/cs3220xstu22/menu", 0.0, 0.0,0));
		

		getServletContext().setAttribute("entries_rest", entries_rest);

	}

	/** Display form */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<RestaurantList> entries_rest = (List<RestaurantList>) getServletContext().getAttribute("entries_rest");

		/** Add head and set information */
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../../app.css\">");
		out.println("<title> Lunch Recommendation </title>");
		out.println("</head>");
		
		/**Add body. Body includes header, main and footer*/
		out.println("<body>");
			out.println("<header>");
				out.println("<h2> What's for lunch ? </h2><br>");
			out.println("</header>");
			out.println("<main>");
			
			out.println("<table>");
			out.println("<thead>"
					+ "<tr>" +
						"<th>" + "Name" + "</th>" +
						"<th>" + "URL" +"</th>" +
						"<th>" + "Design" + "</th>"+
						"<th>" + "Taste" + "</th>"+
						"<th>" + "Reviewers" + "</th>"+
						"</tr>" +
					"<thead>" );
			double total=0;
			double num1total=0;
			double num2total=0;
			for (RestaurantList entry : entries_rest) {
						
						out.println("<tbody>" +
										"<tr>" +
											
											"<td>"+ entry.getName() + "</td>" +
											"<td>"+ entry.getUrl() + "</td>" +
											"<td>" + entry.getDesign() + "</td>" +
											"<td>" + entry.getTaste() + "</td>" +
											"<td>" + entry.getReviewers()+ "</td>" +
										"</tr>" +
									"</tbody>");
						
			}
			out.println("</table>");
			
			// be careful when add url
			out.println("<button onclick=\"location.href='../random'\">Feeling lucky</button>");
			out.println("<button onclick=\"location.href='list'\">See the list</button>");
			
			
			out.println("</main>");
			
			out.println("<footer>");
				out.println("<p>@2017 CS3220 Midterm</p>");
			out.println("</footer>");
			
		out.println("</body>");
	}
}
