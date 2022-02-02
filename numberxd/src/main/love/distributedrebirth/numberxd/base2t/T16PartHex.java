package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1Infoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKeyʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T16PartHex", purpose = "The distribution by 16.")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "Dual-tone multi-frequency signaling", website = "https://en.wikipedia.org/wiki/Dual-tone_multi-frequency_signaling")
public enum T16PartHex implements BãßBȍőnPartAlt1ʸᴰ<T16PartHex> {

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
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T16PartHex(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
	}
	
	public T02PartBinary splitPartBinary(T04PartQuad part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
