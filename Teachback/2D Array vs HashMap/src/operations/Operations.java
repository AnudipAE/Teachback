package operations;

import java.util.Map;
import java.util.Scanner;

import hashMap.HashMapImpl;
import twoDArray.TwoDArrayImpl;

public class Operations {

	//creating scanner object
	Scanner sc = new Scanner(System.in);

	//creating menu class object
	Menu menu = new Menu();

	//creating TwoDArrayImpl class object 
	TwoDArrayImpl t1 = new TwoDArrayImpl();

	//creating HashMapImpl class object 
	HashMapImpl h1 = new HashMapImpl();

	//creating a 2D array
	String[][] array2D;

	//creating hashmap
	Map<String, String> hashMap1;

	//Method for performing operations
	public void operations() {
		int choice = 0;		// creating variable for while loop
		int numEntries = 10;	// variable for creating phone book entries
		array2D = t1.twoDArray(numEntries);	// calling twoDArray method and assigning the value
		hashMap1 = h1.hashMap(numEntries);	// calling hashmap method and assigning the value

		// while loop 
		while (choice != 8) {
			choice = menu.menu();	//calling menu method for displaying the menu

			//starting switch case
			switch (choice) {
			//case 1 for displaying phone book in 2D array	
			case 1: {
				System.out.println("Phone Book in 2D Array : ");
				t1.display2DArray(array2D);
				break;
			}
			//case 2 for displaying phone book in hashMap
			case 2: {
				System.out.println("Phone Book in Hash Map : ");
				h1.displayHashMap(hashMap1);
				break;
			}
			//case 3 for inserting name in 2D array
			case 3: {
				System.out.println("Insertion in 2D Array : ");
				System.out.println("Enter the name row : ");
				int row = sc.nextInt();
				System.out.println("Enter the name column : ");
				int col = sc.nextInt();
				System.out.println("Enter the name : ");
				String name = sc.next();
				t1.insertName(array2D, row, col, name);
				System.out.println("Insertion completed.");
				break;
			}
			//case 4 for inserting number in 2D array
			case 4: {
				System.out.println("Insertion in 2D Array : ");
				System.out.println("Enter the number row : ");
				int row = sc.nextInt();
				System.out.println("Enter the number column : ");
				int col = sc.nextInt();
				System.out.println("Enter the number : ");
				String number = sc.next();
				t1.insertNumber(array2D, row, col, number);
				System.out.println("Insertion completed.");
				break;
			}
			//case 5 for inserting name and number in hashmap
			case 5: {
				System.out.println("Insertion in Hash Map : ");
				System.out.println("Enter the name : ");
				String name = sc.next();
				System.out.println("Enter the number : ");
				String number = sc.next();
				hashMap1.put(number, name);
				h1.displayHashMap(hashMap1);
				System.out.println("Insertion completed.");
				break;
			}
			//case 6 for calculating time taken by 2d array for inserting
			case 6: {
				long startTime = System.nanoTime();

				t1.insertName(array2D, 0, 0, "Raj");

				long endTime = System.nanoTime();
				long elapsedTime = endTime - startTime;
				System.out.println("Time taken: " + elapsedTime + " nanoseconds");
				break;
			}
			//case 7 for calculating time taken by hashmap for inserting
			case 7: {
				long startTime = System.nanoTime();

				hashMap1.put("91-7681754625", "Raj");

				long endTime = System.nanoTime();
				long elapsedTime = endTime - startTime;
				System.out.println("Time taken: " + elapsedTime + " nanoseconds");
				break;
			}
			//case 8 for exiting the program
			case 8: {
				System.out.println("Thank You.");
				System.exit(0);
			}
			//default case
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}// end of switch case
		}//end of while loop

		sc.close(); // closing scanner object
	}// end of method operations

}// end of class operations
