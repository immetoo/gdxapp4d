package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

public enum T08PartOctal implements BasePartIdentifierAlt, BasePartIdentifierTone {

	PART_1("0","˧˥˩","˥˩˧", 0),
	PART_2("1","˧˩˥","˩˥˧", 3),
	PART_3("2","˧˥˦","˥˦˧", 6),
	PART_4("3","˧˩˨","˩˨˧", 9),
	PART_5("4","˧˦˦","˦˦˧", 12),
	PART_6("5","˧˨˨","˨˨˧", 15),
	PART_7("6","˧˥˥","˥˥˧", 18),
	PART_8("7","˧˩˩","˩˩˧", 21),
	;
	
	public static int LENGTH = 8;
	private static final byte BITMASK = 0x07;
	private final String identifier;
	private final String identifierAlt;  // absolute
	private final String identifierTone; // relative
	private final int shiftBits;
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Tone Letters","https://en.wikipedia.org/wiki/Tone_letter");
	
	private T08PartOctal(String identifier, String identifierAlt, String identifierTone, int shiftBits) {
		this.identifier = identifier;
		this.identifierAlt = identifierAlt;
		this.identifierTone = identifierTone;
		this.shiftBits = shiftBits;
	}
	
	@Override
	public String getIdentifier() {
		return identifier;
	}
	
	@Override
	public String getIdentifierAlt() {
		return identifierAlt;
	}
	
	@Override
	public String getIdentifierTone() {
		return identifierTone;
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
}
