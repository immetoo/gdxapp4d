package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffin;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpen;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 11.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T11PartUndecimal", purpose = "The distribution by 11.")
@BassBoneAlt1Info(name="Tamil numerals", website="https://en.wikipedia.org/wiki/Tamil_numerals")
public enum T11PartUndecimal implements BassBoneAlt1<T11PartUndecimal> {

	PART_1 ("˥","0","走","walk",  "௦"),
	PART_2 ("꜈","1","跑","run",   "௧"),
	PART_3 ("꜉","2","坐","sit",   "௨"),
	PART_4 ("꜋","3","掛","hang",  "௩"),
	PART_5 ("꜌","4","鋪","lay",   "௪"),
	PART_6 ("꜔","5","跳","jump",  "௫"),
	PART_7 ("꜍","6","落","drop",  "௬"),
	PART_8 ("꜎","7","寂","lonely","௭"),
	PART_9 ("꜏","8","談","talk",  "௮"),
	PART_10("꜐","9","春","life",  "௯"),
	PART_11("˩","=","耦","mate",  "௰"),
	;
	
	private final BãßBȍőnCoffinOpen<BassBoneStoreKey> BBC = BãßBȍőnCoffinOpen.newInstance();
	public BãßBȍőnCoffin<BassBoneStoreKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T11PartUndecimal(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
}
