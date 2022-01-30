package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.demo4d.base2t.facet.BaseFacet;
import love.distributedrebirth.demo4d.base2t.facet.BaseFacetKey;

public enum T60Sexagesimal implements BaseFacet {
	// TODO impl too
	PART_1 ("˧","0","","100"),
	PART_2 ("˧","1","","101"), // ?
	PART_3 ("˧","2","",""),
	PART_4 ("˧","3","",""),
	PART_5 ("˧","4","",""),
	PART_6 ("˧","5","",""),
	PART_7 ("˧","6","",""),
	PART_8 ("˧","7","",""),
	PART_9 ("˧","8","",""),
	PART_10("˧","9","",""),
	PART_11("˧","10","",""),
	PART_12("˧","11","",""),
	PART_13("˧","","",""),
	PART_14("˧","","",""),
	PART_15("˧","","",""),
	PART_16("˧","","",""),
	PART_17("˧","","",""),
	PART_18("˧","","",""),
	PART_19("˧","","",""),
	PART_20("˧","","",""),
	PART_21("˧","","",""),
	PART_22("˧","","",""),
	PART_23("˧","","",""),
	PART_24("˧","","",""),
	PART_25("˧","","",""),
	PART_26("˧","","",""),
	PART_27("˧","","",""),
	PART_28("˧","","",""),
	PART_29("˧","","",""),
	PART_30("˧","","",""),
	PART_31("˧","","",""),
	PART_32("˧","","",""),
	PART_33("˧","","",""),
	PART_34("˧","","",""),
	PART_35("˧","","",""),
	PART_36("˧","","",""),
	PART_37("˧","","",""),
	PART_38("˧","","",""),
	PART_39("˧","","",""),
	PART_40("˧","","",""),
	PART_41("˧","","",""),
	PART_42("˧","","",""),
	PART_43("˧","","",""),
	PART_44("˧","","",""),
	PART_45("˧","","",""),
	PART_46("˧","","",""),
	PART_47("˧","","",""),
	PART_48("˧","","",""),
	PART_49("˧","","",""),
	PART_50("˧","","",""),
	PART_51("˧","","",""),
	PART_52("˧","","",""),
	PART_53("˧","","",""),
	PART_54("˧","","",""),
	PART_55("˧","","",""),
	PART_56("˧","","",""),
	PART_57("˧","","",""),
	PART_58("˧","","",""),
	PART_59("˧","","",""),
	PART_60("˧","","",""),
	;
	
	public static int LENGTH = 60;
	private final Map<BaseFacetKey, Object> facetStore = new HashMap<>();
	private static final Map<String, T60Sexagesimal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T60Sexagesimal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T60Sexagesimal(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getFacetStore().put(BaseFacetKey.ID_TONE, idTone);
		this.getFacetStore().put(BaseFacetKey.ID_LETTER, idLetter);
		this.getFacetStore().put(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getFacetStore().put(BaseFacetKey.CHINA_VALUE, chinaValue);
	}
	
	@Override
	public Map<BaseFacetKey, Object> getFacetStore() {
		return facetStore;
	}
	
	public static void forEach(Consumer<T60Sexagesimal> consumer) {
		for (T60Sexagesimal value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T60Sexagesimal valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T60Sexagesimal valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
