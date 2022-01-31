package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt1;

/**
 * The distribution by 20.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T20PartScore implements BasePart,BasePartAlt1 {

	PART_1 ("˥","0","尧","yotta","2"),
	PART_2 ("˦","1","泽","zetta","3"),
	PART_3 ("˧","2","艾","exa",  "4"),
	PART_4 ("˨","3","拍","peta", "5"),
	PART_5 ("˩","4","太","tera", "6"),
	PART_6 ("꜒","5","吉","giga", "7"),
	PART_7 ("꜓","6","兆","mega", "8"),
	PART_8 ("꜔","7","千","kilo", "9"),
	PART_9 ("꜕","8","百","hecto","C"),
	PART_10("꜖","9","十","deca", "F"),
	PART_11("꜈","A","分","deci", "G"),
	PART_12("꜉","B","厘","centi","H"),
	PART_13("꜊","C","毫","milli","J"),
	PART_14("꜋","D","微","micro","M"),
	PART_15("꜌","E","纳","nano", "P"),
	PART_16("꜍","F","皮","pico", "Q"),
	PART_17("꜎","G","飞","femto","R"),
	PART_18("꜏","H","阿","atto", "V"),
	PART_19("꜐","I","仄","zepto","W"),
	PART_20("꜑","J","幺","yocto","X"),
	;
	
	public static int LENGTH = 20;
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final String ALT_1_NAME = "Open Location Code";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/Open_Location_Code";
	private static final Map<String, T20PartScore> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T20PartScore> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T20PartScore(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		this.getFacetStore().put(BaseFacetKey.ID_TONE, idTone);
		this.getFacetStore().put(BaseFacetKey.ID_LETTER, idLetter);
		this.getFacetStore().put(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getFacetStore().put(BaseFacetKey.CHINA_VALUE, chinaValue);
		this.getFacetStore().put(BaseFacetKey.ALT_1_VALUE, alt1Value);
		this.getFacetStore().put(BaseFacetKey.ALT_1_NAME, ALT_1_NAME);
		this.getFacetStore().put(BaseFacetKey.ALT_1_WIKI, ALT_1_WIKI);
	}
	
	@Override
	public Map<BaseFacetKey, Object> getFacetStore() {
		return facetStore;
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
