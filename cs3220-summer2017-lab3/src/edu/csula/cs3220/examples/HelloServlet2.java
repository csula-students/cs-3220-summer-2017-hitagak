package edu.csula.cs3220.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello2")
public class HelloServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int counter = (int) getServletContext().getAttribute("counter");
		out.println("<h1> Hello CS-3220! </h1> <p>Counter : " + counter + "</p>");
		System.out.println(counter);
	}
}