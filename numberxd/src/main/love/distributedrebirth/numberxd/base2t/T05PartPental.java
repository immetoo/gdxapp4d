package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 5 called Wuxing.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T05PartPental")
@BassBoneAlt1Info(name="Pentagram", website="https://en.wikipedia.org/wiki/Pentagram")
@BassBoneAlt2Info(name="Pythagorean Interpretations", website="http://wisdomofhypatia.com/OM/BA/PP.html")
public enum T05PartPental implements BassBone,BassBoneAlt2 {

	PART_1("˥","0","火","fire", "EI","heile"),
	PART_2("˦","1","水","water","U", "hudor"),
	PART_3("˧","2","木","wood" ,"I", "idea"),
	PART_4("˨","3","金","gold", "A", "aer"),
	PART_5("˩","4","土","earth","G", "gaia"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T05PartPental> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T05PartPental> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T05PartPental(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value) {
		this.getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		this.getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		this.getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		this.getBBC().putInit(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
	
	public static void forEach(Consumer<T05PartPental> consumer) {
		for (T05PartPental value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T05PartPental valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T05PartPental valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
