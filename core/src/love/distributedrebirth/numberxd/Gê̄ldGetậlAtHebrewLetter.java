package love.distributedrebirth.numberxd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum Gê̄ldGetậlAtHebrewLetter {
	// Unicode is horror in any language else than ascii;
	// VS Alphabet order
	// VS Unicode order
	// VS Gematria order <== leading but with other decimals
	
	NONE      (0,  (char) 0x05EF),
	
	LETTER_1  (1,  (char) 0x05D0),
	LETTER_2  (2,  (char) 0x05D1),
	LETTER_3  (3,  (char) 0x05D2),
	LETTER_4  (4,  (char) 0x05D3),
	LETTER_5  (5,  (char) 0x05D4),
	LETTER_6  (6,  (char) 0x05D5),
	LETTER_7  (7,  (char) 0x05D6),
	LETTER_8  (8,  (char) 0x05D7),
	LETTER_9  (9,  (char) 0x05D8),

	LETTER_11 (11, (char) 0x05D9),
	LETTER_12 (12, (char) 0x05DB),
	LETTER_13 (13, (char) 0x05DC),
	LETTER_14 (14, (char) 0x05DE),
	LETTER_15 (15, (char) 0x05E0),
	LETTER_16 (16, (char) 0x05E1),
	LETTER_17 (17, (char) 0x05E2),
	LETTER_18 (18, (char) 0x05E4),
	LETTER_19 (19, (char) 0x05E6),
	
	LETTER_21 (21, (char) 0x05E7),
	LETTER_22 (22, (char) 0x05E8),
	LETTER_23 (23, (char) 0x05E9),
	LETTER_24 (24, (char) 0x05EA),
	LETTER_25 (25, (char) 0x05DA),
	LETTER_26 (26, (char) 0x05DD),
	LETTER_27 (27, (char) 0x05DF),
	LETTER_28 (28, (char) 0x05E3),
	LETTER_29 (29, (char) 0x05E5),
	
/*	// OLD
	LETTER_11 (10, (char) 0x05D9),
	LETTER_12 (20, (char) 0x05DB),
	LETTER_13 (30, (char) 0x05DC),
	LETTER_14 (40, (char) 0x05DE),
	LETTER_15 (50, (char) 0x05E0),
	LETTER_16 (60, (char) 0x05E1),
	LETTER_17 (70, (char) 0x05E2),
	LETTER_18 (80, (char) 0x05E4),
	LETTER_19 (90, (char) 0x05E6),
	
	LETTER_21 (100, (char) 0x05E7),
	LETTER_22 (200, (char) 0x05E8),
	LETTER_23 (300, (char) 0x05E9),
	LETTER_24 (400, (char) 0x05EA),
	LETTER_25 (500, (char) 0x05DA),
	LETTER_26 (600, (char) 0x05DD),
	LETTER_27 (700, (char) 0x05DF),
	LETTER_28 (800, (char) 0x05E3),
	LETTER_29 (900, (char) 0x05E5),
	*/
	LETTER_31 (31, (char) 0x05BE),
	LETTER_32 (32, (char) 0x05C0),
	LETTER_33 (33, (char) 0x05C3),
	LETTER_34 (34, (char) 0x05C6),
	;
	
	public static final byte BITMASK = 0b00011111;
	public static final byte SHIFT_5 = 5;
	private final int decimal;
	private final char character;
	
	private static final Map<Character, Gê̄ldGetậlAtHebrewLetter> CHAR_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getCharacter(), v -> v)));
	
	private Gê̄ldGetậlAtHebrewLetter(int decimal, char character) {
		this.decimal = decimal;
		this.character = character;
	}
	
	public int getDecimal() {
		return decimal;
	}
	
	public char getCharacter() {
		return character;
	}
	
	public static Gê̄ldGetậlAtHebrewLetter indexOf(int index) {
		return values()[index & BITMASK];
	}
	
	public static Gê̄ldGetậlAtHebrewLetter valueOfCharacter(char codePoint) {
		return CHAR_MAP.getOrDefault(codePoint, Gê̄ldGetậlAtHebrewLetter.NONE);
	}
}
