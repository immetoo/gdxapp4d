package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class Gê̄ldGetậlÅtHebrew {

	private static final double NUMERATOR_ONE = 1d;
	private static final int FRACTION_POWER = 10;
	private Gê̄ldGetậlÅtHebrewLetter letter;
	private Gê̄ldGetậlÅtHebrewVowel vowel;
	
	public Gê̄ldGetậlÅtHebrew() {
		this.letter = Gê̄ldGetậlÅtHebrewLetter.NONE;
		this.vowel = Gê̄ldGetậlÅtHebrewVowel.NONE;
	}
	
	public Gê̄ldGetậlÅtHebrew(Gê̄ldGetậlÅtHebrewLetter letter) {
		this.letter = letter;
		this.vowel = Gê̄ldGetậlÅtHebrewVowel.NONE;
	}
	
	public Gê̄ldGetậlÅtHebrew(V009Tyte tyte) {
		int value0 = tyte.getValue(T03PartTrit.PART_1).getValue().ordinalOf(T08PartOctal.PART_1);
		int value1 = tyte.getValue(T03PartTrit.PART_2).getValue().ordinalOf(T08PartOctal.PART_2);
		int value2 = tyte.getValue(T03PartTrit.PART_3).getValue().ordinalOf(T08PartOctal.PART_3);
		int combinedValue = value0 + value1 + value2;
		letter = Gê̄ldGetậlÅtHebrewLetter.indexOf(combinedValue);
		vowel = Gê̄ldGetậlÅtHebrewVowel.indexOf(combinedValue >> Gê̄ldGetậlÅtHebrewLetter.SHIFT_5);
	}
	
	public V009Tyte toTyte() {
		int combinedValue = letter.ordinal() + (vowel.ordinal() << Gê̄ldGetậlÅtHebrewLetter.SHIFT_5);
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
		if (!Gê̄ldGetậlÅtHebrewVowel.NONE.equals(vowel)) {
			fraction = fraction * Math.pow(FRACTION_POWER, vowel.getFractionOffset());
		}
		double result = NUMERATOR_ONE/fraction;
		return result;
	}
	
	public Gê̄ldGetậlÅtHebrewLetter getLetter() {
		return letter;
	}
	
	public void setLetter(Gê̄ldGetậlÅtHebrewLetter letter) {
		this.letter = letter;
	}
	
	public Gê̄ldGetậlÅtHebrewVowel getVowel() {
		return vowel;
	}
	
	public void setVowel(Gê̄ldGetậlÅtHebrewVowel vowel) {
		this.vowel = vowel;
	}
}
