package edu.csula.cs3220.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestBookServlet
 */

@WebServlet(loadOnStartup = 1, urlPatterns = { "/guestbook" })
public class GuestBookServlet extends HttpServlet {
	public void init() {
		// init the application scope to have pre-set values
		List<GuestBookEntry> entries = new ArrayList<>();
		entries.add(new GuestBookEntry(entries.size(), "Eric", "Hello"));
		entries.add(new GuestBookEntry(entries.size(), "John", "Hi there"));
		getServletContext().setAttribute("entries", entries);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> Hello GuestBook! </h1>");
		out.println("<table>");
		for (GuestBookEntry entry : entries) {
			out.println("<tr>" + "<td>" + entry.getName() + " says: </td>" + "<td>" + entry.getComment() + "</td>"
					+ "<td><a href='guestbook/edit?id=" + entry.getId() + "'>Edit</a> "
					+ "<a href='guestbook/delete?id=" + entry.getId() + "'>Delete</a></td>" + "</tr>");
		}
		out.println("</table>");
		out.println("<a href='guestbook/create'>Add comemnt</a>");
	}
}
