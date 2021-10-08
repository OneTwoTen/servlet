package com.servlet.admin.video;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;
import com.role.UsersRole;

/**
 * Servlet implementation class VideoManagementServlet
 */
@WebServlet("/videos")
public class VideoManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;

	public VideoManagementServlet() {
		super();
		this.videoDAO = new VideoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pageStr = request.getParameter("page"), limitStr = request.getParameter("limit");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int limit = limitStr == null ? 10 : Integer.parseInt(limitStr);

		int offset = limit * (page - 1);
		List<Video> listVideo = this.videoDAO.paginate(offset, limit);
		String view = "/views/admin/videos/index.jsp";
		request.setAttribute("view", view);
		request.setAttribute("listVideo", listVideo);
		request.setAttribute("page", page);
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
