package project.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import project.businessmanager.ExamManager;
import project.model.QuizQuestion;

@WebServlet("/exam")
public class ExamController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		boolean finish = false;

		HttpSession session = req.getSession();
		
		QuizQuestion quest = (QuizQuestion) req.getSession().getAttribute("quest");
		ExamManager exam = (ExamManager) req.getSession().getAttribute("exam");
		String action = req.getParameter("action");
		String selectedAnswer = req.getParameter("answer");
		String username = req.getParameter("username");
		
		
		if(exam==null || quest==null ){
			
			try {
				
				
				exam = new ExamManager();
				quest =  exam.getQuestion(1);
				session = req.getSession();
				session.setAttribute("quest", quest);
				session.setAttribute("user", username);
				session.setAttribute("exam", exam);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsps/exam.jsp");
				rd.forward(req, resp);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			
			int currentQuestionNumber = exam.getCurrentQuestionNumber();
			
			if ("Next".equals(action)) {
				if(selectedAnswer!=null){
					exam.selections.put(exam.getCurrentQuestionNumber(), Integer.parseInt(selectedAnswer));
				}else{
					exam.selections.put(exam.getCurrentQuestionNumber(), 0);
				}
				
				
				
				if(currentQuestionNumber<exam.getQuestionList().size()){
					quest =  exam.getQuestion(currentQuestionNumber+1);
					session.setAttribute("quest", quest);
				}else{
					finish = true;
					int result = exam.calculateResult(exam);
					req.setAttribute("result", result);
					req.getSession().setAttribute("currentExam", null);
					req.getRequestDispatcher("/WEB-INF/jsps/result.jsp").forward(req, resp);
					
				}
				
				
			} else if ("Previous".equals(action)) {
				quest =  exam.getQuestion(currentQuestionNumber-1);
				session.setAttribute("quest", quest);
				
			} else if ("Finish Exam".equals(action)) {
				finish = true;
				int result = exam.calculateResult(exam);
				req.setAttribute("result", result);
				req.getSession().setAttribute("currentExam", null);
				req.getRequestDispatcher("/WEB-INF/jsps/result.jsp").forward(req, resp);

			}
			
			if (!finish) {
				req.getRequestDispatcher("/WEB-INF/jsps/exam.jsp").forward(req, resp);
			}
		}
	}
	
	
	

	
}
