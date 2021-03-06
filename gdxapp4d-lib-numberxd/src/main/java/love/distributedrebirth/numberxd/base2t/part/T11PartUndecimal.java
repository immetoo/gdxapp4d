package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T11PartUndecimal", purpose = "The distribution by 11 (human activity).")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "Tamil numerals", website = "https://en.wikipedia.org/wiki/Tamil_numerals")
public enum T11PartUndecimal implements BãßBȍőnPartAlt1ʸᴰ<T11PartUndecimal> {

	PART_1 ("˥","走","walk",  "௦"),
	PART_2 ("꜈","跑","run",   "௧"),
	PART_3 ("꜉","坐","sit",   "௨"),
	PART_4 ("꜋","掛","hang",  "௩"),
	PART_5 ("꜌","鋪","lay",   "௪"),
	PART_6 ("꜔","跳","jump",  "௫"),
	PART_7 ("꜍","落","drop",  "௬"),
	PART_8 ("꜎","寂","lonely","௭"),
	PART_9 ("꜏","談","talk",  "௮"),
	PART_10("꜐","春","life",  "௯"),
	PART_11("˩","耦","mate",  "௰"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T11PartUndecimal(String dialTone, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.BOON_INIT(this);
	}
}
