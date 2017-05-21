package project.businessmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory {

	private static String dbURL = "jdbc:mysql://localhost:8889/quiz";
	private static String dbUser = "root";
	private static String dbPassword = "root";
	private static Connection con = null;

	public static Connection createConnection() throws SQLException {
		
		if(con!=null && !con.isClosed()){
			return con;
		}

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			
		} catch (SQLException sqe) {
			System.out.println("Error: While Creating connection to database");
			sqe.printStackTrace();
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
		return con;
	}

}
