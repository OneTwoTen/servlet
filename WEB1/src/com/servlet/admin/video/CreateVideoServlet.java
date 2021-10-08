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
import com.entity.Video;

@WebServlet("/admin/new-video")
public class CreateVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;

	public CreateVideoServlet() {
		super();
		this.videoDAO = new VideoDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = "/views/admin/videos/create.jsp";
		request.setAttribute("view", view);
		request.getRequestDispatcher("views/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video entity = new Video();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		this.videoDAO.store(entity);
		doGet(request, response);
	}

}
