package com.training;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.LoginDAO;
import com.training.dao.LoginDAOimpl;
import com.training.model.User;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String gender = request.getParameter("gender");
		String notification[] = request.getParameterValues("notification");
		String qualification = request.getParameter("qualification");
		String finalNotification = "";
		
		for(String temp: notification) {
			finalNotification += temp + ":";
		}
		
		User user = new User(-1, uname, pwd, gender, finalNotification, qualification);
		
		LoginDAO loginDAO = new LoginDAOimpl();
		loginDAO.register(user);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		out.println("Welcome: "+uname);
		//out.println("You are registered successfully and your password is :"+pwd);
		//out.println(user);
		out.println("</br><h1>Please <a href=login.html>Login</a></h1>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
