package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The distribution by 20.
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T20PartScore implements BasePartIdentifierAlt {

	PART_1 ("˥","0","尧","yotta","2"),
	PART_2 ("˦","1","泽","zetta","3"),
	PART_3 ("˧","2","艾","exa","4"),
	PART_4 ("˨","3","拍","peta","5"),
	PART_5 ("˩","4","太","tera","6"),
	PART_6 ("꜒","5","吉","giga","7"),
	PART_7 ("꜓","6","兆","mega","8"),
	PART_8 ("꜔","7","千","kilo","9"),
	PART_9 ("꜕","8","百","hecto","C"),
	PART_10("꜖","9","十","deca","F"),
	PART_11("꜈","A","分","deci","G"),
	PART_12("꜉","B","厘","centi","H"),
	PART_13("꜊","C","毫","milli","J"),
	PART_14("꜋","D","微","micro","M"),
	PART_15("꜌","E","纳","nano","P"),
	PART_16("꜍","F","皮","pico","Q"),
	PART_17("꜎","G","飞","femto","R"),
	PART_18("꜏","H","阿","atto","V"),
	PART_19("꜐","I","仄","zepto","W"),
	PART_20("꜑","J","幺","yocto","X"),
	;
	
	public static int LENGTH = 20;
	private final String identifierTone;
	private final String identifierLetter;
	private final String chinaKey;
	private final String chinaValue;
	private final String identifierAlt;
	
	private static final Map<String, T20PartScore> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T20PartScore> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Open Location Code","https://en.wikipedia.org/wiki/Open_Location_Code");
	
	private T20PartScore(String identifierTone, String identifierLetter, String chinaKey, String chinaValue, String identifierAlt) {
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
	
	public static void forEach(Consumer<T20PartScore> consumer) {
		for (T20PartScore value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T20PartScore valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T20PartScore valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
