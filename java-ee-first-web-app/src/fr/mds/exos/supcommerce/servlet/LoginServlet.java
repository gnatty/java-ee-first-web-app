package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.mds.exos.supcommerce.model.Product;
import fr.mds.exos.supcommerce.dao.ProductDao;

@WebServlet(name="login", urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	
	private static String accUsername 		= "root";
	private static String accPassword 		= "root";
	private static String userSessionSecret 	= "blablaMaSessionSecrete";
	private static String baseDir 			= "/views/";
	private static String fileName 			= "login.jsp";
	private static String userSessionName	= "userSession";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(baseDir + fileName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// --- Get from values.
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		ServletContext sc = req.getServletContext();
		
		// --- Check the values.
		if(accUsername.equals(username) && accPassword.equals(password) ) {
			// -- Create the session.
			HttpSession sess = req.getSession();
			sess.setAttribute(userSessionName, userSessionSecret);
			// -- Redirect the user
			resp.sendRedirect(sc.getAttribute("projetDir") + "/dashboard");
		} else {
			// -- Throw error.
			resp.sendRedirect(sc.getAttribute("projetDir") + "/login");
		}	
	}
	
}