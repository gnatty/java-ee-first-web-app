package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.mds.exos.supcommerce.dao.ProductDao;
import fr.mds.exos.supcommerce.model.Product;

@WebServlet(name="productList", urlPatterns="/dashboard/product/list")
public class ProductListServlet extends HttpServlet {

	private static String baseDir 			= "/views/product/";
	private static String fileName 			= "list.jsp";
	
	// --- DB INIT
	private EntityManagerFactory 	emf;
	private EntityManager 			em;
	private EntityTransaction 		t;
	
	@Override
	public void init() {
		emf = Persistence.createEntityManagerFactory("mdsman");
		em 	= emf.createEntityManager();
		t 	= em.getTransaction();
	}
	
	@Override
	public void destroy() {
		em.close();
	}
	// --- .\ DB INIT
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		// --- all product list
		ArrayList<Product> allProduct = ProductDao.getAllProducts();
		req.setAttribute("productList", allProduct);
		req.getRequestDispatcher(baseDir + fileName).forward(req, resp);
		

	}
	
}
