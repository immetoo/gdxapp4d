package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BaseFacet;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt1;
import love.distributedrebirth.numberxd.base2t.facet.BasePartSplit16;

/**
 * The distribution by 16.
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T16PartHex implements BaseFacet,BasePartAlt1,BasePartSplit16 {

	PART_1 ("˥","0","氫","hydrogen","1"),
	PART_2 ("˦","1","氦","helium","2"),
	PART_3 ("˨","2","鋰","lithium","3"),
	PART_4 ("˩","3","鈹","beryllium","A"),
	PART_5 ("꜒","4","硼","boron","4"),
	PART_6 ("꜓","5","碳","carbon","5"),
	PART_7 ("꜕","6","氮","nitrogen","6"),
	PART_8 ("꜖","7","氧","oxygen","B"),
	PART_9 ("꜈","8","氟","fluorine","7"),
	PART_10("꜉","9","氖","neon","8"),
	PART_11("꜋","A","鈉","sodium","9"),
	PART_12("꜌","B","鎂","magnesium","C"),
	PART_13("꜍","C","鋁","aluminium","*"),
	PART_14("꜎","D","矽","silicon","0"),
	PART_15("꜐","E","磷","phosphorus","#"),
	PART_16("꜑","F","硫","sulfur","D"),
	;
	
	public static int LENGTH = 16;
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final String ALT_1_NAME = "Dual-tone multi-frequency signaling";
	private static final String ALT_1_WIKI = "https://en.wikipedia.org/wiki/Dual-tone_multi-frequency_signaling";
	private static final Map<String, T16PartHex> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T16PartHex> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T16PartHex(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
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
	
	public static void forEach(Consumer<T16PartHex> consumer) {
		for (T16PartHex value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T16PartHex valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T16PartHex valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
