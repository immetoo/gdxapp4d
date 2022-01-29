package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T08PartOctal implements BasePartIdentifierAlt {

	PART_1("˧˥˩","0","˥˩˧", 0),
	PART_2("˧˩˥","1","˩˥˧", 3),
	PART_3("˧˥˦","2","˥˦˧", 6),
	PART_4("˧˩˨","3","˩˨˧", 9),
	PART_5("˧˦˦","4","˦˦˧", 12),
	PART_6("˧˨˨","5","˨˨˧", 15),
	PART_7("˧˥˥","6","˥˥˧", 18),
	PART_8("˧˩˩","7","˩˩˧", 21),
	;
	
	public static int LENGTH = 8;
	public static int BIT_COUNT = 3;
	private static final byte BITMASK = 0x07;
	private final String identifierTone; // absolute
	private final String identifierLetter;
	private final String identifierAlt; // relative	
	private final int shiftBits;
	
	private static final Map<String, T08PartOctal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Tone Letters","https://en.wikipedia.org/wiki/Tone_letter");
	
	private T08PartOctal(String identifierTone, String identifierLetter, String identifierAlt, int shiftBits) {
		this.identifierTone = identifierTone;
		this.identifierLetter = identifierLetter;
		this.identifierAlt = identifierAlt;
		this.shiftBits = shiftBits;
	}
	
	@Override
	public String getIdentifierTone() {
		return identifierTone;
	}
	
	@Override
	public String getIdentifierLetter() {
		return identifierLetter;
	}
	
	@Override
	public String getIdentifierAlt() {
		return identifierAlt;
	}
	
	@Override
	public BasePartIdentifierAltInfo getIdentifierAltInfo() {
		return ALT_INFO;
	}
	
	public int getShiftBits() {
		return shiftBits;
	}
	
	public int ordinalOf(T08PartOctal group) {
		return ordinal() << group.getShiftBits();
	}
	
	public static T08PartOctal indexOf(T08PartOctal group, int value) {
		return T08PartOctal.values()[(value >> group.getShiftBits()) & BITMASK];
	}
	
	public T02PartBinary splitPartBinary(T03PartTrit part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
	
	public static void forEach(Consumer<T08PartOctal> consumer) {
		for (T08PartOctal value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T08PartOctal valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
}
