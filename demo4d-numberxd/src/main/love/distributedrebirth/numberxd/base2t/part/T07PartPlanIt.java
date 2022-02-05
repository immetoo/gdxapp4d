package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T07PartPlanIt", purpose = "The distribution by 7.")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "Fallen sign", website = "https://en.wikipedia.org/wiki/Classical_planet#Western_astrology")
public enum T07PartPlanIt implements BãßBȍőnPartAlt1ʸᴰ<T07PartPlanIt> {

	PART_1("˥","♎︎","libra",    "天秤座"),
	PART_2("꜉","♏︎","scorpio",  "天蠍座"),
	PART_3("꜋","♓︎","pisces",   "雙魚座"),
	PART_4("꜔","♍︎","virgo",    "處女座"),
	PART_5("꜎","♋︎","cancer",   "癌症"),
	PART_6("꜐","♑︎","capricorn","摩羯座"),
	PART_7("˩","♈︎","aries",    "白羊座"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T07PartPlanIt(String dialTone, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.INIT_BOON(this);
	}
}
