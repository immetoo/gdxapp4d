package love.distributedrebirth.demo4d.fraction4d;

import love.distributedrebirth.demo4d.base2t.T03PartTrit;
import love.distributedrebirth.demo4d.base2t.T08PartOctal;
import love.distributedrebirth.demo4d.base2t.V009Tyte;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class Gê̄ldGetậlHebrew {

	private static final double NUMERATOR_ONE = 1d;
	private static final int FRACTION_POWER = 10;
	private Gê̄ldGetậlHebrewLetter letter;
	private Gê̄ldGetậlHebrewVowel vowel;
	
	public Gê̄ldGetậlHebrew() {
		this.letter = Gê̄ldGetậlHebrewLetter.NONE;
		this.vowel = Gê̄ldGetậlHebrewVowel.NONE;
	}
	
	public Gê̄ldGetậlHebrew(Gê̄ldGetậlHebrewLetter letter) {
		this.letter = letter;
		this.vowel = Gê̄ldGetậlHebrewVowel.NONE;
	}
	
	public Gê̄ldGetậlHebrew(V009Tyte tyte) {
		int value0 = tyte.getValue(T03PartTrit.PART_1).getValue().ordinalOf(T08PartOctal.PART_1);
		int value1 = tyte.getValue(T03PartTrit.PART_2).getValue().ordinalOf(T08PartOctal.PART_2);
		int value2 = tyte.getValue(T03PartTrit.PART_3).getValue().ordinalOf(T08PartOctal.PART_3);
		int combinedValue = value0 + value1 + value2;
		letter = Gê̄ldGetậlHebrewLetter.indexOf(combinedValue);
		vowel = Gê̄ldGetậlHebrewVowel.indexOf(combinedValue >> Gê̄ldGetậlHebrewLetter.SHIFT_5);
	}
	
	public V009Tyte toTyte() {
		int combinedValue = letter.ordinal() + (vowel.ordinal() << Gê̄ldGetậlHebrewLetter.SHIFT_5);
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
		if (!Gê̄ldGetậlHebrewVowel.NONE.equals(vowel)) {
			fraction = fraction * Math.pow(FRACTION_POWER, vowel.getFractionOffset());
		}
		double result = NUMERATOR_ONE/fraction;
		return result;
	}
	
	public Gê̄ldGetậlHebrewLetter getLetter() {
		return letter;
	}
	
	public void setLetter(Gê̄ldGetậlHebrewLetter letter) {
		this.letter = letter;
	}
	
	public Gê̄ldGetậlHebrewVowel getVowel() {
		return vowel;
	}
	
	public void setVowel(Gê̄ldGetậlHebrewVowel vowel) {
		this.vowel = vowel;
	}
}
