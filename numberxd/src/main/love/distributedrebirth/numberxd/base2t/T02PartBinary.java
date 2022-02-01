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
	
	public BassBoneCoffin GET_BBC() { return bbc; }
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T02PartBinary(String idTone, String idLetter, String chinaKey, String chinaValue) {
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_TONE, idTone);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_LETTER, idLetter);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_KEY, chinaKey);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_TONE);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_CHINA);
	}
}
