package com.servlet.admin.favorite;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.FavoriteDAO;
import com.entity.Favorite;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/favorite")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteDAO favoriteDAO;

	public FavoriteServlet() {
		super();
		this.favoriteDAO = new FavoriteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User authUser = (User) request.getSession().getAttribute("user");
		User user = new User();
		user.setId(authUser.getId());
		System.out.println(authUser.getId());
		Video video = new Video();
		video.setId(Integer.parseInt(request.getParameter("videoid")));
//		Favorite entity = new Favorite();
		Favorite b = this.favoriteDAO.findIdVideo(video, user);
		
		if (b == null) {
			System.out.println("hai");
			Favorite entity = new Favorite();
			entity.setVideo(video);
			entity.setLikedate(new Date());
			entity.setStatus(1);
			entity.setUser(user);
			try {
				BeanUtils.populate(entity, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			this.favoriteDAO.store(entity);
		} else {
			response.sendRedirect("/WEB1/videos");
			return;
		}
		response.sendRedirect("/WEB1/videos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
