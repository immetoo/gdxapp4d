package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 2.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T02PartBinary")
public enum T02PartBinary implements BassBone<T02PartBinary> {

	PART_1("˧","0", "低", "low"),
	PART_2("꜔","1", "高", "high"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T02PartBinary(String idTone, String idLetter, String chinaKey, String chinaValue) {
		getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		getBBC().getMapObject(BassBoneStoreKey.MAP_TONE);
		getBBC().getMapObject(BassBoneStoreKey.MAP_CHINA);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
}
