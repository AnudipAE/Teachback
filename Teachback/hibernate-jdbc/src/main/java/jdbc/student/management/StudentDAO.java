package jdbc.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	static PreparedStatement pstmt = null;
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	//Method to Insert
		public static boolean insert(Student obj) {
				
			boolean f = false;
					try {
						//this will create Connection
						 conn = CP.createC();
						
						//Use connection to fire queries
						String q = "INSERT INTO STUDENTS(ID, First_Name, Last_Name, EMAIL) Values(?,?,?,?)";
						
						//PreparedStatement
						pstmt = conn.prepareStatement(q);
						
						//Set the value for parameter
						pstmt.setInt(1, obj.getId());
						pstmt.setString(2, obj.getFirstName());
						pstmt.setString(3, obj.getLastName());
						pstmt.setString(4, obj.getEmail());
						
						//Execute
						pstmt.executeUpdate();
						f = true;
						
					} catch (SQLException e) {
						e.printStackTrace();
						
					}
					finally { //Finally block to close all resources
						try {
							if(pstmt != null)
									pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							if(conn != null)
									conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				return f;
		}
		
		//Method to Update
		public static boolean update(Student obj, int sid) {
			boolean f = false;
			try {
				//this will create Connection
				 conn = CP.createC();
			
				//Use connection to fire queries
				String q = "UPDATE STUDENTS SET First_Name = ? ,  Last_Name = ?,  EMAIL = ? WHERE ID = ?";
				
				//PreparedStatement
				pstmt = conn.prepareStatement(q);
				
				//Set the value for parameter
				pstmt.setString(1, obj.getFirstName());
				pstmt.setString(2, obj.getLastName());
				pstmt.setString(3, obj.getEmail());
				pstmt.setInt(4, sid);
				
				
				//Execute
				pstmt.executeUpdate();
				f = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			finally {
				try {
					if(pstmt != null)
						pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return f;
		}
		
		//Method to Delete
		public static boolean delete(int id) {
			boolean f = false;
			try {
				//this will create Connection
				 conn = CP.createC();
				
				//Use connection to fire queries
				String q = "DELETE FROM STUDENTS WHERE ID = ?";
				
				//PreparedStatement
				 pstmt = conn.prepareStatement(q);
				
				//Set the value for parameter
				pstmt.setInt(1, id);

				//Execute
				pstmt.executeUpdate();
				f = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			finally {
				try {
					if(pstmt != null)
							pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return f;
		}
		
		//Method to Display
		public static void display() {
		
			try {
				//this will create Connection
				 conn = CP.createC();
				
				//Use connection to fire queries
				String q = "SELECT * FROM STUDENTS";
				
				//Statement
				stmt = conn.createStatement();
				
				//Execute Using ResultSet
				rs = stmt.executeQuery(q);
				
				while(rs.next()) {
					//Retrieve by Column name
					int id = rs.getInt(1);
					String firstName = rs.getString(2);
					String lastName = rs.getString(3);
					String email = rs.getString(4);
					
					//Display values
					System.out.println("ID : " + id);
					System.out.println("FIRST NAME : " + firstName);
					System.out.println("GENRE : " + lastName);
					System.out.println("YEAR OF RELEASE : " + email);
					System.out.println();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			finally {
				try {
					if(rs != null)
						rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(stmt != null)
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

}
