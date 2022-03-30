package com.training;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.dao.LoginDAO;
import com.training.dao.LoginDAOimpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private static Logger Logger = org.apache.log4j.Logger.getLogger(LoginDAOimpl.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		out.println("<html><body>");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("username", uname);
		
		LoginDAO loginDAO = new LoginDAOimpl();
		
		boolean result = loginDAO.validate(uname, pwd);
		
		if(result) {
			session.setAttribute("message", "Valid User");
			out.println("<h1>Welcome: "+uname+"</h1>");
			//out.println("<h1>Proceed to your home page: <a href=home.html>Home</a></h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.include(request, response);
			Logger.info(uname+ " has logged on at: "+ new java.util.Date());
		}
		else {
			session.setAttribute("message", "Nat valid User");
			out.println("<h1>Your username/password is incorrect</h1>");
			out.println("</br><h1>Please <a href=login.html>Login</a> again</h1>");
		}
		
		
		//out.println("Your password is :"+pwd);
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
