package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.exos.supcommerce.dao.ProductDao;
import fr.mds.exos.supcommerce.model.Product;

@WebServlet(name="productDetail", urlPatterns="/dashboard/product/detail/*")
public class ProductShowByIdServlet extends HttpServlet {

	private static String baseDir 			= "/views/product/";
	private static String fileName 			= "view.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			if(req.getPathInfo().equals(null)) {
				throw new Exception();
			}
			
			// -- Get the product id from url.
			String tempProductId = req.getPathInfo().replace("/", "");
			long productId = Long.parseLong(tempProductId);
			
			// -- Get the product from ArrayList.
			Product product = ProductDao.findProduct(productId);
			
			if( product.equals(null) ) {
				throw new Exception();
			} else {
				req.setAttribute("product", product);
			}
			
		} catch(Exception e) {
			// Catch error.
		}
		
		req.getRequestDispatcher(baseDir + fileName).forward(req, resp);
		
	}
	
}

