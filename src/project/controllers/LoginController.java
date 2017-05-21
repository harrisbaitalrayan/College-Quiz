package project.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.businessmanager.DatabaseConnectionFactory;
import project.businessmanager.ExamManager;
import project.model.QuizQuestion;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/checkLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		ResultSet set = null;
		int i = 0;
		

		try {
			Connection con = DatabaseConnectionFactory.createConnection();
			Statement st = con.createStatement();

			String sql = "insert into users (name,id) values ('" + username + "','" + userid + "') ";
			System.out.println(sql);
			st.executeUpdate(sql);
			
			HttpSession session = request.getSession();
			session.setAttribute("quest", null);
			session.setAttribute("user", username);
			session.setAttribute("exam", null);
			
			RequestDispatcher rd = request.getRequestDispatcher("exam");
	        rd.forward(request, response);

			//response.sendRedirect("/exam");
			
			/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/exam.jsp");
			rd.forward(request, response);*/
	        con.close();

		} catch (SQLException sqe) {
			System.out.println("Error : While Fetching records from database");
		}
		
	}

}
