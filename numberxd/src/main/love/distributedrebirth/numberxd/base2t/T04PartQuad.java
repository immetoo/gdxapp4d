package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 4.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T04PartQuad")
@BassBoneAlt1Info(name="Cardinal direction", website="https://simple.wikipedia.org/wiki/Cardinal_direction")
public enum T04PartQuad implements BassBoneAlt1<T04PartQuad> {

	PART_1("˥","0","北","north","N"),
	PART_2("꜒","1","東","east", "E"),
	PART_3("꜖","2","西","west", "W"),
	PART_4("˩","3","南","south","S"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T04PartQuad(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		getBBC().getMapObject(BassBoneStoreKey.MAP_TONE);
		getBBC().getMapObject(BassBoneStoreKey.MAP_CHINA);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
	
	public T02PartBinary splitPartBinary(T02PartBinary part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
