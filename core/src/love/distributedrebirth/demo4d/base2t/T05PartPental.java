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
public enum T05PartPental implements BasePartIdentifierAlt {

	PART_1("˥","0","\u706b"),
	PART_2("˦","1","\u571f"),
	PART_3("˧","2","\u91d1"),
	PART_4("˨","3","\u6c34"),
	PART_5("˩","4","\u6728"),
	;
	
	public static int LENGTH = 5;
	private final String identifierTone;
	private final String identifierLetter;
	private final String identifierAlt; // FIXME: escaped to keep normal line height in IDE
	
	private static final Map<String, T05PartPental> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Wuxing","https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)");
	
	private T05PartPental(String identifierTone, String identifierLetter, String identifierAlt) {
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
	
	public static void forEach(Consumer<T05PartPental> consumer) {
		for (T05PartPental value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T05PartPental valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
}
