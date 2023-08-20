package operations;

import java.util.Map;
import java.util.Scanner;

import hashMap.HashMapImpl;
import twoDArray.TwoDArrayImpl;

public class Operations {

	Scanner sc = new Scanner(System.in);

	Menu menu = new Menu();

	TwoDArrayImpl t1 = new TwoDArrayImpl();

	HashMapImpl h1 = new HashMapImpl();

	String[][] array2D;

	Map<String, String> hashMap1;

	public void operations() {
		int choice = 0;
		int numEntries = 10;
		array2D = t1.twoDArray(numEntries);
		hashMap1 = h1.hashMap(numEntries);

		while (choice != 8) {
			choice = menu.menu();
			switch (choice) {
			case 1: {
				System.out.println("Phone Book in 2D Array : ");
				t1.display2DArray(array2D);
				break;
			}
			case 2: {
				System.out.println("Phone Book in Hash Map : ");
				h1.displayHashMap(hashMap1);
				break;
			}
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
			case 6: {
				long startTime = System.nanoTime();

				t1.insertName(array2D, 0, 0, "Raj");

				long endTime = System.nanoTime();
				long elapsedTime = endTime - startTime;
				System.out.println("Time taken: " + elapsedTime + " nanoseconds");
				break;
			}
			case 7: {
				long startTime = System.nanoTime();

				hashMap1.put("91-7681754625", "Raj");

				long endTime = System.nanoTime();
				long elapsedTime = endTime - startTime;
				System.out.println("Time taken: " + elapsedTime + " nanoseconds");
				break;
			}
			case 8: {
				System.out.println("Thank You.");
				System.exit(0);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}

		sc.close();
	}

}
