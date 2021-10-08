package com.servlet.admin.users;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.entity.User;
import com.role.UsersRole;

/**
 * Servlet implementation class UserInfomationServlet
 */
@WebServlet("/user/infomation")
public class UserInfomationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfomationServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			int id = Integer.parseInt(request.getParameter("id"));
			User user = (User) request.getSession().getAttribute("user");
			User entity = this.userDAO.findByID(user.getId());
			String view = "/views/admin/users/userinfomation.jsp";
			request.setAttribute("view", view);
			request.setAttribute("user", entity);
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User entity = new User();
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole() == UsersRole.ADMIN) {
			entity.setRole(2);
		} else {
			entity.setRole(1);
		}
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userDAO.update(entity);
		session.setAttribute("user", entity);
		response.sendRedirect(request.getContextPath() + "/user/infomation");
//		doGet(request, response);
	}

}
