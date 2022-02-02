package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffin;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpen;
import love.distributedrebirth.bassboonyd.BãßBȍőnNaamʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 3.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnNaamʸᴰ("T03PartTrit")
public enum T03PartTrit implements BassBone<T03PartTrit> {

	PART_1("˦","0","一","1"),
	PART_2("˧","1","二","2"),
	PART_3("˨","2","三","3"),
	;
	
	private final BãßBȍőnCoffinOpen<BassBoneStoreKey> BBCO = BãßBȍőnCoffinOpen.newInstance();
	public BãßBȍőnCoffin<BassBoneStoreKey> GET_BBC() { return BBCO; }
	public static int LENGTH() { return values().length; };
	
	private T03PartTrit(String idTone, String idLetter, String chinaKey, String chinaValue) {
		BBCO.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBCO.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBCO.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBCO.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBCO.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBCO.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
}
