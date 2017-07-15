package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Edit order status in admin site */

@WebServlet("/admin/order/")
public class EditOrderStatusServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> entries_order = (List<Order>) getServletContext().getAttribute("entries_order");
		Order leEntry = null;

		for (Order entries : entries_order) {
			if (entries.getId() == id) {
				leEntry = entries;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../app.css\">");
		out.println("<title>Order Editing</title>");
		out.println("<h2>Edit Order</h2>");

		out.println("<form method=\"post\">");
		out.println("<select id =\"status\" name = \"status\">");
		out.println("<option value =\"IN_QUEUE\" selected>" + leEntry.getinqueueStatus() + "</option>");
		out.println("<option value =\"IN_PROGRESS\">" + leEntry.getinprogressStatus() + "</option>");
		out.println("<option value =\"COMPLETED\">" + leEntry.getcompletedstatus() + "</option>");
		out.println("</select>");
		out.println("<button>Edit</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> entries_order = (List<Order>) getServletContext().getAttribute("entries_order");
		Order leEntry = null;
		int index = -1;
		for (int i = 0; i < entries_order.size(); i++) {
			if (entries_order.get(i).getId() == id) {
				leEntry = entries_order.get(i);
				index = i;
			}
		}

		leEntry.setStatus(request.getParameter("status").toString());

		entries_order.set(index, new Order(leEntry.getId(), leEntry.getFood(), leEntry.getName(), leEntry.getStatus(),
				leEntry.getDate()));
		getServletContext().setAttribute("entries_order", entries_order);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../app.css\">");
		out.println("<title>Food Item Editing</title>");
		out.println("<h2>Finish Editing !</h2>");
		out.println("<button onclick=\"location.href='../../admin/orders'\">Order Status -Admin</button>");

	}
}
