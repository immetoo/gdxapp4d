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
 * The distribution by 7.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T07PartPlanIt implements BasePart,BasePartAlt1 {

	PART_1("˥","0","♎︎","libra","天秤座"),
	PART_2("꜉","1","♏︎","scorpio","天蠍座"),
	PART_3("꜋","2","♓︎","pisces","雙魚座"),
	PART_4("꜔","3","♍︎","virgo","處女座"),
	PART_5("꜎","4","♋︎","cancer","癌症"),
	PART_6("꜐","5","♑︎","capricorn","摩羯座"),
	PART_7("˩","7","♈︎","aries","白羊座"),
	;
	
	public static int LENGTH() { return values().length; };
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final String ALT_1_NAME = "Fallen sign";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/Classical_planet#Western_astrology";
	private static final Map<String, T07PartPlanIt> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T07PartPlanIt> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T07PartPlanIt(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
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
	
	public static void forEach(Consumer<T07PartPlanIt> consumer) {
		for (T07PartPlanIt value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T07PartPlanIt valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T07PartPlanIt valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
