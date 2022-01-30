package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The distribution by 12.
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T12PartUncial implements BasePartIdentifierAlt {

	// TODO: fixup tone letters for 12 parts
	PART_1 ("˥","0","日","sun","0"),
	PART_2 ("˥","1","月","moon","1"),
	PART_3 ("˥","2","星","star","2"),
	PART_4 ("˥","3","山","mountain","3"),
	PART_5 ("˥","4","龍","dragon","4"),
	PART_6 ("˥","5","鳳","phoenix","5"),
	PART_7 ("˥","6","杯","cup","6"),
	PART_8 ("˥","7","藻","pondweed","7"),
	PART_9 ("˥","8","爐","furnace","8"),
	PART_10("˥","9","種","seed","9"),
	PART_11("˥","A","黼","axe","\u218a"), // TURNED DIGIT TWO
	PART_12("˥","B","亞","nozero","\u218b"), // TURNED DIGIT THREE
	;
	
	public static int LENGTH = 12;
	private final String identifierTone;
	private final String identifierLetter;
	private final String chinaKey;
	private final String chinaValue;
	private final String identifierAlt;
	
	private static final Map<String, T12PartUncial> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T12PartUncial> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Transdecimal symbols","https://en.wikipedia.org/wiki/Duodecimal#Transdecimal_symbols");
	
	private T12PartUncial(String identifierTone, String identifierLetter, String chinaKey, String chinaValue, String identifierAlt) {
		this.identifierTone = identifierTone;
		this.identifierLetter = identifierLetter;
		this.chinaKey = chinaKey;
		this.chinaValue = chinaValue;
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
	public String getChinaKey() {
		return chinaKey;
	}
	
	@Override
	public String getChinaValue() {
		return chinaValue;
	}
	
	@Override
	public String getIdentifierAlt() {
		return identifierAlt;
	}
	
	@Override
	public BasePartIdentifierAltInfo getIdentifierAltInfo() {
		return ALT_INFO;
	}
	
	public static void forEach(Consumer<T12PartUncial> consumer) {
		for (T12PartUncial value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T12PartUncial valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T12PartUncial valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
