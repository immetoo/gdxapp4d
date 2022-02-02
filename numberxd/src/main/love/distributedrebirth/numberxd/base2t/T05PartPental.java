package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffin;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpen;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 5 called Wuxing.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T05PartPental", purpose = "The distribution by 5 called Wuxing.")
@BassBoneAlt1Info(name="Pentagram", website="https://en.wikipedia.org/wiki/Pentagram")
@BassBoneAlt2Info(name="Pythagorean Interpretations", website="http://wisdomofhypatia.com/OM/BA/PP.html")
public enum T05PartPental implements BassBoneAlt2<T05PartPental> {

	PART_1("˥","0","火","fire", "EI","heile"),
	PART_2("˦","1","水","water","U", "hudor"),
	PART_3("˧","2","木","wood" ,"I", "idea"),
	PART_4("˨","3","金","gold", "A", "aer"),
	PART_5("˩","4","土","earth","G", "gaia"),
	;
	
	private final BãßBȍőnCoffinOpen<BassBoneStoreKey> BBC = BãßBȍőnCoffinOpen.newInstance();
	public BãßBȍőnCoffin<BassBoneStoreKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T05PartPental(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value) {
		BBC.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
}
