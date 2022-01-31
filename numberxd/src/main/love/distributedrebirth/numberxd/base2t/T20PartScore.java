package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetMap;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt3;

/**
 * The distribution by 20.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T20PartScore implements BasePart,BasePartAlt3 {

	PART_1 ("˥","Y", "尧","yotta","0","0","2"),
	PART_2 ("˦","Z", "泽","zetta","1","1","3"),
	PART_3 ("˧","E", "艾","exa",  "2","2","4"),
	PART_4 ("˨","P", "拍","peta", "3","3","5"),
	PART_5 ("˩","T", "太","tera", "4","4","6"),
	PART_6 ("꜒","G", "吉","giga", "5","5","7"),
	PART_7 ("꜓","M", "兆","mega", "6","6","8"),
	PART_8 ("꜔","k", "千","kilo", "7","7","9"),
	PART_9 ("꜕","h", "百","hecto","8","8","C"),
	PART_10("꜖","da","十","deca", "9","9","F"),
	PART_11("꜈","d", "分","deci", "A","A","G"),
	PART_12("꜉","c", "厘","centi","B","B","H"),
	PART_13("꜊","m", "毫","milli","C","C","J"),
	PART_14("꜋","µ", "微","micro","D","D","M"),
	PART_15("꜌","n", "纳","nano", "E","E","P"),
	PART_16("꜍","p", "皮","pico", "F","F","Q"),
	PART_17("꜎","f", "飞","femto","G","G","R"),
	PART_18("꜏","a", "阿","atto", "H","H","V"),
	PART_19("꜐","z", "仄","zepto","I","J","W"),
	PART_20("꜑","y", "幺","yocto","J","K","X"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BaseFacetMap bfm = BaseFacetMap.newInstance();
	private static final String ALT_1_NAME = "Vigesimal";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/Vigesimal#Places";
	private static final String ALT_2_NAME = "Vigesimal Alternative";
	private static final String ALT_2_WIKI = "https://en.wikipedia.org/wiki/Vigesimal#Places";
	private static final String ALT_3_NAME = "Open Location Code";
	private static final String ALT_3_WIKI = "https://en.wikipedia.org/wiki/Open_Location_Code";
	private static final Map<String, T20PartScore> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T20PartScore> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	private static final Map<String, T20PartScore> OPENLC_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getAlt3Value(), v -> v)));
	
	private T20PartScore(String idTone, String idLetter, String chinaKey, String chinaValue,
			String alt1Value, String alt2Value, String alt3Value) {
		this.getBFM().putInit(BaseFacetKey.ID_TONE, idTone);
		this.getBFM().putInit(BaseFacetKey.ID_LETTER, idLetter);
		this.getBFM().putInit(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getBFM().putInit(BaseFacetKey.CHINA_VALUE, chinaValue);
		this.getBFM().putInit(BaseFacetKey.ALT_1_VALUE, alt1Value);
		this.getBFM().putInit(BaseFacetKey.ALT_1_NAME, ALT_1_NAME);
		this.getBFM().putInit(BaseFacetKey.ALT_1_WIKI, ALT_1_WIKI);
		this.getBFM().putInit(BaseFacetKey.ALT_2_VALUE, alt2Value);
		this.getBFM().putInit(BaseFacetKey.ALT_2_NAME, ALT_2_NAME);
		this.getBFM().putInit(BaseFacetKey.ALT_2_WIKI, ALT_2_WIKI);
		this.getBFM().putInit(BaseFacetKey.ALT_3_VALUE, alt3Value);
		this.getBFM().putInit(BaseFacetKey.ALT_3_NAME, ALT_3_NAME);
		this.getBFM().putInit(BaseFacetKey.ALT_3_WIKI, ALT_3_WIKI);
	}
	
	@Override
	public BaseFacetMap getBFM() {
		return bfm;
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
	
	public static T20PartScore valueOfOpenLC(String openLCKey) {
		return OPENLC_MAP.get(openLCKey);
	}
}
