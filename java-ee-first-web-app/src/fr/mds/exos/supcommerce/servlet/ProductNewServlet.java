package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.mds.exos.supcommerce.dao.ProductDao;
import fr.mds.exos.supcommerce.entity.CategoryEntity;
import fr.mds.exos.supcommerce.entity.ProductEntity;
import fr.mds.exos.supcommerce.model.Product;

@WebServlet(name="productAdd", urlPatterns="/dashboard/product/add")
public class ProductNewServlet extends HttpServlet {
	
	private static String baseDir 			= "/views/product/";
	private static String fileName 			= "add.jsp";
	
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// --- Show the view.
		req.getRequestDispatcher(baseDir + fileName).forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Cast.
		ServletContext sc = req.getServletContext();
		
		// --- Get from values.
		String name 			= req.getParameter("name");
		String description 	= req.getParameter("description");
		String price 		= req.getParameter("price");
		boolean error 		= false;
		String redirectName = "";
		
		if( !name.equals("") && !description.equals("") && !price.equals("") ) {
			try {
				// Parse the price;
				float productPrice = Float.parseFloat(price);
				// -- Add new product.
				ProductEntity product = new ProductEntity(name, description, productPrice);

				// -- INSERT DB
				t.begin();
				em.persist(product);
				t.commit();
				// -- .\ INSERT DB
			} catch(Exception e) {
				error = true;
			} finally {
				if (t.isActive()) t.rollback();
			}
		} else {
			error = true;
		}
		
		// --- Check for error.
		if(error) {
			redirectName = "/dashboard/product/add";
		} else {
			redirectName = "/dashboard/product/list";
		}
		
		// Redirect.
		resp.sendRedirect(sc.getAttribute("projetDir") + redirectName);
	}
	
}
