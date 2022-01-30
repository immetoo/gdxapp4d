package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.demo4d.base2t.facet.BaseFacet;
import love.distributedrebirth.demo4d.base2t.facet.BaseFacetKey;
import love.distributedrebirth.demo4d.base2t.facet.BasePartAlt1;

/**
 * The distribution by 12.
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T12PartUncial implements BaseFacet,BasePartAlt1 {

	PART_1 ("˥","0","日","sun","0"),
	PART_2 ("˧","1","月","moon","1"),
	PART_3 ("˩","2","星","star","2"),
	PART_4 ("꜒","3","山","mountain","3"),
	PART_5 ("꜔","4","龍","dragon","4"),
	PART_6 ("꜖","5","鳳","phoenix","5"),
	PART_7 ("꜈","6","杯","cup","6"),
	PART_8 ("꜊","7","藻","pondweed","7"),
	PART_9 ("꜌","8","爐","furnace","8"),
	PART_10("꜍","9","種","seed","9"),
	PART_11("꜏","A","黼","axe","\u218a"), // TURNED DIGIT TWO
	PART_12("꜑","B","亞","nozero","\u218b"), // TURNED DIGIT THREE
	;
	
	public static int LENGTH = 12;
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final String ALT_1_NAME = "Transdecimal symbols";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/Duodecimal#Transdecimal_symbols";
	private static final Map<String, T12PartUncial> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T12PartUncial> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T12PartUncial(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
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
	
	public static void forEach(Consumer<T12PartUncial> consumer) {
		for (T12PartUncial value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T12PartUncial valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T12PartUncial valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
