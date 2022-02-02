package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffin;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpen;
import love.distributedrebirth.bassboonyd.BãßBȍőnNaamʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 4.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnNaamʸᴰ("T04PartQuad")
@BassBoneAlt1Info(name="Cardinal direction", website="https://simple.wikipedia.org/wiki/Cardinal_direction")
public enum T04PartQuad implements BassBoneAlt1<T04PartQuad> {

	PART_1("˥","0","北","north","N"),
	PART_2("꜒","1","東","east", "E"),
	PART_3("꜖","2","西","west", "W"),
	PART_4("˩","3","南","south","S"),
	;
	
	private final BãßBȍőnCoffinOpen<BassBoneStoreKey> BBCO = BãßBȍőnCoffinOpen.newInstance();
	public BãßBȍőnCoffin<BassBoneStoreKey> GET_BBC() { return BBCO; }
	public static int LENGTH() { return values().length; };
	
	private T04PartQuad(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBCO.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBCO.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBCO.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBCO.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBCO.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBCO.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBCO.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
	
	public T02PartBinary splitPartBinary(T02PartBinary part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
