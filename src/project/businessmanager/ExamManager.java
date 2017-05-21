package project.businessmanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




import project.model.QuizQuestion;

public class ExamManager {

	public ArrayList<QuizQuestion> questionList = new ArrayList<QuizQuestion>(10);
	public int currentQuestioNumber;
	public Map<Integer, Integer> selections = new LinkedHashMap<Integer, Integer>();

	public ExamManager() throws SQLException {
		// TODO Auto-generated constructor stub

		// set the questions in the ArrayList
		String question = "";
		String[] options = { "", "", "", "" };
		
		
		
		Connection con = DatabaseConnectionFactory.createConnection();
		Statement st = con.createStatement();
		
		String sql = "SELECT question_number , question , optionA 	, optionB , optionC , optionD , correct_option FROM questions";
	    ResultSet rs = st.executeQuery(sql);
		
		
	    while(rs.next()){
	    	
	        QuizQuestion q = new QuizQuestion();
	        options = new String[4];
	        
	 		question = rs.getString("question");	 		
	 		options[0] =rs.getString("optionA");
	 		options[1] = rs.getString("optionB");
	 		options[2] = rs.getString("optionC");
	 		options[3] = rs.getString("optionD");
	 		
	 		int correctOption = rs.getInt("correct_option");
	 		int questioNumber = rs.getInt("question_number");
	 		

	 		q.setQuestionNumber(questioNumber);
	 		q.setQuestion(question);
	 		q.setQuestionOptions(options);
	 		q.setCorrectOptionIndex(correctOption);
	 		questionList.add(questioNumber-1, q);
	    	
	    	
	    }
		
	    rs.close();
	    con.close();


	}

	public QuizQuestion getQuestion(int i) {
		currentQuestioNumber = i;
		return questionList.get(i-1);

	}

	public ArrayList<QuizQuestion> getQuestionList() {
		return this.questionList;
	}

	public int getCurrentQuestionNumber() {
		return currentQuestioNumber;
	}
	
	
	
	public int calculateResult(ExamManager exam) {
		int totalCorrect = 0;
		Map<Integer, Integer> userSelectionsMap = exam.selections;
		
		List<Integer> userSelectionsList = new ArrayList<Integer>(10);
		for (Map.Entry<Integer, Integer> entry : userSelectionsMap.entrySet()) {
			userSelectionsList.add(entry.getValue());
		}
		List<QuizQuestion> questionList = exam.getQuestionList();
		List<Integer> correctAnswersList = new ArrayList<Integer>(10);
		for (QuizQuestion question : questionList) {
			correctAnswersList.add(question.getCorrectOptionIndex());
		}

		for (int i = 0; i < userSelectionsList.size(); i++) {
			System.out.println(userSelectionsList.get(i) + " --- " + correctAnswersList.get(i));
			if ((userSelectionsList.get(i) ) == correctAnswersList.get(i)) {
				totalCorrect++;
			}
		}

		System.out.println("You Got " + totalCorrect + " Correct");
		return totalCorrect;
	}

}
