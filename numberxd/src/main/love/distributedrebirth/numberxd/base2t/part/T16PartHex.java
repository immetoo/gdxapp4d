package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T16PartHex", purpose = "The distribution by 16.")
public enum T16PartHex implements BãßBȍőnPartʸᴰ<T16PartHex> {

	PART_1 ("˥","0","氫","hydrogen"),
	PART_2 ("˦","1","氦","helium"),
	PART_3 ("˨","2","鋰","lithium"),
	PART_4 ("˩","3","鈹","beryllium"),
	PART_5 ("꜒","4","硼","boron"),
	PART_6 ("꜓","5","碳","carbon"),
	PART_7 ("꜕","6","氮","nitrogen"),
	PART_8 ("꜖","7","氧","oxygen"),
	PART_9 ("꜈","8","氟","fluorine"),
	PART_10("꜉","9","氖","neon"),
	PART_11("꜋","A","鈉","sodium"),
	PART_12("꜌","B","鎂","magnesium"),
	PART_13("꜍","C","鋁","aluminium"),
	PART_14("꜎","D","矽","silicon"),
	PART_15("꜐","E","磷","phosphorus"),
	PART_16("꜑","F","硫","sulfur"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T16PartHex(String idTone, String idLetter, String chinaKey, String chinaValue) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
	}
	
	public T02PartBinary splitPartBinary(T04PartQuad part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
