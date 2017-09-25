package model;

import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumber {
		
	private static Map<Integer, String> numberToLetter = new LinkedHashMap<>();
	static {
		numberToLetter.put(1000, "M");
		numberToLetter.put(900, "CM");
		numberToLetter.put(500, "D");
		numberToLetter.put(400, "CD");
		numberToLetter.put(100, "C");
		numberToLetter.put(90, "XC");
		numberToLetter.put(50, "L");
		numberToLetter.put(40, "XL");
		numberToLetter.put(10, "X");
		numberToLetter.put(9, "IX");
		numberToLetter.put(5, "V");
		numberToLetter.put(4, "IV");
		numberToLetter.put(1, "I");
	}
	
	static int convertToArabic(String romano) throws NumberFormatException {
		if (romano.isEmpty()) throw new NumberFormatException("An empty string does not define a roman numeral.");

		romano = romano.toUpperCase();

		int i = 0;
		int arabic = 0;  

		while (i < romano.length()) {

			char letter = romano.charAt(i);
			int number = convertToNumber(letter);

			if (number < 0) throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");

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

	static String convertToRoman(int arabic) throws NumberFormatException {
		if (arabic > 3999 || arabic < 1) throw new NumberFormatException("Invalid value.");

		StringBuilder roman = new StringBuilder();
		for (Map.Entry<Integer, String> pair : numberToLetter.entrySet()) {
			while(arabic >= pair.getKey()){
				roman.append(pair.getValue());
				arabic -= pair.getKey();				
			}		    
		}
		return roman.toString();
	}

	private static int convertToNumber(char letter) {
		switch (letter) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return -1;
		}
	}
}
