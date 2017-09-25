package model;

import static model.RomanNumber.convertToArabic;
import static model.RomanNumber.convertToRoman;
import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumberTest {

	@Test
	public void shouldConvertI() {
		assertEquals(convertToArabic("i"), 1);
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenRomanIsEmpty() {
		convertToArabic("");
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenInvalidRoman() {
		convertToArabic("XXy");
	}
	
	@Test
	public void shouldAddInArabic() {
		assertEquals(convertToArabic("XX"), 20);
	}
	
	@Test
	public void shouldSubInArabic() {
		assertEquals(convertToArabic("iV"), 4);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenNumberIsLessThan1() {
		convertToRoman(0);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenNumberIsGreatherThan3999() {
		convertToRoman(4000);
	}
	
	@Test
	public void shouldConvertComplexNumber() {
		assertEquals(convertToRoman(944), "CMXLIV");
	}
}
