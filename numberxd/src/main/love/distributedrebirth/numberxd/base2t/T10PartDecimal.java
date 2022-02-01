package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt4;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetMap;

/**
 * The distribution by 10.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T10PartDecimal implements BasePart,BasePartAlt4 {
 
	PART_1 ("˥","ō","零","zero", "영","\u1040","০", "෦"),
	PART_2 ("˦","α","壹","one",  "일","\u1041","১", "෧"),
	PART_3 ("˧","β","貳","two",  "이","\u1042","২","෨"),
	PART_4 ("˨","γ","參","three","삼","\u1043","৩","෩"),
	PART_5 ("˩","δ","肆","four", "사","\u1044","৪","෪"),
	PART_6 ("꜒","ε","伍","five", "오","\u1045","৫","෫"),
	PART_7 ("꜓","ϝ","陸","six",  "육","\u1046","৬","෬"),
	PART_8 ("꜔","ζ","柒","seven","칠","\u1047","৭","෭"),
	PART_9 ("꜕","η","捌","eight","팔","\u1048","৮","෮"),
	PART_10("꜖","θ","玖","nine", "구","\u1049","৯","෯"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BaseFacetMap bfm = BaseFacetMap.newInstance();
	private static final String ALT_1_NAME = "Korean numerals";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/Korean_numerals";
	private static final String ALT_2_NAME = "Burmese numerals"; // Escaped to keep stable line height
	private static final String ALT_2_WIKI = "https://en.wikipedia.org/wiki/Burmese_numerals";
	private static final String ALT_3_NAME = "Bengali numerals";
	private static final String ALT_3_WIKI = "https://en.wikipedia.org/wiki/Bengali_numerals";
	private static final String ALT_4_NAME = "Sinhala Lith Illakkam";
	private static final String ALT_4_WIKI = "https://en.wikipedia.org/wiki/Sinhala_numerals#Numerals";
	private static final Map<String, T10PartDecimal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T10PartDecimal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T10PartDecimal(String idTone, String idLetter, String chinaKey, String chinaValue,
			String alt1Value, String alt2Value, String alt3Value, String alt4Value) {
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
		this.getBFM().putInit(BaseFacetKey.ALT_4_VALUE, alt4Value);
		this.getBFM().putInit(BaseFacetKey.ALT_4_NAME, ALT_4_NAME);
		this.getBFM().putInit(BaseFacetKey.ALT_4_WIKI, ALT_4_WIKI);
	}
	
	@Override
	public BaseFacetMap getBFM() {
		return bfm;
	}
	
	public static void forEach(Consumer<T10PartDecimal> consumer) {
		for (T10PartDecimal value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T10PartDecimal valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T10PartDecimal valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
