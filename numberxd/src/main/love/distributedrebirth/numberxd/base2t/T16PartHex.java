package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.bone.BasePartSplit16;
import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 16.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T16PartHex")
@BassBoneAlt1Info(name="Dual-tone multi-frequency signaling", website="https://en.wikipedia.org/wiki/Dual-tone_multi-frequency_signaling")
public enum T16PartHex implements BassBone,BassBoneAlt1,BasePartSplit16 {

	PART_1 ("˥","0","氫","hydrogen",  "1"),
	PART_2 ("˦","1","氦","helium",    "2"),
	PART_3 ("˨","2","鋰","lithium",   "3"),
	PART_4 ("˩","3","鈹","beryllium", "A"),
	PART_5 ("꜒","4","硼","boron",     "4"),
	PART_6 ("꜓","5","碳","carbon",    "5"),
	PART_7 ("꜕","6","氮","nitrogen",  "6"),
	PART_8 ("꜖","7","氧","oxygen",    "B"),
	PART_9 ("꜈","8","氟","fluorine",  "7"),
	PART_10("꜉","9","氖","neon",      "8"),
	PART_11("꜋","A","鈉","sodium",    "9"),
	PART_12("꜌","B","鎂","magnesium", "C"),
	PART_13("꜍","C","鋁","aluminium", "*"),
	PART_14("꜎","D","矽","silicon",   "0"),
	PART_15("꜐","E","磷","phosphorus","#"),
	PART_16("꜑","F","硫","sulfur",    "D"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T16PartHex> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T16PartHex> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T16PartHex(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
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
