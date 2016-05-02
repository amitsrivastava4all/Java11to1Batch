package com.brainmentors.ims.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
@WebFilter("*.jsp")
public class SessionCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("URI "+uri);
		if(uri.indexOf("index.jsp")>=0){
			chain.doFilter(request, response);	
		}
		else
		{
			HttpSession session = ((HttpServletRequest)request).getSession(false);
			if(session == null){
				((HttpServletResponse)response).sendRedirect("index.jsp");
			}
			else
			{
				if(session.getAttribute("user")==null){
					((HttpServletResponse)response).sendRedirect("index.jsp");
				}
				else{
				chain.doFilter(request, response);
				}
				}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
