package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1Info;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2Info;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKey;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartShiftBits;

/**
 * The distribution by 8.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T08PartOctal", purpose = "The distribution by 8.")
@BãßBȍőnPartAlt1Info(name="Absolute Tone Sequence", website="https://en.wikipedia.org/wiki/Tone_letter")
@BãßBȍőnPartAlt2Info(name="Relative Tone Sequence", website="https://en.wikipedia.org/wiki/Tone_letter")
public enum T08PartOctal implements BãßBȍőnPartAlt2<T08PartOctal>,BãßBȍőnPartShiftBits<T08PartOctal> {

	PART_1("˥","0","心","heart","˧˥˩","˥˩˧", 0),
	PART_2("˩","1","頭","head", "˧˩˥","˩˥˧", 3),
	PART_3("꜒","2","眼","eye",  "˧˥˦","˥˦˧", 6),
	PART_4("꜖","3","嘴","mouth","˧˩˨","˩˨˧", 9),
	PART_5("꜈","4","臂","arm",  "˧˦˦","˦˦˧", 12),
	PART_6("꜌","5","手","hand", "˧˨˨","˨˨˧", 15),
	PART_7("꜍","6","肢","leg",  "˧˥˥","˥˥˧", 18),
	PART_8("꜑","7","腳","feet", "˧˩˩","˩˩˧", 21),
	;
	
	public static int BIT_COUNT = 3;
	private static final byte BITMASK = 0x07;
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKey> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T08PartOctal(String identifierTone, String identifierLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value, int shiftBits) {
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_TONE, identifierTone);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_LETTER, identifierLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKey.SHIFT_BITS, Integer.valueOf(shiftBits));
		BBC.PUT_OBJ(BãßBȍőnPartKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ALT_2_VALUE, alt2Value);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_CHINA);
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
