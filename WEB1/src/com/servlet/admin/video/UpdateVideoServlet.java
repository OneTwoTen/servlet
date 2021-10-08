package com.servlet.admin.video;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class UpdateVideoServlet
 */
@WebServlet("/admin/videos/update")
public class UpdateVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 private VideoDAO videoDAO;
    public UpdateVideoServlet() {
        super();
     this.videoDAO=new VideoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Video entity = this.videoDAO.findByID(id);
		String view="/views/admin/videos/update.jsp";
		request.setAttribute("view", view);
		request.setAttribute("video", entity);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video entity = new Video();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.videoDAO.update(entity);
		response.sendRedirect(request.getContextPath() + "/videos");
	}

}
