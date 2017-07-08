package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/suggest/restaurants/random")
public class RandomRestaurantServlet extends HttpServlet {
	// display form
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// set html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/** Add head and set information */
		
		List<RestaurantList> entries_rest = (List<RestaurantList>) getServletContext().getAttribute("entries_rest");
		
		
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../app.css\">");
		out.println("<title> Lunch Recommendation </title>");
		out.println("</head>");

		/** Add body. Body includes header, main and footer */
		out.println("<body>");
		out.println("<header>");
		out.println("<h2> What's for lunch ?</h2><br>");
		out.println("</header>");
		out.println("<main>");
		
		out.println("<label>You should go to: </label><br>");
		RestaurantList rnd=getRandomRestaurant(entries_rest);
		
		out.println("<a href='"+rnd.getUrl()+"'>"+rnd.getName()+"</a><br><br>");
		
		out.println("<label>Design</label>");
		out.println("<form method=\"post\">");
		out.println("<input name=\"designRate\" id=\"design_rate_1\" type=\"radio\" value=\"1\" checked></label>");
		out.println("<label for=\"design_rate_1\">1</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_2\" type=\"radio\" value=\"2\">");
		out.println("<label for=\"design_rate_2\">2</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_3\" type=\"radio\" value=\"3\">");
		out.println("<label for=\"design_rate_3\">3</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_4\" type=\"radio\" value=\"4\">");
		out.println("<label for=\"design_rate_4\">4</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_5\" type=\"radio\" value=\"5\">");
		out.println("<label for=\"design_rate_5\">5</label>");
		out.println("</form>");
		
		out.println("<label>Food Taste</label>");
		out.println("<form method=\"post\">");
		out.println("<input name=\"designRate\" id=\"design_rate_1\" type=\"radio\" value=\"1\" checked></label>");
		out.println("<label for=\"design_rate_1\">1</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_2\" type=\"radio\" value=\"2\">");
		out.println("<label for=\"design_rate_2\">2</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_3\" type=\"radio\" value=\"3\">");
		out.println("<label for=\"design_rate_3\">3</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_4\" type=\"radio\" value=\"4\">");
		out.println("<label for=\"design_rate_4\">4</label><br>");
		out.println("<input name=\"designRate\" id=\"design_rate_5\" type=\"radio\" value=\"5\">");
		out.println("<label for=\"design_rate_5\">5</label>");
		out.println("</form>");
		

		out.println("<button>Feeling lucky</button>");
		out.println("<button onclick=\"location.href='random/list'\">See the list</button>");

		out.println("</main>");
		out.println("<footer>");
		out.println("<p>@2017 CS3220 Midterm</p>");
		out.println("</footer>");

		out.println("</body>");
		
		
	}

	/** Click the button, and input the information to chart */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// set html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/** Add head and set information */
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">");
		out.println("<title> Create Midterm Practice </title>");
		out.println("</head>");
		out.println("<h2>Added new Information in the list !</h2>");
		out.println("<button onclick=\"location.href='../midterm_Practice_Study'\">Go back to ChartEntry</button>");

	}
	public RestaurantList getRandomRestaurant(List<RestaurantList> entries_rest){
		return entries_rest.get(new Random().nextInt(entries_rest.size()));
	}
	
	

}
