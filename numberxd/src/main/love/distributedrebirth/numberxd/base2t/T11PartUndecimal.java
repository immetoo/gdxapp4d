package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetMap;

/**
 * The distribution by 11.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T11PartUndecimal implements BasePart {

	PART_1 ("˥","0","走","walk"),
	PART_2 ("꜈","1","跑","run"),
	PART_3 ("꜉","2","坐","sit"),
	PART_4 ("꜋","3","掛","hang"),
	PART_5 ("꜌","4","鋪","lay"),
	PART_6 ("꜔","5","跳","jump"),
	PART_7 ("꜍","6","落","drop"),
	PART_8 ("꜎","7","寂","lonely"),
	PART_9 ("꜏","8","談","talk"),
	PART_10("꜐","9","春","life"),
	PART_11("˩","=","耦","mate"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BaseFacetMap bfm = BaseFacetMap.newInstance();
	private static final Map<String, T11PartUndecimal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T11PartUndecimal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T11PartUndecimal(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getBFM().putInit(BaseFacetKey.ID_TONE, idTone);
		this.getBFM().putInit(BaseFacetKey.ID_LETTER, idLetter);
		this.getBFM().putInit(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getBFM().putInit(BaseFacetKey.CHINA_VALUE, chinaValue);
	}
	
	@Override
	public BaseFacetMap getBFM() {
		return bfm;
	}
	
	public static void forEach(Consumer<T11PartUndecimal> consumer) {
		for (T11PartUndecimal value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T11PartUndecimal valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T11PartUndecimal valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
