package love.distributedrebirth.demo4d.fraction4d;

import love.distributedrebirth.demo4d.base2t.T03PartTrit;
import love.distributedrebirth.demo4d.base2t.T08PartOctal;
import love.distributedrebirth.demo4d.base2t.V009Tyte;

public class HebrewGetậl {

	private static final double NUMERATOR_ONE = 1d;
	private static final int FRACTION_POWER = 10;
	private HebrewGetậlLetter letter;
	private HebrewGetậlVowel vowel;
	
	public HebrewGetậl() {
		this.letter = HebrewGetậlLetter.NONE;
		this.vowel = HebrewGetậlVowel.NONE;
	}
	
	public HebrewGetậl(HebrewGetậlLetter letter) {
		this.letter = letter;
		this.vowel = HebrewGetậlVowel.NONE;
	}
	
	public HebrewGetậl(V009Tyte tyte) {
		int value0 = tyte.getValue(T03PartTrit.PART_1).getValue().ordinalOf(T08PartOctal.PART_1);
		int value1 = tyte.getValue(T03PartTrit.PART_2).getValue().ordinalOf(T08PartOctal.PART_2);
		int value2 = tyte.getValue(T03PartTrit.PART_3).getValue().ordinalOf(T08PartOctal.PART_3);
		int combinedValue = value0 + value1 + value2;
		letter = HebrewGetậlLetter.indexOf(combinedValue);
		vowel = HebrewGetậlVowel.indexOf(combinedValue >> HebrewGetậlLetter.SHIFT_5);
	}
	
	public V009Tyte toTyte() {
		int combinedValue = letter.ordinal() + (vowel.ordinal() << HebrewGetậlLetter.SHIFT_5);
		T08PartOctal value0 = T08PartOctal.indexOf(T08PartOctal.PART_1, combinedValue);
		T08PartOctal value1 = T08PartOctal.indexOf(T08PartOctal.PART_2, combinedValue);
		T08PartOctal value2 = T08PartOctal.indexOf(T08PartOctal.PART_3, combinedValue);
		return new V009Tyte(value0, value1, value2);
	}
	
	public double toDecimalValue(boolean firstChar) {
		double fraction = letter.getDecimal();
		if (firstChar) {
			return fraction; // use full value
		}
		if (!HebrewGetậlVowel.NONE.equals(vowel)) {
			fraction = fraction * Math.pow(FRACTION_POWER, vowel.getFractionOffset());
		}
		double result = NUMERATOR_ONE/fraction;
		return result;
	}
	
	public HebrewGetậlLetter getLetter() {
		return letter;
	}
	
	public void setLetter(HebrewGetậlLetter letter) {
		this.letter = letter;
	}
	
	public HebrewGetậlVowel getVowel() {
		return vowel;
	}
	
	public void setVowel(HebrewGetậlVowel vowel) {
		this.vowel = vowel;
	}
}
