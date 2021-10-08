package com.servlet.admin.favorite;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.dao.FavoriteDAO;
import com.dao.VideoDAO;
import com.entity.Favorite;
import com.entity.FavoriteVideo;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class FavoriteManagementServlet
 */
@WebServlet("/videos/favorites")
public class FavoriteManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;
	private FavoriteDAO favoriteDAO;

	public FavoriteManagementServlet() {
		super();
		this.videoDAO = new VideoDAO();
		this.favoriteDAO = new FavoriteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		List<Favorite> listFavoriteVideo = favoriteDAO.like(user);
		String view = "/views/admin/users/favorite.jsp";
		request.setAttribute("view", view);
		request.setAttribute("listFavoriteVideo", listFavoriteVideo);
//		request.setAttribute("listUser", listUser);
//		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
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
