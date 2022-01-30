package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The distribution by 2.
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T02PartBinary implements BasePartIdentifier {

	PART_1("˧","0", "低", "low"),
	PART_2("꜔","1", "高", "high"),
	;
	
	public static int LENGTH = 2;
	private final String identifierTone;
	private final String identifierLetter;
	private final String chinaKey;
	private final String chinaValue;
	
	private static final Map<String, T02PartBinary> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T02PartBinary> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T02PartBinary(String identifierTone, String identifierLetter, String chinaKey, String chinaValue) {
		this.identifierTone = identifierTone;
		this.identifierLetter = identifierLetter;
		this.chinaKey = chinaKey;
		this.chinaValue = chinaValue;
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
	
	public static void forEach(Consumer<T02PartBinary> consumer) {
		for (T02PartBinary value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T02PartBinary valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T02PartBinary valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
