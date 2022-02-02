package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 6.
 * 
 * NOTE: The sexi karlson-speaker is china design 3=6 and 6=9 and in quad space, zero is the result.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T06PartSeximal", purpose = "The distribution by 6.")
@BassBoneAlt1Info(name="ADFGVX cipher", website="https://en.wikipedia.org/wiki/ADFGVX_cipher")
public enum T06PartSeximal implements BassBoneAlt1<T06PartSeximal> {

	PART_1("˦","0","四","4","A"),
	PART_2("˨","1","五","5","D"),
	PART_3("꜓","2","六","6","F"),
	PART_4("꜕","3","七","7","G"),
	PART_5("꜊","4","八","8","V"),
	PART_6("꜏","5","九","9","X"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BassBoneStoreKey> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BassBoneStoreKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T06PartSeximal(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
	
	public T02PartBinary splitPartBinary() {
		return T02PartBinary.values()[ordinal() & 1];
	}
	
	public T03PartTrit splitPartTrit() {
		return T03PartTrit.values()[ordinal() >> 1];
	}
}
