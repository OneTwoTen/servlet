package com.filter;

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

import com.entity.User;
import com.role.UsersRole;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/admin/*")
public class AuthenticationFilter implements Filter {

	public AuthenticationFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			session.setAttribute("error", "Bạn cần quyền admin");
			httpResponse.sendRedirect("/WEB1/login");
		}else {
			if(user.getRole() != UsersRole.ADMIN) {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				session.setAttribute("error", "Bạn cần quyền admin");
				httpResponse.sendRedirect("/WEB1/login");
			}
			else if (user.getRole() == 2) {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
