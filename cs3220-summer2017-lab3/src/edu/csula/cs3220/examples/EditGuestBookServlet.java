package edu.csula.cs3220.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbook/edit/")
public class EditGuestBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		GuestBookEntry leEntry = null;
		for (GuestBookEntry entry : entries) {
			if (entry.getId() == id) {
				leEntry = entry;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Editing comment</h1>");
		out.println("<form method=\"post\">");
		out.println("Your name: <input name='name' type='text' value='" + leEntry.getName() + "'/></br>");
		out.println("<textarea name='comment'>" + leEntry.getComment() + "</textarea></br>");
		out.println("<button>Edit</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		GuestBookEntry leEntry = null;
		int index = -1;
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).getId() == id) {
				leEntry = entries.get(i);
				index = i;
			}
		}
		entries.set(index,
				new GuestBookEntry(leEntry.getId(), request.getParameter("name"), request.getParameter("comment")));
		getServletContext().setAttribute("entries", entries);

		PrintWriter out = response.getWriter();
		out.println("<a href='../guestbook'>go back to guestbook</a>");
	}
}