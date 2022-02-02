package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1Infoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2Infoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKeyʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T05PartPental", purpose = "The distribution by 5 called Wuxing.")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "Pentagram", website = "https://en.wikipedia.org/wiki/Pentagram")
@BãßBȍőnPartAlt2Infoʸᴰ(name = "Pythagorean Interpretations", website = "http://wisdomofhypatia.com/OM/BA/PP.html")
public enum T05PartPental implements BãßBȍőnPartAlt2ʸᴰ<T05PartPental> {

	PART_1("˥","0","火","fire", "EI","heile"),
	PART_2("˦","1","水","water","U", "hudor"),
	PART_3("˧","2","木","wood" ,"I", "idea"),
	PART_4("˨","3","金","gold", "A", "aer"),
	PART_5("˩","4","土","earth","G", "gaia"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T05PartPental(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value, String alt2Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_2_VALUE, alt2Value);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
	}
}
