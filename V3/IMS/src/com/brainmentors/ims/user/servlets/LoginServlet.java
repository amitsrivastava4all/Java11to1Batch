package com.brainmentors.ims.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brainmentors.ims.user.dao.LoginDAO;
import com.brainmentors.ims.user.dto.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		LoginDAO loginDAO = new LoginDAO();
		try {
			User userInfo = loginDAO.isUserLogin(email, pwd);
			if(userInfo!=null){
				HttpSession session = request.getSession(true);
				session.setAttribute("user", email);
				session.setAttribute("userinfo", userInfo);
				response.sendRedirect("dashboard.jsp");
				
				//response.sendRedirect("dashboard.jsp?user="+email);
				//out.println("Welcome "+email);
			}
			else{
				out.println("Invalid Userid or Password ");
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
