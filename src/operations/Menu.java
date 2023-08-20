package operations;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public int menu() {
		System.out.println();
		System.out.println("1. Display Phone Book in 2D Array.");
		System.out.println("2. Display Phone Book in Hash Map.");
		System.out.println("3. Insert Name in 2D Array. ");
		System.out.println("4. Insert Number in 2D Array.");
		System.out.println("5. Insert Name and Number in Hash Map.");
		System.out.println("6. Time taken for insertion in 2D Array.");
		System.out.println("7. Time taken for insertion in Hash Map.");
		System.out.println("8. Exit.");
		int choice = sc.nextInt();

		return choice;
	}

}
