package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.mds.exos.supcommerce.entity.CategoryEntity;

@WebServlet(name="dashboard", urlPatterns="/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private static String baseDir 			= "/views/";
	private static String fileName 			= "dashboard.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// --- RENDER VIEW
		req.getRequestDispatcher(baseDir + fileName).forward(req, resp);
	}
	
}