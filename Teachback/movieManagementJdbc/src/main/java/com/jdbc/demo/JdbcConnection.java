/*
 * 2. Implement the class MovieDAO (DAO - Data Access Object). It should perform basic database 
 * operations for the MOVIES table, the structure of which is described in task 1. Assume that an
 *  object representing an open database connection comes in the constructor of this class. Remember 
 *  to use PreparedStatement where possible and close objects (use try-with-resources). Also
 *   implement a Movie class that represents a single row in the MOVIES table that you will use in 
 *   implementing the MovieDAO class.
Implement the following operations. Each of them should be represented by a separate public method:
•	adding a record 
•	delete record by identifier
•	update of the movie title with id data
•	searching for a movie by ID
•	to display all the records

 */
//Connection procedure class to create collection
package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";

	static Connection conn;

	// Database Credentials
	static final String user = "root";
	static final String password = "admin";

	public static Connection createC() {

		try {
			// load the driver
			Class.forName(JDBC_DRIVER);

			// create the connection
			conn = DriverManager.getConnection(DB_URL, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return conn;
	}
}
