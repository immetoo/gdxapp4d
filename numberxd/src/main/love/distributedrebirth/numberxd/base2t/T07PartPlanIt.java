package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 7.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T07PartPlanIt", purpose = "The distribution by 7.")
@BassBoneAlt1Info(name="Fallen sign", website="https://en.wikipedia.org/wiki/Classical_planet#Western_astrology")
public enum T07PartPlanIt implements BassBoneAlt1<T07PartPlanIt> {

	PART_1("˥","0","♎︎","libra",    "天秤座"),
	PART_2("꜉","1","♏︎","scorpio",  "天蠍座"),
	PART_3("꜋","2","♓︎","pisces",   "雙魚座"),
	PART_4("꜔","3","♍︎","virgo",    "處女座"),
	PART_5("꜎","4","♋︎","cancer",   "癌症"),
	PART_6("꜐","5","♑︎","capricorn","摩羯座"),
	PART_7("˩","7","♈︎","aries",    "白羊座"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BassBoneStoreKey> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BassBoneStoreKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T07PartPlanIt(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
}
