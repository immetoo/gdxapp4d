package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffin;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpen;
import love.distributedrebirth.bassboonyd.BãßBȍőnNaamʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 7.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnNaamʸᴰ("T07PartPlanIt")
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
	
	private final BãßBȍőnCoffinOpen<BassBoneStoreKey> BBCO = BãßBȍőnCoffinOpen.newInstance();
	public BãßBȍőnCoffin<BassBoneStoreKey> GET_BBC() { return BBCO; }
	public static int LENGTH() { return values().length; };
	
	private T07PartPlanIt(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBCO.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBCO.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBCO.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBCO.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBCO.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBCO.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBCO.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
}
