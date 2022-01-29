package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T16PartHex implements BasePartIdentifierAlt {

	PART_1 ("˧˥˩","0","1"),
	PART_2 ("˧˩˥","1","2"),
	PART_3 ("˧˥˦","2","3"),
	PART_4 ("˧˩˨","3","A"),
	PART_5 ("˧˦˦","4","4"),
	PART_6 ("˧˨˨","5","5"),
	PART_7 ("˧˥˥","6","6"),
	PART_8 ("˧˩˩","7","B"),
	PART_9 ("˥˩˧","8","7"),
	PART_10("˩˥˧","9","8"),
	PART_11("˥˦˧","A","9"),
	PART_12("˩˨˧","B","C"),
	PART_13("˦˦˧","C","*"),
	PART_14("˨˨˧","D","0"),
	PART_15("˥˥˧","E","#"),
	PART_16("˩˩˧","F","D"),
	;
	
	public static int LENGTH = 16;
	private final String identifierTone;
	private final String identifierLetter;
	private final String identifierAlt;
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Dual-tone multi-frequency signaling","https://en.wikipedia.org/wiki/Dual-tone_multi-frequency_signaling");
	
	private T16PartHex(String identifierTone, String identifierLetter, String identifierAlt) {
		this.identifierTone = identifierTone;
		this.identifierLetter = identifierLetter;
		this.identifierAlt = identifierAlt;
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
	
	public T02PartBinary splitPartBinary(T04PartQuad part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
	
	public static void forEach(Consumer<T16PartHex> consumer) {
		for (T16PartHex value:values()) {
			consumer.accept(value);
		}
	}
}
