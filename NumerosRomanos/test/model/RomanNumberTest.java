package model;

import static model.RomanNumber.toArabic;
import static model.RomanNumber.toRoman;
import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumberTest {

	@Test
	public void shouldConvertI() {
		assertEquals(toArabic("i"), 1);
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenRomanIsEmpty() {
		toArabic("");
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenInvalidRoman() {
		toArabic("XXy");
	}
	
	@Test
	public void shouldAddInArabic() {
		assertEquals(toArabic("XX"), 20);
	}
	
	@Test
	public void shouldSubInArabic() {
		assertEquals(toArabic("iV"), 4);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenNumberIsLessThan1() {
		toRoman(0);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenNumberIsGreatherThan3999() {
		toRoman(4000);
	}
	
	@Test
	public void shouldConvertComplexNumber() {
		assertEquals(toRoman(944), "CMXLIV");
	}
}
