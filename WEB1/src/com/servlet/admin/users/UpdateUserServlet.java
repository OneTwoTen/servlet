package com.servlet.admin.users;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.entity.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/admin/users/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public UpdateUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User entity = this.userDAO.findByID(id);
		String view="/views/admin/users/update.jsp";
		request.setAttribute("view", view);
		request.setAttribute("user", entity);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userDAO.update(entity);
		response.sendRedirect(request.getContextPath() + "/admin/users");
	}

}
