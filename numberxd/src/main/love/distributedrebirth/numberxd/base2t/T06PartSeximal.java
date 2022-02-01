package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 6.
 * 
 * NOTE: The sexi karlson-speaker is china design 3=6 and 6=9 and in quad space, zero is the result.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T06PartSeximal")
@BassBoneAlt1Info(name="ADFGVX cipher", website="https://en.wikipedia.org/wiki/ADFGVX_cipher")
public enum T06PartSeximal implements BassBoneAlt1<T06PartSeximal> {

	PART_1("˦","0","四","4","A"),
	PART_2("˨","1","五","5","D"),
	PART_3("꜓","2","六","6","F"),
	PART_4("꜕","3","七","7","G"),
	PART_5("꜊","4","八","8","V"),
	PART_6("꜏","5","九","9","X"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T06PartSeximal(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
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
	
	public T02PartBinary splitPartBinary() {
		return T02PartBinary.values()[ordinal() & 1];
	}
	
	public T03PartTrit splitPartTrit() {
		return T03PartTrit.values()[ordinal() >> 1];
	}
}
