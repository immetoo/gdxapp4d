package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 11.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T11PartUndecimal")
@BassBoneAlt1Info(name="Tamil numerals", website="https://en.wikipedia.org/wiki/Tamil_numerals")
public enum T11PartUndecimal implements BassBone,BassBoneAlt1 {

	PART_1 ("˥","0","走","walk",  "௦"),
	PART_2 ("꜈","1","跑","run",   "௧"),
	PART_3 ("꜉","2","坐","sit",   "௨"),
	PART_4 ("꜋","3","掛","hang",  "௩"),
	PART_5 ("꜌","4","鋪","lay",   "௪"),
	PART_6 ("꜔","5","跳","jump",  "௫"),
	PART_7 ("꜍","6","落","drop",  "௬"),
	PART_8 ("꜎","7","寂","lonely","௭"),
	PART_9 ("꜏","8","談","talk",  "௮"),
	PART_10("꜐","9","春","life",  "௯"),
	PART_11("˩","=","耦","mate",  "௰"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T11PartUndecimal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T11PartUndecimal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T11PartUndecimal(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		this.getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		this.getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		this.getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
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
