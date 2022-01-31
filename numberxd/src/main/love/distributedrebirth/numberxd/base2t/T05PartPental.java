package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt2;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;

/**
 * The distribution by 5 called Wuxing.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T05PartPental implements BasePart,BasePartAlt2 {

	PART_1("˥","0","火","fire", "EI","heile"),
	PART_2("˦","1","水","water","U", "hudor"),
	PART_3("˧","2","木","wood" ,"I", "idea"),
	PART_4("˨","3","金","gold", "A", "aer"),
	PART_5("˩","4","土","earth","G", "gaia"),
	;
	
	public static int LENGTH() { return values().length; };
	private static final String ALT_1_NAME = "Pentagram";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/Pentagram";
	private static final String ALT_2_NAME = "Pythagorean Interpretations";
	private static final String ALT_2_WIKI = "http://wisdomofhypatia.com/OM/BA/PP.html";
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final Map<String, T05PartPental> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T05PartPental> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T05PartPental(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value) {
		this.getFacetStore().put(BaseFacetKey.ID_TONE, idTone);
		this.getFacetStore().put(BaseFacetKey.ID_LETTER, idLetter);
		this.getFacetStore().put(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getFacetStore().put(BaseFacetKey.CHINA_VALUE, chinaValue);
		this.getFacetStore().put(BaseFacetKey.ALT_1_VALUE, alt1Value);
		this.getFacetStore().put(BaseFacetKey.ALT_1_NAME, ALT_1_NAME);
		this.getFacetStore().put(BaseFacetKey.ALT_1_WIKI, ALT_1_WIKI);
		this.getFacetStore().put(BaseFacetKey.ALT_2_VALUE, alt2Value);
		this.getFacetStore().put(BaseFacetKey.ALT_2_NAME, ALT_2_NAME);
		this.getFacetStore().put(BaseFacetKey.ALT_2_WIKI, ALT_2_WIKI);
	}
	
	@Override
	public Map<BaseFacetKey, Object> getFacetStore() {
		return facetStore;
	}
	
	public static void forEach(Consumer<T05PartPental> consumer) {
		for (T05PartPental value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T05PartPental valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T05PartPental valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
