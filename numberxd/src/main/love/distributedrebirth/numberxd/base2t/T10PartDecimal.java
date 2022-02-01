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
 * The distribution by 10.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T10PartDecimal implements BasePart {

	PART_1 ("˥","0","零","zero"),
	PART_2 ("˦","1","壹","one"),
	PART_3 ("˧","2","貳","two"),
	PART_4 ("˨","3","參","three"),
	PART_5 ("˩","4","肆","four"),
	PART_6 ("꜒","5","伍","five"),
	PART_7 ("꜓","6","陸","six"),
	PART_8 ("꜔","7","柒","seven"),
	PART_9 ("꜕","8","捌","eight"),
	PART_10("꜖","9","玖","nine"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BaseFacetMap bfm = BaseFacetMap.newInstance();
	private static final Map<String, T10PartDecimal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T10PartDecimal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T10PartDecimal(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getBFM().putInit(BaseFacetKey.ID_TONE, idTone);
		this.getBFM().putInit(BaseFacetKey.ID_LETTER, idLetter);
		this.getBFM().putInit(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getBFM().putInit(BaseFacetKey.CHINA_VALUE, chinaValue);
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
