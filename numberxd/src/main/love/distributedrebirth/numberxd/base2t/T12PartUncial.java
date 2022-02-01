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
 * The distribution by 12.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T12PartUncial")
@BassBoneAlt1Info(name="Transdecimal symbols", website="https://en.wikipedia.org/wiki/Duodecimal#Transdecimal_symbols")
public enum T12PartUncial implements BassBone,BassBoneAlt1 {

	PART_1 ("˥","0","日","sun",     "0"),
	PART_2 ("˧","1","月","moon",    "1"),
	PART_3 ("˩","2","星","star",    "2"),
	PART_4 ("꜒","3","山","mountain","3"),
	PART_5 ("꜔","4","龍","dragon",  "4"),
	PART_6 ("꜖","5","鳳","phoenix", "5"),
	PART_7 ("꜈","6","杯","cup",     "6"),
	PART_8 ("꜊","7","藻","pondweed","7"),
	PART_9 ("꜌","8","爐","furnace", "8"),
	PART_10("꜍","9","種","seed",    "9"),
	PART_11("꜏","A","黼","axe",     "\u218a"), // TURNED DIGIT TWO
	PART_12("꜑","B","亞","nozero",  "\u218b"), // TURNED DIGIT THREE
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T12PartUncial> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T12PartUncial> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T12PartUncial(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
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
