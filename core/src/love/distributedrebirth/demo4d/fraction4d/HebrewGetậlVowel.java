package love.distributedrebirth.demo4d.fraction4d;

public enum HebrewGetậlVowel {
	NONE     (0,  (char) 0x0000),
	VOWEL_1  (1,  (char) 0x05B4),
	VOWEL_2  (2,  (char) 0x05B5),
	VOWEL_3  (3,  (char) 0x05B6),
	VOWEL_4  (4,  (char) 0x05B2),
	VOWEL_5  (5,  (char) 0x05C7),
	VOWEL_6  (6,  (char) 0x05B7), // 06 = PATAH
	VOWEL_7  (7,  (char) 0x05A1),
	VOWEL_8  (8,  (char) 0x05A2),
	VOWEL_9  (9,  (char) 0x05A3),
	VOWEL_10 (10, (char) 0x05B9), // 10 = POINT HOLAM
	VOWEL_16 (16, (char) 0x05B8), // 16 = QAMATS
	VOWEL_22 (22, (char) 0x0598),
	VOWEL_30 (30, (char) 0x05BB), // 30 = QUBUTS
	VOWEL_36 (36, (char) 0x05B3), // 36 = HATAF QAMATS
	VOWEL_42 (42, (char) 0x05B1), // 50 = HATEF SEGOL
	;
	
	public static final byte BITMASK = 0b00001111;
	private final int fractionOffset;
	private final char character;
	
	private HebrewGetậlVowel(int fractionOffset, char character) {
		this.fractionOffset = fractionOffset;
		this.character = character;
	}
	
	public int getFractionOffset() {
		return fractionOffset;
	}
	
	public char getCharacter() {
		return character;
	}
	
	public static HebrewGetậlVowel indexOf(int index) {
		return values()[index & BITMASK];
	}
	
	public static HebrewGetậlVowel valueOf(char codePoint) {
		for (HebrewGetậlVowel vowel:values()) {
			if (vowel.getCharacter() == codePoint) {
				return vowel;
			}
		}
		return HebrewGetậlVowel.NONE;
	}
}
