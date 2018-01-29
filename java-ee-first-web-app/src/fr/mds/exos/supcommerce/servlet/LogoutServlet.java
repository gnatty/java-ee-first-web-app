package fr.mds.exos.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="logout", urlPatterns="/logout")
public class LogoutServlet extends HttpServlet {

  private static String userSessionName = "userSession";
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    
    // Cast.
    HttpServletRequest req    	= (HttpServletRequest) request;
    ServletContext sc       		= req.getServletContext();
    HttpSession sess      		= req.getSession();
    
    // Path.
    String loginPage      		= (sc.getAttribute("projetDir") + "/login");
    
    // Remove the session.
    sess.removeAttribute(userSessionName);
    
    // Redirect.
    resp.sendRedirect(loginPage);
    
  }
  
}