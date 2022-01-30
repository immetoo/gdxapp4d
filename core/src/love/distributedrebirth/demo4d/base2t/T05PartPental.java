package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.demo4d.base2t.facet.BaseFacet;
import love.distributedrebirth.demo4d.base2t.facet.BaseFacetKey;

/**
 * The distribution by 5 called Wuxing.
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T05PartPental implements BaseFacet {

	PART_1("˥","0","火","fire"),
	PART_2("˦","1","水","water"),
	PART_3("˧","2","木","wood"),
	PART_4("˨","3","金","gold"),
	PART_5("˩","4","土","earth"),
	;
	
	public static int LENGTH = 5;
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final Map<String, T05PartPental> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	
	private T05PartPental(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getFacetStore().put(BaseFacetKey.ID_TONE, idTone);
		this.getFacetStore().put(BaseFacetKey.ID_LETTER, idLetter);
		this.getFacetStore().put(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getFacetStore().put(BaseFacetKey.CHINA_VALUE, chinaValue);
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
}
