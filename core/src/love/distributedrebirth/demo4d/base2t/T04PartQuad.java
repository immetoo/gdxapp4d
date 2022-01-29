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
public enum T04PartQuad implements BasePartIdentifierAlt {

	PART_1("˥","0","N"),
	PART_2("˦","1","E"),
	PART_3("˨","2","W"),
	PART_4("˩","3","S"),
	;
	
	public static int LENGTH = 4;
	private final String identifierTone;
	private final String identifierLetter;
	private final String identifierAlt;
	
	private static final Map<String, T04PartQuad> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Cardinal direction","https://simple.wikipedia.org/wiki/Cardinal_direction");
	
	private T04PartQuad(String identifierTone, String identifierLetter, String identifierAlt) {
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
	
	public T02PartBinary splitPartBinary(T02PartBinary part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
	
	public static void forEach(Consumer<T04PartQuad> consumer) {
		for (T04PartQuad value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T04PartQuad valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
}
