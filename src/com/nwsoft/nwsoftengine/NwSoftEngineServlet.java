package com.nwsoft.nwsoftengine;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class NwSoftEngineServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		out.println("Hello, world");
	}
}
