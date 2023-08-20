package operations;

import java.util.Scanner;

//class menu
public class Menu {

	//Scanner object for taking user input
	Scanner sc = new Scanner(System.in);

	//method for displaying menu
	public int menu() {
		System.out.println();

		//menu displaying
		System.out.println("1. Display Phone Book in 2D Array.");
		System.out.println("2. Display Phone Book in Hash Map.");
		System.out.println("3. Insert Name in 2D Array. ");
		System.out.println("4. Insert Number in 2D Array.");
		System.out.println("5. Insert Name and Number in Hash Map.");
		System.out.println("6. Time taken for insertion in 2D Array.");
		System.out.println("7. Time taken for insertion in Hash Map.");
		System.out.println("8. Exit.");

		int choice = sc.nextInt(); // taking the input from the user and assigning to variable choice

		return choice; // returning choice
	} // end of menu method

}// method of class menu
