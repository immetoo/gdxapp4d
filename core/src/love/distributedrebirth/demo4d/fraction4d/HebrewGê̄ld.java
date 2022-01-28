package love.distributedrebirth.demo4d.fraction4d;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.demo4d.base2t.T04PartQuad;
import love.distributedrebirth.demo4d.base2t.V018Tord;
import love.distributedrebirth.demo4d.base2t.V036Teger;

public class HebrewGê̄ld {

	private final HebrewGetậl nummerAlphabet;
	private final HebrewGetậl nummerDeelA;
	private final HebrewGetậl nummerDeelB;
	private final HebrewGetậl nummerDeelC;
	private final double totalDecimalValue;
	private static final Character LEFT_TO_RIGHT_MARK = 0x200E;
	private static final Character RIGHT_TO_LEFT_MARK = 0x200F;
	
	public HebrewGê̄ld(V036Teger teger) {
		this(
				new HebrewGetậl(teger.getTytePart(T04PartQuad.PART_1)),
				new HebrewGetậl(teger.getTytePart(T04PartQuad.PART_2)),
				new HebrewGetậl(teger.getTytePart(T04PartQuad.PART_3)),
				new HebrewGetậl(teger.getTytePart(T04PartQuad.PART_4))
			);
	}
	
	public HebrewGê̄ld(HebrewGetậl nummerAlphabet, HebrewGetậl nummerDeelA, HebrewGetậl nummerDeelB, HebrewGetậl nummerDeelC) {
		this.nummerAlphabet = nummerAlphabet;
		this.nummerDeelA = nummerDeelA;
		this.nummerDeelB = nummerDeelB;
		this.nummerDeelC = nummerDeelC;
		this.totalDecimalValue = calculateDecimalValue();
	}
	
	public HebrewGê̄ld(String money) {
		if (money == null) {
			throw new NullPointerException("Can't parse null money");
		}
		if (money.isEmpty()) {
			throw new IllegalArgumentException("Can't parse zero money length");
		}
		if (money.length() > 8) { // RL + 4 chars + 3 vowels
			throw new IllegalArgumentException("Money length should not exceed 8 codepoints");
		}
		List<HebrewGetậl> result = new ArrayList<>();
		
		HebrewGetậl geldDigit = null;
		for (int i=0;i<money.length();i++) {
			char codePoint = (char) money.codePointAt(i);
			if (LEFT_TO_RIGHT_MARK.equals(codePoint)) {
				continue;
			}
			if (RIGHT_TO_LEFT_MARK.equals(codePoint)) {
				continue;
			}
			if (geldDigit != null) {
				HebrewGetậlVowel vowel = HebrewGetậlVowel.valueOf(codePoint);
				if (!HebrewGetậlVowel.NONE.equals(vowel)) {
					geldDigit.setVowel(vowel);
					result.add(geldDigit);
					geldDigit = null;
					continue;
				} else {
					result.add(geldDigit);
				}
			}
			HebrewGetậlLetter letter = HebrewGetậlLetter.valueOf(codePoint);
			if (HebrewGetậlLetter.NONE.equals(letter)) {
				throw new IllegalArgumentException("Unknown fraction codepoint: 0x"+Integer.toHexString(codePoint));
			}
			geldDigit = new HebrewGetậl(letter);
		}
		if (geldDigit != null) {
			result.add(geldDigit);
		}
		
		if (result.isEmpty()) {
			throw new IllegalArgumentException("No hebrew money found");
		}
		HebrewGetậl full = result.get(0);
		HebrewGetậl deelA = null;
		HebrewGetậl deelB = null;
		HebrewGetậl deelC = null;
		if (result.size() > 1) {
			deelA = result.get(1);
		} else {
			deelA = new HebrewGetậl();
		}
		if (result.size() > 2) {
			deelB = result.get(2);
		} else {
			deelB = new HebrewGetậl();
		}
		if (result.size() > 3) {
			deelC = result.get(3);
		} else {
			deelC = new HebrewGetậl();
		}
		this.nummerAlphabet = full;
		this.nummerDeelA = deelA;
		this.nummerDeelB = deelB;
		this.nummerDeelC = deelC;
		this.totalDecimalValue = calculateDecimalValue();
	}
	
	private double calculateDecimalValue() {
		boolean hasFourDigits = 
				!HebrewGetậlLetter.NONE.equals(nummerDeelA.getLetter()) && 
				!HebrewGetậlLetter.NONE.equals(nummerDeelB.getLetter()) &&
				!HebrewGetậlLetter.NONE.equals(nummerDeelC.getLetter());
		double totalDecimalValue = nummerAlphabet.toDecimalValue(hasFourDigits);
		if (!HebrewGetậlLetter.NONE.equals(nummerDeelA.getLetter())) {
			totalDecimalValue += nummerDeelA.toDecimalValue(false);
		}
		if (!HebrewGetậlLetter.NONE.equals(nummerDeelB.getLetter())) {
			totalDecimalValue += nummerDeelB.toDecimalValue(false);
		}
		if (!HebrewGetậlLetter.NONE.equals(nummerDeelC.getLetter())) {
			totalDecimalValue += nummerDeelC.toDecimalValue(false);
		}
		return totalDecimalValue;
	}
	
	public HebrewGetậl getNummerAlphabet() {
		return nummerAlphabet;
	}
	
	public HebrewGetậl getNummerDeelA() {
		return nummerDeelA;
	}
	
	public HebrewGetậl getNummerDeelB() {
		return nummerDeelB;
	}
	
	public HebrewGetậl getNummerDeelC() {
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
		if (!HebrewGetậlVowel.NONE.equals(nummerAlphabet.getVowel())) {
			buf.append(nummerAlphabet.getVowel().getCharacter());
		}
		if (!HebrewGetậlLetter.NONE.equals(nummerDeelA.getLetter())) {
			buf.append(nummerDeelA.getLetter().getCharacter());
			if (!HebrewGetậlVowel.NONE.equals(nummerDeelA.getVowel())) {
				buf.append(nummerDeelA.getVowel().getCharacter());
			}
		}
		if (!HebrewGetậlLetter.NONE.equals(nummerDeelB.getLetter())) {
			buf.append(nummerDeelB.getLetter().getCharacter());
			if (!HebrewGetậlVowel.NONE.equals(nummerDeelB.getVowel())) {
				buf.append(nummerDeelB.getVowel().getCharacter());
			}
		}
		if (!HebrewGetậlLetter.NONE.equals(nummerDeelC.getLetter())) {
			buf.append(nummerDeelC.getLetter().getCharacter());
			if (!HebrewGetậlVowel.NONE.equals(nummerDeelC.getVowel())) {
				buf.append(nummerDeelC.getVowel().getCharacter());
			}
		}
		if (reverse) {
			buf.reverse(); // ImGui skips RL marker so renders wrong....
		}
		return buf.toString();
	}
}
