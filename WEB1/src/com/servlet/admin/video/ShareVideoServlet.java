package com.servlet.admin.video;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ShareDAO;
import com.entity.Share;
import com.entity.User;
import com.entity.Video;
import com.until.Email;
import com.until.EmailUntils;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet("/videos/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShareDAO shareDAO;

	public ShareVideoServlet() {
		super();
		this.shareDAO = new ShareDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoid = request.getParameter("videoid");
		if (videoid == null) {
			response.sendRedirect(request.getContextPath() + "/videos");
			return;
		}
		request.setAttribute("videoid", Integer.parseInt(videoid));
		String view = "/views/admin/videos/share.jsp";
		request.setAttribute("view", view);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoid = request.getParameter("videoid");
			String emailAddress = request.getParameter("email"), fullname = request.getParameter("fullname");
			if (videoid == null) {
				request.setAttribute("error", "Email are incorrect");
			} else {
				Email email = new Email();
				email.setFrom("caodo200184@gmail.com");
				email.setFromPassword("d@200195");
				email.setTo(emailAddress);
				email.setSubject("Share Favorite Video");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append("<br>");
				sb.append("Video. <br>");
				sb.append("Video <b>").append(String.format("<a href=''>Video</a>", videoid)).append("<b> <hr>");
				sb.append("Regards <br>");
				sb.append("Admintrator");

				email.setContent(sb.toString());
				EmailUntils.send(email);
				Share share = new Share();
				share.setEmails(emailAddress);
				share.setSharedate(new Date());
				User user = (User) request.getSession().getAttribute("user");
				share.setUser(user);
				Video video = new Video();
				video.setId(Integer.parseInt(videoid));
				share.setVideo(video);
				shareDAO.store(share);
				request.setAttribute("message", "Email sent to the email address, please check and get your password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String view = "/views/admin/videos/index.jsp";
		request.setAttribute("view", view);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

}
