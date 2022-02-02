package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BaßBȍőnNaamʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 16.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BaßBȍőnNaamʸᴰ("T16PartHex")
@BassBoneAlt1Info(name="Dual-tone multi-frequency signaling", website="https://en.wikipedia.org/wiki/Dual-tone_multi-frequency_signaling")
public enum T16PartHex implements BassBoneAlt1<T16PartHex> {

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
	
	public BassBoneCoffin GET_BBC() { return bbc; }
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T16PartHex(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_TONE, idTone);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_LETTER, idLetter);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_KEY, chinaKey);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_TONE);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_CHINA);
	}
	
	public T02PartBinary splitPartBinary(T04PartQuad part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
