package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumber {

		
	private Map<Integer, String> numberToLetter = new LinkedHashMap<>();

	public RomanNumber() {
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
	
	public int toArabic(String romano)  throws NumberFormatException {
		if (romano.length() == 0)
			throw new NumberFormatException("An empty string does not define a roman numeral.");

		romano = romano.toUpperCase();

		int i = 0;  
		int arabic = 0;  

		while (i < romano.length()) {

			char letter = romano.charAt(i);
			int number = letterToNumber(letter);  

			if (number < 0) {
				throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");
			}

			i++; 

			if (i == romano.length()) {               
				arabic += number;
			}
			else {
				int nextNumber = letterToNumber(romano.charAt(i));
				if (nextNumber > number) {
					arabic += (nextNumber - number);
					i++;
				}
				else {
					arabic += number;
				}
			}

		}
		return arabic;
	}

	public String toRoman(int arabic) throws NumberFormatException {
		if (arabic > 3999 || arabic < 1) {
			throw new NumberFormatException("Invalid value.");
		}
		String roman = ""; 
		for (Map.Entry<Integer, String> pair : numberToLetter.entrySet()) {
			while(arabic >= pair.getKey()){
				roman += pair.getValue();
				arabic -= pair.getKey();				
			}		    
		}
		return roman;
	}

	private int letterToNumber(char letter) {
		switch (letter) {
		case 'I':  return 1;
		case 'V':  return 5;
		case 'X':  return 10;
		case 'L':  return 50;
		case 'C':  return 100;
		case 'D':  return 500;
		case 'M':  return 1000;
		default:   return -1;
		}
	}
}