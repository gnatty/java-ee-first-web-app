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

import fr.mds.exos.supcommerce.dao.ProductDao;
import fr.mds.exos.supcommerce.model.Product;

@WebServlet(name="productRemove", urlPatterns="/dashboard/product/remove/*")
public class ProductRemoveServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		try {
			if(request.getPathInfo().equals(null)) {
				throw new Exception();
			}
			
			// -- Get the product id from url.
			String tempProductId = request.getPathInfo().replace("/", "");
			long productId = Long.parseLong(tempProductId);
			
			if( ProductDao.removeProduct(productId) ) {
				// Yup.
			} else {
				// Nop.
			}
			
		} catch(Exception e) {
			// Catch error.
		}
		
		// Redirect.
		HttpServletRequest req		= (HttpServletRequest) request;
		ServletContext sc 			= req.getServletContext();
		resp.sendRedirect(sc.getAttribute("projetDir") + "/dashboard/product/list");
		
	}

}
