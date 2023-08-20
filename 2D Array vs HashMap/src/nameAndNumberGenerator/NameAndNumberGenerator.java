package nameAndNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameAndNumberGenerator {

	private static final String[] FIRST_NAMES = { "Alice", "Bob", "Charlie", "David", "Emma", "Frank", 
			"Grace", "Henry","Isabella", "Jack", "Katherine", "Liam", "Mia", "Noah", "Olivia", "Peter"
			// ... add more first names as needed
	};

	private static final String[] LAST_NAMES = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller",
			"Wilson"
			// ... add more last names as needed
	};

	public List<String> generateFictitiousNames(int numEntries) {
		if (numEntries <= 0) {
			throw new IllegalArgumentException("Number of entries must be a positive integer");
		}

		Random random = new Random();
		List<String> generatedNames = new ArrayList<>();

		for (int i = 0; i < numEntries; i++) {
			String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
			String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
			generatedNames.add(firstName + " " + lastName);
		}

		return generatedNames;
	}
	
	
	public List<String> generateFictitiousPhoneNumbers(int numEntries) {
        if (numEntries <= 0) {
            throw new IllegalArgumentException("Number of entries must be a positive integer");
        }

        Random random = new Random();
        List<String> generatedPhoneNumbers = new ArrayList<>();

        for (int i = 0; i < numEntries; i++) {
            StringBuilder phoneNumber = new StringBuilder("91-");
            for (int j = 0; j < 10; j++) {
                phoneNumber.append(random.nextInt(10));
            }
            generatedPhoneNumbers.add(phoneNumber.toString());
        }

        return generatedPhoneNumbers;
    }

}
