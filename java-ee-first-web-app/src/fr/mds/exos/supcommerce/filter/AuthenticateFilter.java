package fr.mds.exos.supcommerce.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns="/*")
public class AuthenticateFilter implements Filter {
	
	private String userSessionSecret = "blablaMaSessionSecrete";
	private String baseDir 			= "/VIEWS/";
	private String fileName 			= "login.jsp";
	private String userSessionName	= "userSession";
	
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
    		// --- Cast;
    		HttpServletRequest req		= (HttpServletRequest) request;
    		ServletContext sc 			= req.getServletContext();
    		HttpSession sess 			= req.getSession();
    		HttpServletResponse resp 	= (HttpServletResponse) response;

		// --- Get value;
    		boolean redirect 			= false;
		String userSession 			= (String) sess.getAttribute(userSessionName);
		String redirectPath 			= "";
		String loginPage 			= (sc.getAttribute("projetDir") + "/login");
		String loginCheckPage 		= (sc.getAttribute("projetDir") + "/login/check");
		
		// --- No session.
		if( !userSessionSecret.equals(userSession) ) {
			// --- REMOVE THE SESSISON.
			sess.removeAttribute(userSessionName);
			// ---
			if( !Arrays.asList( loginPage, loginCheckPage ).contains( req.getRequestURI() ) )  {
				redirect 		= true;
				redirectPath 	= "/login";
			}
			// \. ---
		// --- With session.
		} else {
			// ---
			if( Arrays.asList( loginPage, loginCheckPage ).contains( req.getRequestURI() ) )  {
				redirect 		= true;
				redirectPath 	= "/dashboard";
			} 
			// \. ---
		}
		
		// --- Do the action.
		if(redirect) {
			resp.sendRedirect(sc.getAttribute("projetDir") + redirectPath);
		} else {
			chain.doFilter(request, resp);
		}
		// --- .\ Do the action.
    }

    public void destroy() {
    }
    
}
