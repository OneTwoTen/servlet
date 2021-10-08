package com.servlet.admin.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/admin/users/delete")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		User user = (User) request.getSession().getAttribute("user");
		if (idStr == null) {
			// 400 Bad Request
		}
		if (user.getRole() == 2) {
			request.getSession().setAttribute("error", "Lỗi");
			response.sendRedirect("/WEB1/admin/users");
		}else {
			int id = Integer.parseInt(idStr);
			
			User entity = new User();
			
			entity.setId(id);
			
			this.userDAO.delete(entity);
			
			response.sendRedirect("/WEB1/admin/users");
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
