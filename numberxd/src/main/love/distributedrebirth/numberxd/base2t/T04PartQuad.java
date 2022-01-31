package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetKey;
import love.distributedrebirth.numberxd.base2t.facet.BaseFacetMap;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt1;
import love.distributedrebirth.numberxd.base2t.facet.BasePartSplit4;

/**
 * The distribution by 4.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T04PartQuad implements BasePart,BasePartAlt1,BasePartSplit4 {

	PART_1("˥","0","北","north","N"),
	PART_2("꜒","1","東","east", "E"),
	PART_3("꜖","2","西","west", "W"),
	PART_4("˩","3","南","south","S"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BaseFacetMap bfm = BaseFacetMap.newInstance();
	private static final String ALT_1_NAME = "Cardinal direction";
	private static final String ALT_1_WIKI = "https://simple.wikipedia.org/wiki/Cardinal_direction";
	private static final Map<String, T04PartQuad> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T04PartQuad> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T04PartQuad(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		this.getBFM().putInit(BaseFacetKey.ID_TONE, idTone);
		this.getBFM().putInit(BaseFacetKey.ID_LETTER, idLetter);
		this.getBFM().putInit(BaseFacetKey.CHINA_KEY, chinaKey);
		this.getBFM().putInit(BaseFacetKey.CHINA_VALUE, chinaValue);
		this.getBFM().putInit(BaseFacetKey.ALT_1_VALUE, alt1Value);
		this.getBFM().putInit(BaseFacetKey.ALT_1_NAME, ALT_1_NAME);
		this.getBFM().putInit(BaseFacetKey.ALT_1_WIKI, ALT_1_WIKI);
	}
	
	@Override
	public BaseFacetMap getBFM() {
		return bfm;
	}
	
	public static void forEach(Consumer<T04PartQuad> consumer) {
		for (T04PartQuad value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T04PartQuad valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T04PartQuad valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
