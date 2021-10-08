package com.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;
import com.until.Email;
import com.until.EmailUntils;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgotpassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserDAO userDAO;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
     this.userDAO=new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("views/auth/forgotpassword.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress= request.getParameter("email"), fullname=request.getParameter("fullname");
			User user=userDAO.findByIdAndEmail(emailAddress);
			if (user==null) {
				request.setAttribute("error", "Email are incorrect");
			}else {
				Email email=new Email();
				email.setFrom("caodo200184@gmail.com");
				email.setFromPassword("d@200195");
				email.setTo(emailAddress);
				email.setSubject("Forgot password");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(user.getFullname()).append("<br>");
				sb.append("You are used the forgot password. <br>");
				sb.append("Your password is <b>").append(user.getPassword()).append("<b> <hr>");
				sb.append("Regards <br>");
				sb.append("Admintrator");
				email.setContent(sb.toString());
				EmailUntils.send(email);
				
				request.setAttribute("message", "Email sent to the email address, please check and get your password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("views/auth/forgotpassword.jsp").forward(request, response);
	}

}
