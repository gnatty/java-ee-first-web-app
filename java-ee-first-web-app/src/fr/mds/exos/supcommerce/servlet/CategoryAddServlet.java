package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="categoryAdd", urlPatterns="/dashboard/category/add")
public class CategoryAddServlet extends HttpServlet {

	private static String baseDir 			= "/views/category/";
	private static String fileName 			= "add.jsp";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// --- RENDER VIEW
		req.getRequestDispatcher(baseDir + fileName).forward(req, resp);
	}
}
