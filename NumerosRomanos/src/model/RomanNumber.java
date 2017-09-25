package model;

import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumber {
		
	private static Map<String, Integer> letterToNumber = new LinkedHashMap<>();
	static {
		letterToNumber.put("M", 1000);
		letterToNumber.put("CM", 900);
		letterToNumber.put("D", 500);
		letterToNumber.put("CD", 400);
		letterToNumber.put("C", 100);
		letterToNumber.put("XC", 90);
		letterToNumber.put("L", 50);
		letterToNumber.put("XL", 40);
		letterToNumber.put("X", 10);
		letterToNumber.put("IX", 9);
		letterToNumber.put("V", 5);
		letterToNumber.put("IV", 4);
		letterToNumber.put("I", 1);
	}

	static String convertToRoman(int arabic) throws NumberFormatException {
		if (arabic > 3999 || arabic < 1) throw new NumberFormatException("Invalid value.");

		StringBuilder roman = new StringBuilder();
		for (Map.Entry<String, Integer> pair : letterToNumber.entrySet()) {
			while(arabic >= pair.getValue()){
				roman.append(pair.getKey());
				arabic -= pair.getValue();
			}
		}
		return roman.toString();
	}

	static int convertToArabic(String romano) throws NumberFormatException {
		if (romano.isEmpty()) throw new NumberFormatException("An empty string does not define a roman numeral.");

		romano = romano.toUpperCase();

		int i = 0;
		int arabic = 0;

		while (i < romano.length()) {

			char letter = romano.charAt(i);
			Integer number = convertToNumber(letter);

			i++;

			if (i == romano.length()) arabic += number;
			else {
				int nextNumber = convertToNumber(romano.charAt(i));
				if (nextNumber > number) {
					arabic += (nextNumber - number);
					i++;
				}
				else arabic += number;
			}

		}
		return arabic;
	}

	private static Integer convertToNumber(char letter) {
		String letterAsString = letter + "";
		Integer number = letterToNumber.get(letterAsString);

		if (number == null) throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");

		return number;
	}
}
