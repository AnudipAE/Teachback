package jdbc.student.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentApp {
public static void main(String[] args) throws IOException {
		
		System.out.println("_______Welcome to Student Management System________ ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	while(true) {
		System.out.println("PRESS 1 to ADD Student");
		System.out.println("PRESS 2 to UPDATE Student");
		System.out.println("PRESS 3 to DELETE Student");
		System.out.println("PRESS 4 to DISPLAY Students");
		System.out.println("PRESS 5 to EXIT from Student Management System");
		
		int c = Integer.parseInt(br.readLine());
		
		if(c==1) {
			//Add Student..
			System.out.println("Enter Id :");
			int id = Integer.parseInt(br.readLine());
			
			System.out.println("Enter First Name :");
			String firstName = br.readLine();
			
			System.out.println("Enter Last Name :");
			String lastName = br.readLine();
			
			System.out.println("Enter Email :");
			String email = br.readLine();
			
			//Creating object of Student class
			Student obj = new Student(id, firstName, lastName, email);
			
			System.out.println(obj);
			
			//Calling of method to insert into table and passing the object of Student class
			boolean result = StudentDAO.insert(obj);
			if(result) {
				System.out.println("Successfully added.");
			}
			else {
				System.out.println("Something went wrong.");
			}
		}
		
		else if(c==2) {
			//Update Student..
			
			System.out.println("Enter First Name :");
			String firstName = br.readLine();
			
			System.out.println("Enter Last Name :");
			String lastName = br.readLine();
			
			System.out.println("Enter Email :");
			String email = br.readLine();
			
			//Creating object of Student class
			Student obj = new Student(firstName, lastName, email);

			System.out.println("Enter Id to which update :");
			int sid = Integer.parseInt(br.readLine());
			
			//Calling of method to update table and pass the obj of Student class
			boolean result = StudentDAO.update(obj, sid);
			if(result) {
				System.out.println("Successfully updated.");
			}
			else {
				System.out.println("Something went wrong.");
			}
		}
		
		else if(c==3) {
			//Delete Student..
			
			System.out.println("Enter Student id to delete :");
			int id = Integer.parseInt(br.readLine());
			
			//Calling method to delete particular row
			boolean result = StudentDAO.delete(id);
			if(result) {
				System.out.println("Successfully deleted.");
			}
			else {
				System.out.println("Something went wrong.");
			}
		}
		
		else if(c==4) {
			//Display Student..
			
			//Calling method display to display the table values
			StudentDAO.display();
		}
		
		else if(c==5) {
			//Exit
			System.out.println("Thankyou for visiting Student Management System.");
			break;
		}
		else {
			System.out.println("Invalid Input!");
		}
	}
	System.out.println("GoodBye! Do visit us again");
}
}
