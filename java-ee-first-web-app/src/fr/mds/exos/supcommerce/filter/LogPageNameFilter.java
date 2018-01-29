package fr.mds.exos.supcommerce.filter;

import java.io.IOException;
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
public class LogPageNameFilter implements Filter {
	
	private String sentence = "[LOG] LogPageName : ";
	
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
    		HttpServletRequest req = (HttpServletRequest) request;
    		
    		// --- Show current page name.
    		String requestUri = req.getRequestURI();
    		System.out.println(sentence + requestUri);
    		
    		System.out.println("oggo : " + req.getContextPath());
    		
    		// --- Set the context path.
    		String contextPath = req.getContextPath();
    		ServletContext sc = request.getServletContext();
    		sc.setAttribute("projetDir", contextPath);
    		
    		chain.doFilter(request, response);	
    		
    }

    public void destroy() {
    }
 
}
