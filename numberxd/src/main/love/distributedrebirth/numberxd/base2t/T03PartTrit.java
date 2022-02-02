package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPart;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKey;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnInfoʸᴰ(name = "T03PartTrit", purpose = "The distribution by 3.")
public enum T03PartTrit implements BãßBȍőnPart<T03PartTrit> {

	PART_1("˦","0","一","1"),
	PART_2("˧","1","二","2"),
	PART_3("˨","2","三","3"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKey> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T03PartTrit(String idTone, String idLetter, String chinaKey, String chinaValue) {
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_VALUE, chinaValue);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_CHINA);
	}
}
