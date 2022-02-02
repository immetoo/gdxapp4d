package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1Infoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKeyʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnInfoʸᴰ(name = "T11PartUndecimal", purpose = "The distribution by 11.")
@BãßBȍőnPartAlt1Infoʸᴰ(name="Tamil numerals", website="https://en.wikipedia.org/wiki/Tamil_numerals")
public enum T11PartUndecimal implements BãßBȍőnPartAlt1ʸᴰ<T11PartUndecimal> {

	PART_1 ("˥","0","走","walk",  "௦"),
	PART_2 ("꜈","1","跑","run",   "௧"),
	PART_3 ("꜉","2","坐","sit",   "௨"),
	PART_4 ("꜋","3","掛","hang",  "௩"),
	PART_5 ("꜌","4","鋪","lay",   "௪"),
	PART_6 ("꜔","5","跳","jump",  "௫"),
	PART_7 ("꜍","6","落","drop",  "௬"),
	PART_8 ("꜎","7","寂","lonely","௭"),
	PART_9 ("꜏","8","談","talk",  "௮"),
	PART_10("꜐","9","春","life",  "௯"),
	PART_11("˩","=","耦","mate",  "௰"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T11PartUndecimal(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
	}
}
