//package com.filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.catalina.manager.util.SessionUtils;
//import org.hibernate.Session;
//
//import com.entity.User;
//import com.role.UsersRole;
//import com.until.HibernateUntils;
//
///**
// * Servlet Filter implementation class AuthorizationFilter
// */
//@WebFilter({ "/*", "/user/update" })
//public class AuthorizationFilter implements Filter {
//
//	public AuthorizationFilter() {
//
//	}
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		HttpSession session = httpRequest.getSession();
//		User user = (User) session.getAttribute("user");
//		if (user == null) {
//			HttpServletResponse httpResponse = (HttpServletResponse) response;
//			httpResponse.sendRedirect(httpRequest.getContextPath() + "/videos");
//		} else {
//			chain.doFilter(request, response);
//		}
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
