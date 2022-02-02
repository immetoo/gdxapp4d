package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1Info;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKey;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnInfoʸᴰ(name = "T07PartPlanIt", purpose = "The distribution by 7.")
@BãßBȍőnPartAlt1Info(name="Fallen sign", website="https://en.wikipedia.org/wiki/Classical_planet#Western_astrology")
public enum T07PartPlanIt implements BãßBȍőnPartAlt1<T07PartPlanIt> {

	PART_1("˥","0","♎︎","libra",    "天秤座"),
	PART_2("꜉","1","♏︎","scorpio",  "天蠍座"),
	PART_3("꜋","2","♓︎","pisces",   "雙魚座"),
	PART_4("꜔","3","♍︎","virgo",    "處女座"),
	PART_5("꜎","4","♋︎","cancer",   "癌症"),
	PART_6("꜐","5","♑︎","capricorn","摩羯座"),
	PART_7("˩","7","♈︎","aries",    "白羊座"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKey> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T07PartPlanIt(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_CHINA);
	}
}
