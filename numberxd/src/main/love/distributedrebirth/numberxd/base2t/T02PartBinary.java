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
 * The distribution by 2.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T02PartBinary implements BasePart {

	PART_1("˧","0", "低", "low"),
	PART_2("꜔","1", "高", "high"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BaseFacetMap bfm = BaseFacetMap.newInstance();
	private static final Map<String, T02PartBinary> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T02PartBinary> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T02PartBinary(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getBFM().putInit(BaseFacetKey.ID_TONE, idTone);
		this.getBFM().putInit(BaseFacetKey.ID_LETTER, idLetter);
		this.getBFM().putInit(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getBFM().putInit(BaseFacetKey.CHINA_VALUE, chinaValue);
	}
	
	@Override
	public BaseFacetMap getBFM() {
		return bfm;
	}
	
	public static void forEach(Consumer<T02PartBinary> consumer) {
		for (T02PartBinary value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T02PartBinary valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T02PartBinary valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
