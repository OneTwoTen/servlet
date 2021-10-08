package com.servlet.admin.favorite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FavoriteDAO;
import com.entity.Favorite;
import com.entity.User;

/**
 * Servlet implementation class UnlikeServlet
 */
@WebServlet("/unlike")
public class UnlikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteDAO favoriteDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnlikeServlet() {
		super();
		this.favoriteDAO = new FavoriteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
//		User user = (User) request.getSession().getAttribute("user");
		if (idStr == null) {
			// 400 Bad Request
		}
		System.out.println(idStr);
		int id = Integer.parseInt(idStr);

		Favorite entity = new Favorite();

		entity.setId(id);

		this.favoriteDAO.delete(entity);

		response.sendRedirect("/WEB1/videos/favorites");

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
