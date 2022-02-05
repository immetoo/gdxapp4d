package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T05PartPental", purpose = "The distribution by 5 (wuxing).")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "Pentagram", website = "https://en.wikipedia.org/wiki/Pentagram")
@BãßBȍőnPartAlt2Infoʸᴰ(name = "Pythagorean Interpretations", website = "http://wisdomofhypatia.com/OM/BA/PP.html")
public enum T05PartPental implements BãßBȍőnPartAlt2ʸᴰ<T05PartPental> {

	PART_1("˥","火","fire", "EI","heile"),
	PART_2("˦","水","water","U", "hudor"),
	PART_3("˧","木","wood" ,"I", "idea"),
	PART_4("˨","金","gold", "A", "aer"),
	PART_5("˩","土","earth","G", "gaia"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T05PartPental(String dialTone, String chinaKey, String chinaValue, String alt1Value, String alt2Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_2_VALUE, alt2Value);
		BBC.INIT_BOON(this);
	}
}
