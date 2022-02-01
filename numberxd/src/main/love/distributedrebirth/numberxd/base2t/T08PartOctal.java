package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.bone.BasePartSplit8;
import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 8.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T08PartOctal")
@BassBoneAlt1Info(name="Absolute Tone Sequence", website="https://en.wikipedia.org/wiki/Tone_letter")
@BassBoneAlt2Info(name="Relative Tone Sequence", website="https://en.wikipedia.org/wiki/Tone_letter")
public enum T08PartOctal implements BassBone,BassBoneAlt2,BasePartSplit8 {

	PART_1("˥","0","心","heart","˧˥˩","˥˩˧", 0),
	PART_2("˩","1","頭","head", "˧˩˥","˩˥˧", 3),
	PART_3("꜒","2","眼","eye",  "˧˥˦","˥˦˧", 6),
	PART_4("꜖","3","嘴","mouth","˧˩˨","˩˨˧", 9),
	PART_5("꜈","4","臂","arm",  "˧˦˦","˦˦˧", 12),
	PART_6("꜌","5","手","hand", "˧˨˨","˨˨˧", 15),
	PART_7("꜍","6","肢","leg",  "˧˥˥","˥˥˧", 18),
	PART_8("꜑","7","腳","feet", "˧˩˩","˩˩˧", 21),
	;
	
	public static int LENGTH() { return values().length; };
	public static int BIT_COUNT = 3;
	private static final byte BITMASK = 0x07;
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T08PartOctal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T08PartOctal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T08PartOctal(String identifierTone, String identifierLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value, int shiftBits) {
		this.getBBC().putInit(BassBoneStoreKey.ID_TONE, identifierTone);
		this.getBBC().putInit(BassBoneStoreKey.ID_LETTER, identifierLetter);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		this.getBBC().putInit(BassBoneStoreKey.SHIFT_BITS, Integer.valueOf(shiftBits));
		this.getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		this.getBBC().putInit(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
	
	public static T08PartOctal indexOf(T08PartOctal group, int value) {
		return T08PartOctal.values()[(value >> group.getShiftBits()) & BITMASK];
	}
	
	public static void forEach(Consumer<T08PartOctal> consumer) {
		for (T08PartOctal value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T08PartOctal valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T08PartOctal valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
