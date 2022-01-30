package love.distributedrebirth.demo4d.fraction4d;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.demo4d.base2t.T04PartQuad;
import love.distributedrebirth.demo4d.base2t.V024Teger;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class Gê̄ldGetậl {

	private final Gê̄ldGetậlHebrew nummerAlphabet;
	private final Gê̄ldGetậlHebrew nummerDeelA;
	private final Gê̄ldGetậlHebrew nummerDeelB;
	private final Gê̄ldGetậlHebrew nummerDeelC;
	private final double totalDecimalValue;
	private static final Character LEFT_TO_RIGHT_MARK = 0x200E;
	private static final Character RIGHT_TO_LEFT_MARK = 0x200F;
	
	public Gê̄ldGetậl(V024Teger teger) {
		this(
				new Gê̄ldGetậlHebrew(teger.getTytePart(T04PartQuad.PART_1)),
				new Gê̄ldGetậlHebrew(teger.getTytePart(T04PartQuad.PART_2)),
				new Gê̄ldGetậlHebrew(teger.getTytePart(T04PartQuad.PART_3)),
				new Gê̄ldGetậlHebrew(teger.getTytePart(T04PartQuad.PART_4))
			);
	}
	
	public Gê̄ldGetậl(Gê̄ldGetậlHebrew nummerAlphabet, Gê̄ldGetậlHebrew nummerDeelA, Gê̄ldGetậlHebrew nummerDeelB, Gê̄ldGetậlHebrew nummerDeelC) {
		this.nummerAlphabet = nummerAlphabet;
		this.nummerDeelA = nummerDeelA;
		this.nummerDeelB = nummerDeelB;
		this.nummerDeelC = nummerDeelC;
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
		List<Gê̄ldGetậlHebrew> result = new ArrayList<>();
		
		Gê̄ldGetậlHebrew geldDigit = null;
		for (int i=0;i<money.length();i++) {
			char codePoint = (char) money.codePointAt(i);
			if (LEFT_TO_RIGHT_MARK.equals(codePoint)) {
				continue;
			}
			if (RIGHT_TO_LEFT_MARK.equals(codePoint)) {
				continue;
			}
			if (geldDigit != null) {
				Gê̄ldGetậlHebrewVowel vowel = Gê̄ldGetậlHebrewVowel.valueOfCharacter(codePoint);
				if (!Gê̄ldGetậlHebrewVowel.NONE.equals(vowel)) {
					geldDigit.setVowel(vowel);
					result.add(geldDigit);
					geldDigit = null;
					continue;
				} else {
					result.add(geldDigit);
				}
			}
			Gê̄ldGetậlHebrewLetter letter = Gê̄ldGetậlHebrewLetter.valueOfCharacter(codePoint);
			if (Gê̄ldGetậlHebrewLetter.NONE.equals(letter)) {
				throw new IllegalArgumentException("Unknown fraction codepoint: 0x"+Integer.toHexString(codePoint));
			}
			geldDigit = new Gê̄ldGetậlHebrew(letter);
		}
		if (geldDigit != null) {
			result.add(geldDigit);
		}
		
		if (result.isEmpty()) {
			throw new IllegalArgumentException("No hebrew money found");
		}
		Gê̄ldGetậlHebrew full = result.get(0);
		Gê̄ldGetậlHebrew deelA = null;
		Gê̄ldGetậlHebrew deelB = null;
		Gê̄ldGetậlHebrew deelC = null;
		if (result.size() > 1) {
			deelA = result.get(1);
		} else {
			deelA = new Gê̄ldGetậlHebrew();
		}
		if (result.size() > 2) {
			deelB = result.get(2);
		} else {
			deelB = new Gê̄ldGetậlHebrew();
		}
		if (result.size() > 3) {
			deelC = result.get(3);
		} else {
			deelC = new Gê̄ldGetậlHebrew();
		}
		this.nummerAlphabet = full;
		this.nummerDeelA = deelA;
		this.nummerDeelB = deelB;
		this.nummerDeelC = deelC;
		this.totalDecimalValue = calculateDecimalValue();
	}
	
	private double calculateDecimalValue() {
		boolean hasFourDigits = 
				!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelA.getLetter()) && 
				!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelB.getLetter()) &&
				!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelC.getLetter());
		double totalDecimalValue = nummerAlphabet.toDecimalValue(hasFourDigits);
		if (!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelA.getLetter())) {
			totalDecimalValue += nummerDeelA.toDecimalValue(false);
		}
		if (!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelB.getLetter())) {
			totalDecimalValue += nummerDeelB.toDecimalValue(false);
		}
		if (!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelC.getLetter())) {
			totalDecimalValue += nummerDeelC.toDecimalValue(false);
		}
		return totalDecimalValue;
	}
	
	public Gê̄ldGetậlHebrew getNummerAlphabet() {
		return nummerAlphabet;
	}
	
	public Gê̄ldGetậlHebrew getNummerDeelA() {
		return nummerDeelA;
	}
	
	public Gê̄ldGetậlHebrew getNummerDeelB() {
		return nummerDeelB;
	}
	
	public Gê̄ldGetậlHebrew getNummerDeelC() {
		return nummerDeelC;
	}
	
	public double getTotalDecimalValue() {
		return totalDecimalValue;
	}
	
	public V024Teger toTeger() {
		V024Teger result = new V024Teger();
		result.setTytePart(T04PartQuad.PART_1, nummerAlphabet.toTyte());
		result.setTytePart(T04PartQuad.PART_2, nummerDeelA.toTyte());
		result.setTytePart(T04PartQuad.PART_3, nummerDeelB.toTyte());
		result.setTytePart(T04PartQuad.PART_4, nummerDeelC.toTyte());
		return result;
	}
	
	public String toHebrewString() {
		return toHebrewString(false);
	}
	
	public String toHebrewString(boolean reverse) {
		StringBuilder buf = new StringBuilder();
		buf.append(RIGHT_TO_LEFT_MARK);
		buf.append(nummerAlphabet.getLetter().getCharacter());
		if (!Gê̄ldGetậlHebrewVowel.NONE.equals(nummerAlphabet.getVowel())) {
			buf.append(nummerAlphabet.getVowel().getCharacter());
		}
		if (!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelA.getLetter())) {
			buf.append(nummerDeelA.getLetter().getCharacter());
			if (!Gê̄ldGetậlHebrewVowel.NONE.equals(nummerDeelA.getVowel())) {
				buf.append(nummerDeelA.getVowel().getCharacter());
			}
		}
		if (!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelB.getLetter())) {
			buf.append(nummerDeelB.getLetter().getCharacter());
			if (!Gê̄ldGetậlHebrewVowel.NONE.equals(nummerDeelB.getVowel())) {
				buf.append(nummerDeelB.getVowel().getCharacter());
			}
		}
		if (!Gê̄ldGetậlHebrewLetter.NONE.equals(nummerDeelC.getLetter())) {
			buf.append(nummerDeelC.getLetter().getCharacter());
			if (!Gê̄ldGetậlHebrewVowel.NONE.equals(nummerDeelC.getVowel())) {
				buf.append(nummerDeelC.getVowel().getCharacter());
			}
		}
		if (reverse) {
			buf.reverse(); // ImGui skips RL marker so renders wrong....
		}
		return buf.toString();
	}
}
