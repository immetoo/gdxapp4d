package love.distributedrebirth.numberxd;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.numberxd.base2t.part.T04PartQuad;
import love.distributedrebirth.numberxd.base2t.type.V036Teger;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class Gê̄ldGetậl {

	private final Gê̄ldGetậlÅtHebrew nummerAlphabet;
	private final Gê̄ldGetậlÅtHebrew nummerDeelA;
	private final Gê̄ldGetậlÅtHebrew nummerDeelB;
	private final Gê̄ldGetậlÅtHebrew nummerDeelC;
	private final double totalDecimalValue;
	private static final Character LEFT_TO_RIGHT_MARK = 0x200E;
	private static final Character RIGHT_TO_LEFT_MARK = 0x200F;
	
	public Gê̄ldGetậl(V036Teger teger) {
		this(
				new Gê̄ldGetậlÅtHebrew(teger.getTytePart(T04PartQuad.PART_1)),
				new Gê̄ldGetậlÅtHebrew(teger.getTytePart(T04PartQuad.PART_2)),
				new Gê̄ldGetậlÅtHebrew(teger.getTytePart(T04PartQuad.PART_3)),
				new Gê̄ldGetậlÅtHebrew(teger.getTytePart(T04PartQuad.PART_4))
			);
	}
	
	public Gê̄ldGetậl(Gê̄ldGetậlÅtHebrew nummerAlphabet, Gê̄ldGetậlÅtHebrew nummerDeelA, Gê̄ldGetậlÅtHebrew nummerDeelB, Gê̄ldGetậlÅtHebrew nummerDeelC) {
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
		this.nummerAlphabet = full;
		this.nummerDeelA = deelA;
		this.nummerDeelB = deelB;
		this.nummerDeelC = deelC;
		this.totalDecimalValue = calculateDecimalValue();
	}
	
	private double calculateDecimalValue() {
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
	
	public Gê̄ldGetậlÅtHebrew getNummerAlphabet() {
		return nummerAlphabet;
	}
	
	public Gê̄ldGetậlÅtHebrew getNummerDeelA() {
		return nummerDeelA;
	}
	
	public Gê̄ldGetậlÅtHebrew getNummerDeelB() {
		return nummerDeelB;
	}
	
	public Gê̄ldGetậlÅtHebrew getNummerDeelC() {
		return nummerDeelC;
	}
	
	public double getTotalDecimalValue() {
		return totalDecimalValue;
	}
	
	public V036Teger toTeger() {
		V036Teger result = new V036Teger();
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
}
