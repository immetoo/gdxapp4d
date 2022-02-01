package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 5 called Wuxing.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T05PartPental")
@BassBoneAlt1Info(name="Pentagram", website="https://en.wikipedia.org/wiki/Pentagram")
@BassBoneAlt2Info(name="Pythagorean Interpretations", website="http://wisdomofhypatia.com/OM/BA/PP.html")
public enum T05PartPental implements BassBoneAlt2<T05PartPental> {

	PART_1("˥","0","火","fire", "EI","heile"),
	PART_2("˦","1","水","water","U", "hudor"),
	PART_3("˧","2","木","wood" ,"I", "idea"),
	PART_4("˨","3","金","gold", "A", "aer"),
	PART_5("˩","4","土","earth","G", "gaia"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T05PartPental(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value) {
		getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		getBBC().putInit(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
		getBBC().getMapObject(BassBoneStoreKey.MAP_TONE);
		getBBC().getMapObject(BassBoneStoreKey.MAP_CHINA);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
}
