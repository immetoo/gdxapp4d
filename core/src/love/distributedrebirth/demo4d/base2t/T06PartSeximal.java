package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * TThe distribution by 6.
 * NOTE: The sexi karlson-speaker is china design 3=6 and 6=9 and in quad space, zero is the result.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T06PartSeximal implements BasePartIdentifierAlt {

	PART_1("˧˥","0","四","4","A"),
	PART_2("˧˩","1","五","5","D"),
	PART_3("˨˦","2","六","6","F"),
	PART_4("˦˨","3","七","7","G"),
	PART_5("˩˧","4","八","8","V"),
	PART_6("˥˧","5","九","9","X"),
	;
	
	public static int LENGTH = 6;
	private final String identifierTone;
	private final String identifierLetter;
	private final String chinaKey;
	private final String chinaValue;
	private final String identifierAlt;
	
	private static final Map<String, T06PartSeximal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T06PartSeximal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"ADFGVX cipher","https://en.wikipedia.org/wiki/ADFGVX_cipher");
	
	private T06PartSeximal(String identifierTone, String identifierLetter, String chinaKey, String chinaValue, String identifierAlt) {
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
	
	public T02PartBinary splitPartBinary() {
		return T02PartBinary.values()[ordinal() & 1];
	}
	
	public T03PartTrit splitPartTrit() {
		return T03PartTrit.values()[ordinal() >> 1];
	}
	
	public static void forEach(Consumer<T06PartSeximal> consumer) {
		for (T06PartSeximal value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T06PartSeximal valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T06PartSeximal valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
