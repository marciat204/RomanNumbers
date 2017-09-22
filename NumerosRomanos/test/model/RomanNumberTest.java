package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumberTest {

	@Test
	public void shouldConvertI() {
		RomanNumber numeroRomano = new RomanNumber();

		int arabic = numeroRomano.toArabic("i");

		assertEquals(arabic, 1);
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenRomanIsEmpty() {
		RomanNumber numeroRomano = new RomanNumber();

		numeroRomano.toArabic("");
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenInvalidRoman() {
		RomanNumber numeroRomano = new RomanNumber();

		numeroRomano.toArabic("XXy");
	}
	
	@Test
	public void shouldAddInArabic() {
		RomanNumber numeroRomano = new RomanNumber();
		int arabic = numeroRomano.toArabic("XX");
		
		assertEquals(arabic, 20);
	}
	
	@Test
	public void shouldSubInArabic() {
		RomanNumber numeroRomano = new RomanNumber();
		int arabic = numeroRomano.toArabic("iV");
		
		assertEquals(arabic, 4);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenNumberIsLessThan1() {
		RomanNumber numeroRomano = new RomanNumber();

		numeroRomano.toRoman(0);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowExceptionWhenNumberIsGreatherThan3999() {
		RomanNumber numeroRomano = new RomanNumber();

		numeroRomano.toRoman(4000);
	}
	
	@Test
	public void shouldConvertComplexNumber() {
		RomanNumber numeroRomano = new RomanNumber();
		String roman = numeroRomano.toRoman(944);
		
		assertEquals(roman, "CMXLIV");
	}
}
