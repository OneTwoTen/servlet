package com.servlet.admin.video;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/videos/delete")
public class DeleteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteVideoServlet() {
		super();
		this.videoDAO = new VideoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");

		if (idStr == null) {
			// 400 Bad Request
		}

		int id = Integer.parseInt(idStr);

		Video entity = new Video();

		entity.setId(id);

		this.videoDAO.delete(entity);;

		response.sendRedirect("/WEB1/videos");
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
