package love.distributedrebirth.demo4d.fraction4d;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.demo4d.base2t.T04PartQuad;
import love.distributedrebirth.demo4d.base2t.V018Tord;
import love.distributedrebirth.demo4d.base2t.V036Teger;

public class Gê̄ldGetậl {

	private final HebrewDigit nummerAlphabet;
	private final HebrewDigit nummerDeelA;
	private final HebrewDigit nummerDeelB;
	private final HebrewDigit nummerDeelC;
	private final double totalDecimalValue;
	private static final Character LEFT_TO_RIGHT_MARK = 0x200E;
	private static final Character RIGHT_TO_LEFT_MARK = 0x200F;
	
	public Gê̄ldGetậl(V036Teger teger) {
		this(
				new HebrewDigit(teger.getTytePart(T04PartQuad.PART_1)),
				new HebrewDigit(teger.getTytePart(T04PartQuad.PART_2)),
				new HebrewDigit(teger.getTytePart(T04PartQuad.PART_3)),
				new HebrewDigit(teger.getTytePart(T04PartQuad.PART_4))
			);
	}
	
	public Gê̄ldGetậl(HebrewDigit nummerAlphabet, HebrewDigit nummerDeelA, HebrewDigit nummerDeelB, HebrewDigit nummerDeelC) {
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
		List<HebrewDigit> result = new ArrayList<>();
		
		HebrewDigit geldDigit = null;
		for (int i=0;i<money.length();i++) {
			char codePoint = (char) money.codePointAt(i);
			if (LEFT_TO_RIGHT_MARK.equals(codePoint)) {
				continue;
			}
			if (RIGHT_TO_LEFT_MARK.equals(codePoint)) {
				continue;
			}
			if (geldDigit != null) {
				HebrewDigitVowel vowel = HebrewDigitVowel.valueOf(codePoint);
				if (!HebrewDigitVowel.NONE.equals(vowel)) {
					geldDigit.setVowel(vowel);
					result.add(geldDigit);
					geldDigit = null;
					continue;
				} else {
					result.add(geldDigit);
				}
			}
			HebrewDigitLetter letter = HebrewDigitLetter.valueOf(codePoint);
			if (HebrewDigitLetter.NONE.equals(letter)) {
				throw new IllegalArgumentException("Unknown fraction codepoint: 0x"+Integer.toHexString(codePoint));
			}
			geldDigit = new HebrewDigit(letter);
		}
		if (geldDigit != null) {
			result.add(geldDigit);
		}
		
		if (result.isEmpty()) {
			throw new IllegalArgumentException("No hebrew money found");
		}
		HebrewDigit full = result.get(0);
		HebrewDigit deelA = null;
		HebrewDigit deelB = null;
		HebrewDigit deelC = null;
		if (result.size() > 1) {
			deelA = result.get(1);
		} else {
			deelA = new HebrewDigit();
		}
		if (result.size() > 2) {
			deelB = result.get(2);
		} else {
			deelB = new HebrewDigit();
		}
		if (result.size() > 3) {
			deelC = result.get(3);
		} else {
			deelC = new HebrewDigit();
		}
		this.nummerAlphabet = full;
		this.nummerDeelA = deelA;
		this.nummerDeelB = deelB;
		this.nummerDeelC = deelC;
		this.totalDecimalValue = calculateDecimalValue();
	}
	
	private double calculateDecimalValue() {
		boolean hasFourDigits = 
				!HebrewDigitLetter.NONE.equals(nummerDeelA.getLetter()) && 
				!HebrewDigitLetter.NONE.equals(nummerDeelB.getLetter()) &&
				!HebrewDigitLetter.NONE.equals(nummerDeelC.getLetter());
		double totalDecimalValue = nummerAlphabet.toDecimalValue(hasFourDigits);
		if (!HebrewDigitLetter.NONE.equals(nummerDeelA.getLetter())) {
			totalDecimalValue += nummerDeelA.toDecimalValue(false);
		}
		if (!HebrewDigitLetter.NONE.equals(nummerDeelB.getLetter())) {
			totalDecimalValue += nummerDeelB.toDecimalValue(false);
		}
		if (!HebrewDigitLetter.NONE.equals(nummerDeelC.getLetter())) {
			totalDecimalValue += nummerDeelC.toDecimalValue(false);
		}
		return totalDecimalValue;
	}
	
	public HebrewDigit getNummerAlphabet() {
		return nummerAlphabet;
	}
	
	public HebrewDigit getNummerDeelA() {
		return nummerDeelA;
	}
	
	public HebrewDigit getNummerDeelB() {
		return nummerDeelB;
	}
	
	public HebrewDigit getNummerDeelC() {
		return nummerDeelC;
	}
	
	public double getTotalDecimalValue() {
		return totalDecimalValue;
	}
	
	public V036Teger toTeger() {
		return new V036Teger(
				new V018Tord(nummerAlphabet.toTyte(), nummerDeelA.toTyte()),
				new V018Tord(nummerDeelB.toTyte(), nummerDeelC.toTyte())
				);
	}
	
	public String toHebrewString() {
		return toHebrewString(false);
	}
	
	public String toHebrewString(boolean reverse) {
		StringBuilder buf = new StringBuilder();
		buf.append(RIGHT_TO_LEFT_MARK);
		buf.append(nummerAlphabet.getLetter().getCharacter());
		if (!HebrewDigitVowel.NONE.equals(nummerAlphabet.getVowel())) {
			buf.append(nummerAlphabet.getVowel().getCharacter());
		}
		if (!HebrewDigitLetter.NONE.equals(nummerDeelA.getLetter())) {
			buf.append(nummerDeelA.getLetter().getCharacter());
			if (!HebrewDigitVowel.NONE.equals(nummerDeelA.getVowel())) {
				buf.append(nummerDeelA.getVowel().getCharacter());
			}
		}
		if (!HebrewDigitLetter.NONE.equals(nummerDeelB.getLetter())) {
			buf.append(nummerDeelB.getLetter().getCharacter());
			if (!HebrewDigitVowel.NONE.equals(nummerDeelB.getVowel())) {
				buf.append(nummerDeelB.getVowel().getCharacter());
			}
		}
		if (!HebrewDigitLetter.NONE.equals(nummerDeelC.getLetter())) {
			buf.append(nummerDeelC.getLetter().getCharacter());
			if (!HebrewDigitVowel.NONE.equals(nummerDeelC.getVowel())) {
				buf.append(nummerDeelC.getVowel().getCharacter());
			}
		}
		if (reverse) {
			buf.reverse(); // ImGui skips RL marker so renders wrong....
		}
		return buf.toString();
	}
}
