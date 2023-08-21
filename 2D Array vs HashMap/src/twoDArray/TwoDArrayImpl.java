package twoDArray;

import java.util.List;

import nameAndNumberGenerator.NameAndNumberGenerator;

//TwoDArrayImpl class
public class TwoDArrayImpl {

	//creating NameAndNumberGenerator object
	static NameAndNumberGenerator n1 = new NameAndNumberGenerator();

	//Method for creating phone book with 2D array
	public String[][] twoDArray(int numEntries) {

		String[][] phoneBook2D = new String[numEntries][2];
		// Populate 2D Array
		List<String> names2D = n1.generateFictitiousNames(numEntries);
		List<String> phoneNumbers2D = n1.generateFictitiousPhoneNumbers(numEntries);

		for (int i = 0; i < numEntries; i++) {
			phoneBook2D[i][0] = names2D.get(i);
			phoneBook2D[i][1] = phoneNumbers2D.get(i);

		}

		return phoneBook2D;

	}// end of method twoDArray

	//method for displaying the 2D Array
	public void display2DArray(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t" + "\t");
			}
			System.out.println();
		}
	}//end of method display2DArray

	//method for inserting number in 2D Array
	public void insertNumber(String[][] array, int row, int numberColumn, String number) {
		if (row >= 0 && row < array.length && numberColumn >= 0 && numberColumn < array[row].length) {
			array[row][numberColumn] = number;
		} else {
			System.out.println("Invalid row or column index.");
		}
	}//end of method insertNumber

	//method for inserting name in 2D Array
	public void insertName(String[][] array, int row, int nameColumn, String name) {
		if (row >= 0 && row < array.length && nameColumn >= 0 && nameColumn < array[row].length) {
			array[row][nameColumn] = name;
		} else {
			System.out.println("Invalid row or column index.");
		}
	}//end of method insertName

}//end of class TwoDArrayImpl
