package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBoneShiftBits;
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
public enum T08PartOctal implements BassBoneAlt2<T08PartOctal>,BassBoneShiftBits<T08PartOctal> {

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
	
	private T08PartOctal(String identifierTone, String identifierLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value, int shiftBits) {
		getBBC().putInit(BassBoneStoreKey.ID_TONE, identifierTone);
		getBBC().putInit(BassBoneStoreKey.ID_LETTER, identifierLetter);
		getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		getBBC().putInit(BassBoneStoreKey.SHIFT_BITS, Integer.valueOf(shiftBits));
		getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		getBBC().putInit(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
		getBBC().getMapObject(BassBoneStoreKey.MAP_TONE);
		getBBC().getMapObject(BassBoneStoreKey.MAP_CHINA);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
	
	public static T08PartOctal indexOf(T08PartOctal group, int value) {
		return T08PartOctal.values()[(value >> group.getShiftBits()) & BITMASK];
	}
	
	public T02PartBinary splitPartBinary(T03PartTrit part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
	
	public int ordinalOf(T08PartOctal group) {
		return ordinal() << group.getShiftBits();
	}
}
