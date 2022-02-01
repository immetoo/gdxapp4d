package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 7.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T07PartPlanIt")
@BassBoneAlt1Info(name="Fallen sign", website="https://en.wikipedia.org/wiki/Classical_planet#Western_astrology")
public enum T07PartPlanIt implements BassBoneAlt1<T07PartPlanIt> {

	PART_1("˥","0","♎︎","libra","天秤座"),
	PART_2("꜉","1","♏︎","scorpio","天蠍座"),
	PART_3("꜋","2","♓︎","pisces","雙魚座"),
	PART_4("꜔","3","♍︎","virgo","處女座"),
	PART_5("꜎","4","♋︎","cancer","癌症"),
	PART_6("꜐","5","♑︎","capricorn","摩羯座"),
	PART_7("˩","7","♈︎","aries","白羊座"),
	;
	
	public BassBoneCoffin GET_BBC() { return bbc; }
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T07PartPlanIt(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_TONE, idTone);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_LETTER, idLetter);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_KEY, chinaKey);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_TONE);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_CHINA);
	}
}
