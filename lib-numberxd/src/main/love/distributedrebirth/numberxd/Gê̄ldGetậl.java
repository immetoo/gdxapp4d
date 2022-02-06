package love.distributedrebirth.numberxd;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.part.T04PartQuad;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;
import love.distributedrebirth.numberxd.base2t.type.V036Teger;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class Gê̄ldGetậl extends AbstractBaseGetậlMatrix1<Gê̄ldGetậl,V009Tyte> {

	private final V036Teger value;
	private final double totalDecimalValue;
	private static final Character LEFT_TO_RIGHT_MARK = 0x200E;
	private static final Character RIGHT_TO_LEFT_MARK = 0x200F;
	
	public Gê̄ldGetậl(BaseIteratorOctal values) {
		this (new V036Teger(values));
	}
	
	public Gê̄ldGetậl(V036Teger value) {
		this.value = value;
		this.totalDecimalValue = calculateDecimalValue();
	}
	
	public Gê̄ldGetậl(String money) {
		if (money == null) {
			throw new NullPointerException("Can't parse null money");
		}
		if (money.isEmpty()) {
			throw new IllegalArgumentException("Can't parse zero money length");
		}
		if (money.length() > 8) { // RL + 4 chars + 3 vowels
			throw new IllegalArgumentException("Money length should not exceed 8 codepoints");
		}
		List<Gê̄ldGetậlÅtHebrew> result = new ArrayList<>();
		
		Gê̄ldGetậlÅtHebrew geldDigit = null;
		for (int i=0;i<money.length();i++) {
			char codePoint = (char) money.codePointAt(i);
			if (LEFT_TO_RIGHT_MARK.equals(codePoint)) {
				continue;
			}
			if (RIGHT_TO_LEFT_MARK.equals(codePoint)) {
				continue;
			}
			if (geldDigit != null) {
				Gê̄ldGetậlÅtHebrewVowel vowel = Gê̄ldGetậlÅtHebrewVowel.valueOfCharacter(codePoint);
				if (!Gê̄ldGetậlÅtHebrewVowel.NONE.equals(vowel)) {
					geldDigit.setVowel(vowel);
					result.add(geldDigit);
					geldDigit = null;
					continue;
				} else {
					result.add(geldDigit);
				}
			}
			Gê̄ldGetậlÅtHebrewLetter letter = Gê̄ldGetậlÅtHebrewLetter.valueOfCharacter(codePoint);
			if (Gê̄ldGetậlÅtHebrewLetter.NONE.equals(letter)) {
				throw new IllegalArgumentException("Unknown fraction codepoint: 0x"+Integer.toHexString(codePoint));
			}
			geldDigit = new Gê̄ldGetậlÅtHebrew(letter);
		}
		if (geldDigit != null) {
			result.add(geldDigit);
		}
		
		if (result.isEmpty()) {
			throw new IllegalArgumentException("No hebrew money found");
		}
		Gê̄ldGetậlÅtHebrew full = result.get(0);
		Gê̄ldGetậlÅtHebrew deelA = null;
		Gê̄ldGetậlÅtHebrew deelB = null;
		Gê̄ldGetậlÅtHebrew deelC = null;
		if (result.size() > 1) {
			deelA = result.get(1);
		} else {
			deelA = new Gê̄ldGetậlÅtHebrew();
		}
		if (result.size() > 2) {
			deelB = result.get(2);
		} else {
			deelB = new Gê̄ldGetậlÅtHebrew();
		}
		if (result.size() > 3) {
			deelC = result.get(3);
		} else {
			deelC = new Gê̄ldGetậlÅtHebrew();
		}
		value = new V036Teger();
		value.setTytePart(T04PartQuad.PART_1, full.toTyte());
		value.setTytePart(T04PartQuad.PART_2, deelA.toTyte());
		value.setTytePart(T04PartQuad.PART_3, deelB.toTyte());
		value.setTytePart(T04PartQuad.PART_4, deelC.toTyte());
		this.totalDecimalValue = calculateDecimalValue();
	}
	
	private double calculateDecimalValue() {
		Gê̄ldGetậlÅtHebrew nummerAlphabet = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_1));
		Gê̄ldGetậlÅtHebrew nummerDeelA = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_2));
		Gê̄ldGetậlÅtHebrew nummerDeelB = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_3));
		Gê̄ldGetậlÅtHebrew nummerDeelC = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_4));
		boolean hasFourDigits = 
				!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelA.getLetter()) && 
				!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelB.getLetter()) &&
				!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelC.getLetter());
		double totalDecimalValue = nummerAlphabet.toDecimalValue(hasFourDigits);
		if (!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelA.getLetter())) {
			totalDecimalValue += nummerDeelA.toDecimalValue(false);
		}
		if (!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelB.getLetter())) {
			totalDecimalValue += nummerDeelB.toDecimalValue(false);
		}
		if (!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelC.getLetter())) {
			totalDecimalValue += nummerDeelC.toDecimalValue(false);
		}
		return totalDecimalValue;
	}
	
	public double getTotalDecimalValue() {
		return totalDecimalValue;
	}
	
	public String toHebrewString() {
		return toHebrewString(false);
	}
	
	public String toHebrewString(boolean reverse) {
		Gê̄ldGetậlÅtHebrew nummerAlphabet = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_1));
		Gê̄ldGetậlÅtHebrew nummerDeelA = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_2));
		Gê̄ldGetậlÅtHebrew nummerDeelB = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_3));
		Gê̄ldGetậlÅtHebrew nummerDeelC = new Gê̄ldGetậlÅtHebrew(value.getTytePart(T04PartQuad.PART_4));
		StringBuilder buf = new StringBuilder();
		buf.append(RIGHT_TO_LEFT_MARK);
		buf.append(nummerAlphabet.getLetter().getCharacter());
		if (!Gê̄ldGetậlÅtHebrewVowel.NONE.equals(nummerAlphabet.getVowel())) {
			buf.append(nummerAlphabet.getVowel().getCharacter());
		}
		if (!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelA.getLetter())) {
			buf.append(nummerDeelA.getLetter().getCharacter());
			if (!Gê̄ldGetậlÅtHebrewVowel.NONE.equals(nummerDeelA.getVowel())) {
				buf.append(nummerDeelA.getVowel().getCharacter());
			}
		}
		if (!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelB.getLetter())) {
			buf.append(nummerDeelB.getLetter().getCharacter());
			if (!Gê̄ldGetậlÅtHebrewVowel.NONE.equals(nummerDeelB.getVowel())) {
				buf.append(nummerDeelB.getVowel().getCharacter());
			}
		}
		if (!Gê̄ldGetậlÅtHebrewLetter.NONE.equals(nummerDeelC.getLetter())) {
			buf.append(nummerDeelC.getLetter().getCharacter());
			if (!Gê̄ldGetậlÅtHebrewVowel.NONE.equals(nummerDeelC.getVowel())) {
				buf.append(nummerDeelC.getVowel().getCharacter());
			}
		}
		if (reverse) {
			buf.reverse(); // ImGui skips RL marker so renders wrong....
		}
		return buf.toString();
	}
	
	@Override
	public int getMatrix1Length() {
		return T04PartQuad.LENGTH();
	}
	
	@Override
	public V009Tyte getValue() {
		return value.getTytePart(T04PartQuad.values()[matrix1]);
	}
	
	@Override
	public Gê̄ldGetậl toClone(BaseIteratorOctal values) {
		return new Gê̄ldGetậl(values);
	}
	
	@Override
	public BaseIteratorOctal iteratorOctalsByClone() {
		return value.iteratorOctalsByClone();
	}
}
