package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T16PartHex", purpose = "The distribution by 16.")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "Hexadecimal", website = "https://en.wikipedia.org/wiki/Hexadecimal")
public enum T16PartHex implements BãßBȍőnPartAlt1ʸᴰ<T16PartHex> {

	PART_1 ("˥","氫","hydrogen",  "0"),
	PART_2 ("˦","氦","helium",    "1"),
	PART_3 ("˨","鋰","lithium",   "2"),
	PART_4 ("˩","鈹","beryllium", "3"),
	PART_5 ("꜒","硼","boron",     "4"),
	PART_6 ("꜓","碳","carbon",    "5"),
	PART_7 ("꜕","氮","nitrogen",  "6"),
	PART_8 ("꜖","氧","oxygen",    "7"),
	PART_9 ("꜈","氟","fluorine",  "8"),
	PART_10("꜉","氖","neon",      "9"),
	PART_11("꜋","鈉","sodium",    "A"),
	PART_12("꜌","鎂","magnesium", "B"),
	PART_13("꜍","鋁","aluminium", "C"),
	PART_14("꜎","矽","silicon",   "D"),
	PART_15("꜐","磷","phosphorus","E"),
	PART_16("꜑","硫","sulfur",    "F"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T16PartHex(String dialTone, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.INIT_BOON(this);
	}
	
	public T02PartBinary splitPartBinary(T04PartQuad part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
