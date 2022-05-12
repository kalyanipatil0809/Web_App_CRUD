package in.sts.StudentWebApp.mysqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/web_application";
	private static final String userName = "root";
	private static final String Pass = "root";
	private static Connection connection;
	public static Connection connect()  {
		try {
			 connection = DriverManager.getConnection(url, userName, Pass);
		}
		catch (SQLException exception) {
			System.out.println("Cannot create database connection");
			exception.printStackTrace();
		}
		return connection;
	}
}
