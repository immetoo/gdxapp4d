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
import love.distributedrebirth.numberxd.base2t.facet.BasePartSplit6;

/**
 * The distribution by 6.
 * 
 * NOTE: The sexi karlson-speaker is china design 3=6 and 6=9 and in quad space, zero is the result.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T06PartSeximal implements BasePart,BasePartAlt1,BasePartSplit6 {

	PART_1("˦","0","四","4","A"),
	PART_2("˨","1","五","5","D"),
	PART_3("꜓","2","六","6","F"),
	PART_4("꜕","3","七","7","G"),
	PART_5("꜊","4","八","8","V"),
	PART_6("꜏","5","九","9","X"),
	;
	
	public static int LENGTH() { return values().length; };
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final String ALT_1_NAME = "ADFGVX cipher";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/ADFGVX_cipher";
	private static final Map<String, T06PartSeximal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T06PartSeximal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T06PartSeximal(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
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
