package hashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nameAndNumberGenerator.NameAndNumberGenerator;

public class HashMapImpl {

	static NameAndNumberGenerator n1 = new NameAndNumberGenerator();

	public Map<String, String> hashMap(int numEntries) {
		Map<String, String> phoneBookMap = new HashMap<>();

		// Populate Hash Map
		List<String> namesMap = n1.generateFictitiousPhoneNumbers(numEntries);
		List<String> phoneNumbersMap = n1.generateFictitiousNames(numEntries);
		for (int i = 0; i < numEntries; i++) {
			phoneBookMap.put(namesMap.get(i), phoneNumbersMap.get(i));
		}

		return phoneBookMap;

	}

	public void displayHashMap(Map<String, String> hashMap) {
		for (Map.Entry<String, String> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(value + "\t " + "\t " + key);
		}
	}

}
