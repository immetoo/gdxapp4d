package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;

/**
 * The distribution by 3.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T03PartTrit implements BasePart {

	PART_1("˦","0","一","1"),
	PART_2("˧","1","二","2"),
	PART_3("˨","2","三","3"),
	;
	
	public static int LENGTH = 3;
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final Map<String, T03PartTrit> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T03PartTrit> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T03PartTrit(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getFacetStore().put(BaseFacetKey.ID_TONE, idTone);
		this.getFacetStore().put(BaseFacetKey.ID_LETTER, idLetter);
		this.getFacetStore().put(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getFacetStore().put(BaseFacetKey.CHINA_VALUE, chinaValue);
	}
	
	@Override
	public Map<BaseFacetKey, Object> getFacetStore() {
		return facetStore;
	}
	
	public static void forEach(Consumer<T03PartTrit> consumer) {
		for (T03PartTrit value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T03PartTrit valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T03PartTrit valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
