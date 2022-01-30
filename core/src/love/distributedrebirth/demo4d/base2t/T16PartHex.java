package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The distribution by 16.
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T16PartHex implements BasePartIdentifierAlt {

	PART_1 ("˧˥˩","0","氫","hydrogen","1"),
	PART_2 ("˧˩˥","1","氦","helium","2"),
	PART_3 ("˧˥˦","2","鋰","lithium","3"),
	PART_4 ("˧˩˨","3","鈹","beryllium","A"),
	PART_5 ("˧˦˦","4","硼","boron","4"),
	PART_6 ("˧˨˨","5","碳","carbon","5"),
	PART_7 ("˧˥˥","6","氮","nitrogen","6"),
	PART_8 ("˧˩˩","7","氧","oxygen","B"),
	PART_9 ("˥˩˧","8","氟","fluorine","7"),
	PART_10("˩˥˧","9","氖","neon","8"),
	PART_11("˥˦˧","A","鈉","sodium","9"),
	PART_12("˩˨˧","B","鎂","magnesium","C"),
	PART_13("˦˦˧","C","鋁","aluminium","*"),
	PART_14("˨˨˧","D","矽","silicon","0"),
	PART_15("˥˥˧","E","磷","phosphorus","#"),
	PART_16("˩˩˧","F","硫","sulfur","D"),
	;
	
	public static int LENGTH = 16;
	private final String identifierTone;
	private final String identifierLetter;
	private final String chinaKey;
	private final String chinaValue;
	private final String identifierAlt;
	
	private static final Map<String, T16PartHex> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T16PartHex> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Dual-tone multi-frequency signaling","https://en.wikipedia.org/wiki/Dual-tone_multi-frequency_signaling");
	
	private T16PartHex(String identifierTone, String identifierLetter, String chinaKey, String chinaValue, String identifierAlt) {
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
	
	public T02PartBinary splitPartBinary(T04PartQuad part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
	
	public static void forEach(Consumer<T16PartHex> consumer) {
		for (T16PartHex value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T16PartHex valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T16PartHex valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
