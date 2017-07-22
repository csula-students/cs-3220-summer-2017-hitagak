package cs3220_lab4;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdminHeader extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();

		// create header
		out.println("<h1><img src=" + "\"" + "http://www.clker.com/cliparts/V/v/E/P/w/D/restaurant-hi.png" + "\""
				+ " width=\"100\" height=\"100\"> American's Food Restaurant - Admin Site</h1>");

	}
}
