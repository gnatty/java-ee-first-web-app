package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="error", urlPatterns="/error")
public class ErrorServlet extends HttpServlet {
	
	private static String baseDir 			= "/views/";
	private static String fileName 			= "error.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(baseDir + fileName).forward(req, resp);
	}
	
}