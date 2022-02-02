package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T10PartDecimal", purpose = "The distribution by 10.")
public enum T10PartDecimal implements BãßBȍőnPartAlt4ʸᴰ<T10PartDecimal> {
 
	PART_1 ("˥","ō","零","zero"),
	PART_2 ("˦","α","壹","one"),
	PART_3 ("˧","β","貳","two"),
	PART_4 ("˨","γ","參","three"),
	PART_5 ("˩","δ","肆","four"),
	PART_6 ("꜒","ε","伍","five"),
	PART_7 ("꜓","ϝ","陸","six"),
	PART_8 ("꜔","ζ","柒","seven"),
	PART_9 ("꜕","η","捌","eight"),
	PART_10("꜖","θ","玖","nine"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T10PartDecimal(String idTone, String idLetter, String chinaKey, String chinaValue) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
	}
}
